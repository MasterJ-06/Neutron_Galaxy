package neutrongalaxy.masterj.neutrongalaxy.events;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import neutrongalaxy.masterj.neutrongalaxy.NeutronGalaxy;
import neutrongalaxy.masterj.neutrongalaxy.client.ClientTempData;
import neutrongalaxy.masterj.neutrongalaxy.init.DimensionInit;
import neutrongalaxy.masterj.neutrongalaxy.init.FluidInit;
import neutrongalaxy.masterj.neutrongalaxy.init.ItemInit;
import neutrongalaxy.masterj.neutrongalaxy.integration.GetCurios;
import neutrongalaxy.masterj.neutrongalaxy.networking.ModPackets;
import neutrongalaxy.masterj.neutrongalaxy.networking.packet.TempDataSyncS2CPacket;
import neutrongalaxy.masterj.neutrongalaxy.temp.PlayerTemp;
import neutrongalaxy.masterj.neutrongalaxy.temp.PlayerTempProvider;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Mod.EventBusSubscriber(modid = NeutronGalaxy.MODID)
public class ModEvents {
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if(event.getType() == VillagerProfession.FARMER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(FluidInit.ROCKET_FUEL.bucket.get(), 1);
            int villagerLevel = 2;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 7),
                    stack,10,8,0.02F));
        }
    }

    @SubscribeEvent
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event) {
        if(event.getObject() instanceof Player) {
            if(!event.getObject().getCapability(PlayerTempProvider.PLAYER_TEMP).isPresent()) {
                event.addCapability(new ResourceLocation(NeutronGalaxy.MODID, "properties"), new PlayerTempProvider());
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        if(event.isWasDeath()) {
            event.getOriginal().getCapability(PlayerTempProvider.PLAYER_TEMP).ifPresent(oldStore -> {
                event.getOriginal().getCapability(PlayerTempProvider.PLAYER_TEMP).ifPresent(newStore -> {
                    newStore.copyFrom(oldStore);
                });
            });
        }
    }

    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.register(PlayerTemp.class);
    }

    @SubscribeEvent
    public static void onPlayerJoinWorld(EntityJoinLevelEvent event) {
        if(!event.getLevel().isClientSide()) {
            if(event.getEntity() instanceof ServerPlayer player) {
                player.getCapability(PlayerTempProvider.PLAYER_TEMP).ifPresent(temp -> {
                    ModPackets.sendToPlayer(new TempDataSyncS2CPacket(temp.getTemp()), player);
                });
            }
        }
    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
//        if(event.side == LogicalSide.CLIENT) {
            try {
                event.player.getCapability(PlayerTempProvider.PLAYER_TEMP).ifPresent(temp -> {
                    if (event.player.getRandom().nextFloat() < 3f) {
                        assert Minecraft.getInstance().player != null;
                        try {
                            String log = "";
                            log = new GetCurios().findCurios(Minecraft.getInstance().player, ItemInit.THERMAL_HELMET.get()).get(0).toString();
                            log = new GetCurios().findCurios(Minecraft.getInstance().player, ItemInit.THERMAL_CHESTPLATE.get()).get(0).toString();
                            log = new GetCurios().findCurios(Minecraft.getInstance().player, ItemInit.THERMAL_LEGGINGS.get()).get(0).toString();
                            log = new GetCurios().findCurios(Minecraft.getInstance().player, ItemInit.THERMAL_BOOTS.get()).get(0).toString();
                            ClientTempData.set(0);
                        } catch (IndexOutOfBoundsException e) {
//                            NeutronGalaxy.LOGGER.info("This player does not have an item in this curio.");
                            if (event.player.level.dimension() == DimensionInit.NG_MERCURY || event.player.level.dimension() == DimensionInit.NG_VENUS || event.player.level.dimension() == DimensionInit.NG_MARS || event.player.level.dimension() == DimensionInit.NG_JUPITER) {
                                ClientTempData.set(1);
                            } else if (event.player.level.dimension() == DimensionInit.NG_SATURN || event.player.level.dimension() == DimensionInit.NG_URANUS || event.player.level.dimension() == DimensionInit.NG_NEPTUNE) {
                                ClientTempData.set(2);
                            } else {
                                ClientTempData.set(0);
                            } // does not work on dedicated server
                            if (ClientTempData.getPlayerTemp() == 1) {
                                event.player.hurt(new DamageSource("overheat").bypassArmor(), 1);
                            } else if (ClientTempData.getPlayerTemp() == 2) {
                                event.player.hurt(DamageSource.FREEZE, 1);
                            } else if (ClientTempData.getPlayerTemp() == 0) {
//                                NeutronGalaxy.LOGGER.info("No thermal armour needed on earth or moon");
                            }

                        }
                    }
                });
            } catch (NullPointerException e) {
//                NeutronGalaxy.LOGGER.info("The player must not be in the world yet.");
            }
//        }
    }
}