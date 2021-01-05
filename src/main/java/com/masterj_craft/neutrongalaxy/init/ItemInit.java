package com.masterj_craft.neutrongalaxy.init;

import com.masterj_craft.neutrongalaxy.NeutronGalaxy;
import com.masterj_craft.neutrongalaxy.NeutronGalaxy.NeutronGalaxyItemGroup;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SoupItem;
import net.minecraft.item.UseAction;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = NeutronGalaxy.MOD_ID, bus = Bus.MOD)
@ObjectHolder(NeutronGalaxy.MOD_ID)
public class ItemInit 
{
	public static final Item aluminium_ingot = null;
	public static final Item amethyst = null;
	public static final Item brass_ingot = null;
	public static final Item bronze_ingot = null;
	public static final Item cobalt_ingot = null;
	public static final Item copper_ingot = null;
	public static final Item nickel_ingot = null;
	public static final Item opal = null;
	public static final Item platinum_ingot = null;
	public static final Item ruby = null;
	public static final Item silver_ingot = null;
	public static final Item steel_ingot = null;
	public static final Item thermal_fabric = null;
	public static final Item tin_ingot = null;
	public static final Item rocket_window = null;
	public static final Item steel_plate = null;
	public static final Item aluminium_plate = null;
	public static final Item iron_plate = null;
	public static final Item silicon = null;
	public static final Item sulfur = null;
	
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) 
	
	{
		event.getRegistry().register(new Item(new Item.Properties().group(NeutronGalaxyItemGroup.instance)).setRegistryName("aluminium_ingot"));
		event.getRegistry().register(new Item(new Item.Properties().group(NeutronGalaxyItemGroup.instance)).setRegistryName("amethyst"));
		event.getRegistry().register(new Item(new Item.Properties().group(NeutronGalaxyItemGroup.instance)).setRegistryName("brass_ingot"));
		event.getRegistry().register(new Item(new Item.Properties().group(NeutronGalaxyItemGroup.instance)).setRegistryName("bronze_ingot"));
		event.getRegistry().register(new Item(new Item.Properties().group(NeutronGalaxyItemGroup.instance)).setRegistryName("cobalt_ingot"));
		event.getRegistry().register(new Item(new Item.Properties().group(NeutronGalaxyItemGroup.instance)).setRegistryName("copper_ingot"));
		event.getRegistry().register(new Item(new Item.Properties().group(NeutronGalaxyItemGroup.instance)).setRegistryName("nickel_ingot"));
		event.getRegistry().register(new Item(new Item.Properties().group(NeutronGalaxyItemGroup.instance)).setRegistryName("opal"));
		event.getRegistry().register(new Item(new Item.Properties().group(NeutronGalaxyItemGroup.instance)).setRegistryName("platinum_ingot"));
		event.getRegistry().register(new Item(new Item.Properties().group(NeutronGalaxyItemGroup.instance)).setRegistryName("ruby"));
		event.getRegistry().register(new Item(new Item.Properties().group(NeutronGalaxyItemGroup.instance)).setRegistryName("silver_ingot"));
		event.getRegistry().register(new Item(new Item.Properties().group(NeutronGalaxyItemGroup.instance)).setRegistryName("steel_ingot"));
		event.getRegistry().register(new Item(new Item.Properties().group(NeutronGalaxyItemGroup.instance)).setRegistryName("thermal_fabric"));
		event.getRegistry().register(new Item(new Item.Properties().group(NeutronGalaxyItemGroup.instance)).setRegistryName("tin_ingot"));
		event.getRegistry().register(new Item(new Item.Properties().group(NeutronGalaxyItemGroup.instance)).setRegistryName("rocket_window"));
		event.getRegistry().register(new Item(new Item.Properties().group(NeutronGalaxyItemGroup.instance)).setRegistryName("steel_plate"));
		event.getRegistry().register(new Item(new Item.Properties().group(NeutronGalaxyItemGroup.instance)).setRegistryName("aluminium_plate"));
		event.getRegistry().register(new Item(new Item.Properties().group(NeutronGalaxyItemGroup.instance)).setRegistryName("iron_plate"));
		event.getRegistry().register(new Item(new Item.Properties().group(NeutronGalaxyItemGroup.instance)).setRegistryName("silicon"));
		event.getRegistry().register(new Item(new Item.Properties().group(NeutronGalaxyItemGroup.instance)).setRegistryName("sulfur"));
	}
}