package com.brand.blockus.world;

import com.brand.blockus.content.Bluestone;
import com.brand.blockus.content.Limestone;
import com.brand.blockus.content.Marble;
import com.brand.blockus.content.WhiteOak;
import com.google.common.collect.ImmutableList;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.decorator.CountDepthDecoratorConfig;
import net.minecraft.world.gen.decorator.CountExtraChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.RandomFeatureConfig;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.BranchedTreeFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class BlockusGen {
	
	public static final BranchedTreeFeatureConfig WHITE_OAK_TREE_CONFIG;
	private static final BlockState WHITE_OAK_LOG;
	private static final BlockState WHITE_OAK_LEAVES;
	private static final BlockState OAK_LOG;
	private static final BlockState OAK_LEAVES;
	public static final BranchedTreeFeatureConfig OAK_TREE_CONFIG;
	
	public static void addLimestone(Biome biome) {
       biome.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, Limestone.LIMESTONE.getDefaultState(), 33)).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(10, 0, 0, 120))));
    }
	public static void addMarble(Biome biome) {
	   biome.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, Marble.MARBLE.getDefaultState(), 70)).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(1, 0, 0, 75))));
	}
	public static void addBluestone(Biome biome) {
	   biome.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, Bluestone.BLUESTONE.getDefaultState(), 20)).createDecoratedFeature(Decorator.COUNT_DEPTH_AVERAGE.configure(new CountDepthDecoratorConfig(8, 16, 16))));
	}
	public static void addWhiteOakTrees(Biome biome) {
		if (biome == Biomes.FOREST || biome == Biomes.WOODED_HILLS || biome == Biomes.FLOWER_FOREST || biome.getCategory() == Biome.Category.PLAINS) {
	      biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(Feature.NORMAL_TREE.configure(WHITE_OAK_TREE_CONFIG).withChance(0.04F)), Feature.NORMAL_TREE.configure(OAK_TREE_CONFIG))).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(1, 0.1F, 1))));
      }
    }

	   static {
	 OAK_LOG = Blocks.OAK_LOG.getDefaultState();
	 OAK_LEAVES = Blocks.OAK_LEAVES.getDefaultState();
	 OAK_TREE_CONFIG = (new BranchedTreeFeatureConfig.Builder(new SimpleBlockStateProvider(OAK_LOG), new SimpleBlockStateProvider(OAK_LEAVES), new BlobFoliagePlacer(2, 0, 0, 0, 3), new StraightTrunkPlacer(4, 2, 0))).noVines().build();
     WHITE_OAK_LOG = WhiteOak.WHITE_OAK_LOG.getDefaultState();
     WHITE_OAK_LEAVES = WhiteOak.WHITE_OAK_LEAVES.getDefaultState();
     WHITE_OAK_TREE_CONFIG = (new BranchedTreeFeatureConfig.Builder(new SimpleBlockStateProvider(WHITE_OAK_LOG), new SimpleBlockStateProvider(WHITE_OAK_LEAVES), new BlobFoliagePlacer(2, 0, 0, 0, 5), new StraightTrunkPlacer(7, 2, 0))).noVines().build();
		   
	}
  }