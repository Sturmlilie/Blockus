package com.brand.blockus.blocks.Leaves;

import com.brand.blockus.Blockus;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class SmallHedge extends HedgeBlock {
	

	public SmallHedge(String name, float hardness, float resistance) {
		super(FabricBlockSettings.of(Material.LEAVES).sounds(BlockSoundGroup.GRASS).strength(hardness, resistance).build());
		Registry.register(Registry.BLOCK, new Identifier(Blockus.MOD_ID, name), this);
		Registry.register(Registry.ITEM,new Identifier(Blockus.MOD_ID, name), new BlockItem(this, new Item.Settings().maxCount(64).group(Blockus.BLOCKUS_DECORATIONS)));

	}
}