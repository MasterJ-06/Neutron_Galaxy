package com.masterj_craft.neutrongalaxy.init;

import com.masterj_craft.neutrongalaxy.NeutronGalaxy;
import com.masterj_craft.neutrongalaxy.NeutronGalaxy.NeutronGalaxyItemGroup;

import net.minecraft.block.Block;
import net.minecraft.block.GravelBlock;
import net.minecraft.block.LogBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@SuppressWarnings("unused")
@ObjectHolder(NeutronGalaxy.MOD_ID)
@Mod.EventBusSubscriber(modid = NeutronGalaxy.MOD_ID, bus = Bus.MOD)
public class BlockInit 
{
	public static final Block moon_dirt = null;
	public static final Block mercury_stone = null;
	public static final Block mercury_gravel = null;
	public static final Block moon_rock = null;
	public static final Block pluto_rock = null;
	
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event)
	{
		event.getRegistry().register(new Block(Block.Properties.create(Material.EARTH).hardnessAndResistance(0.5F).sound(SoundType.GROUND)).setRegistryName("moon_dirt"));
		event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("mercury_stone"));
		event.getRegistry().register(new GravelBlock(Block.Properties.create(Material.SAND).hardnessAndResistance(0.6F).sound(SoundType.GROUND)).setRegistryName("mercury_gravel"));
		event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("moon_rock"));
		event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("pluto_rock"));
	}
	
	@SubscribeEvent
	public static void registerBlockItems(final RegistryEvent.Register<Item> event)
	{
		event.getRegistry().register(new BlockItem(moon_dirt, new Item.Properties().group(NeutronGalaxyItemGroup.instance)).setRegistryName("moon_dirt"));
		event.getRegistry().register(new BlockItem(mercury_stone, new Item.Properties().group(NeutronGalaxyItemGroup.instance)).setRegistryName("mercury_stone"));
		event.getRegistry().register(new BlockItem(mercury_gravel, new Item.Properties().group(NeutronGalaxyItemGroup.instance)).setRegistryName("mercury_gravel"));
		event.getRegistry().register(new BlockItem(moon_rock, new Item.Properties().group(NeutronGalaxyItemGroup.instance)).setRegistryName("moon_rock"));
		event.getRegistry().register(new BlockItem(pluto_rock, new Item.Properties().group(NeutronGalaxyItemGroup.instance)).setRegistryName("pluto_rock"));
	}
}
