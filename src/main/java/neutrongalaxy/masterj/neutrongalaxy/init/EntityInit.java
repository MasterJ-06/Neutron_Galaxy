package neutrongalaxy.masterj.neutrongalaxy.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import neutrongalaxy.masterj.neutrongalaxy.NeutronGalaxy;
import neutrongalaxy.masterj.neutrongalaxy.entities.RocketEntity;

public class EntityInit {
    public static final DeferredRegister<EntityType<?>> ENTITIES  = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, NeutronGalaxy.MODID);

    public static final RegistryObject<EntityType<RocketEntity>> ROCKET = ENTITIES.register("rocket",
            () -> EntityType.Builder.<RocketEntity>of(RocketEntity::new, MobCategory.MISC).sized(3f, 6f).build(new ResourceLocation(NeutronGalaxy.MODID, "rocket").toString()));
}
