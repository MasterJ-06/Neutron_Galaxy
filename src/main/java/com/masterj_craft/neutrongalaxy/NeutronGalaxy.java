package com.masterj_craft.neutrongalaxy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.masterj_craft.neutrongalaxy.init.BlockInit;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("neutrongalaxy")
public class NeutronGalaxy
{

    @SuppressWarnings("unused")
	private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "neutrongalaxy";
    public static NeutronGalaxy instance;

    public NeutronGalaxy() 
    {
    	final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    	modEventBus.addListener(this::setup);
    	modEventBus.addListener(this::doClientStuff);
        
        instance = this;

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        
    }

    private void doClientStuff(final FMLClientSetupEvent event) 
    {
        
    }
    
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) 
    {
        
    }
    
    public static class NeutronGalaxyItemGroup extends ItemGroup
    {
    	public static final NeutronGalaxyItemGroup instance = new NeutronGalaxyItemGroup(ItemGroup.GROUPS.length, "neutrongalaxyitems");

    	private NeutronGalaxyItemGroup(int index, String label)
    	{
    		super(index, label);
    	}

		@Override
		public ItemStack createIcon() 
		{
			return new ItemStack(BlockInit.moon_dirt);
		}
		
		
    }
}
