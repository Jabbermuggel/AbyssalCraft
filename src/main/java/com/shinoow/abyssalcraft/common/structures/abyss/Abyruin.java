package com.shinoow.abyssalcraft.common.structures.abyss;

import static net.minecraftforge.common.ChestGenHooks.DUNGEON_CHEST;
import static net.minecraftforge.common.ChestGenHooks.STRONGHOLD_CORRIDOR;

import java.util.Random;

import com.shinoow.abyssalcraft.AbyssalCraft;
import com.shinoow.abyssalcraft.common.structures.abyss.stronghold.StructureAbyStrongholdPieces.ChestCorridor;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.ChestGenHooks;

public class Abyruin extends WorldGenerator
{
	protected Block[] GetValidSpawnBlocks() {
		return new Block[] {
				AbyssalCraft.abystone
		};
	}

	public boolean LocationIsValidSpawn(World world, int i, int j, int k){
		int distanceToAir = 0;
		int checkID = world.getBlockMetadata(i, j, k);

		while (checkID != 0){
			distanceToAir++;
			checkID = world.getBlockMetadata(i, j + distanceToAir, k);
		}

		if (distanceToAir > 3)
			return false;
		j += distanceToAir - 1;

		Block blockID = world.getBlock(i, j, k);
		Block blockIDAbove = world.getBlock(i, j+1, k);
		Block blockIDBelow = world.getBlock(i, j-1, k);
		for (Block x : GetValidSpawnBlocks()){
			if (blockIDAbove != Blocks.air)
				return false;
			if (blockID == x)
				return true;
			else if (blockID == Blocks.snow && blockIDBelow == x)
				return true;
		}
		return false;
	}

	public Abyruin() { }

	@Override
	public boolean generate(World world, Random rand, int i, int j, int k) {
		//check that each corner is one of the valid spawn blocks
		if(!LocationIsValidSpawn(world, i, j, k) || !LocationIsValidSpawn(world, i + 4, j, k) || !LocationIsValidSpawn(world, i + 4, j, k + 8) || !LocationIsValidSpawn(world, i, j, k + 8))
			return false;

		world.setBlock(i - 4, j, k - 6, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 4, j, k - 5, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 4, j, k - 4, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 4, j, k - 3, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 4, j, k - 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 4, j, k - 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 4, j, k, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 4, j, k + 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 4, j, k + 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 4, j + 1, k - 6, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 4, j + 1, k - 5, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 4, j + 1, k - 4, AbyssalCraft.abyfence, 0, 0);
		world.setBlock(i - 4, j + 1, k - 3, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 4, j + 1, k - 2, AbyssalCraft.abyfence, 0, 0);
		world.setBlock(i - 4, j + 1, k - 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 4, j + 1, k, AbyssalCraft.abyfence, 0, 0);
		world.setBlock(i - 4, j + 1, k + 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 4, j + 1, k + 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 4, j + 2, k - 6, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 4, j + 2, k - 5, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 4, j + 2, k - 4, AbyssalCraft.abyfence, 0, 0);
		world.setBlock(i - 4, j + 2, k - 3, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 4, j + 2, k - 2, AbyssalCraft.abyfence, 0, 0);
		world.setBlock(i - 4, j + 2, k - 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 4, j + 2, k, AbyssalCraft.abyfence, 0, 0);
		world.setBlock(i - 4, j + 2, k + 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 4, j + 2, k + 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 4, j + 3, k - 6, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 4, j + 3, k - 5, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 4, j + 3, k - 4, AbyssalCraft.abyfence, 0, 0);
		world.setBlock(i - 4, j + 3, k - 3, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 4, j + 3, k - 2, AbyssalCraft.abyfence, 0, 0);
		world.setBlock(i - 4, j + 3, k - 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 4, j + 3, k, AbyssalCraft.abyfence, 0, 0);
		world.setBlock(i - 4, j + 4, k - 6, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 4, j + 4, k - 3, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 4, j + 4, k - 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 4, j + 4, k - 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 4, j + 5, k - 6, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 4, j + 5, k - 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 3, j, k - 6, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 3, j, k - 5, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 3, j, k - 4, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 3, j, k - 3, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 3, j, k - 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 3, j, k - 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 3, j, k, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 3, j, k + 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 3, j, k + 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 3, j + 1, k - 6, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 3, j + 1, k + 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 3, j + 2, k - 6, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 3, j + 2, k + 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 3, j + 3, k - 6, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 3, j + 3, k + 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 3, j + 4, k - 6, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 3, j + 5, k - 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 3, j + 5, k - 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 2, j - 7, k - 3, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 2, j - 7, k - 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 2, j - 7, k - 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 2, j - 7, k, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 2, j - 6, k - 3, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 2, j - 6, k - 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 2, j - 6, k - 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 2, j - 6, k, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 2, j - 5, k - 3, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 2, j - 5, k - 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 2, j - 5, k - 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 2, j - 5, k, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 2, j, k - 6, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 2, j, k - 5, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 2, j, k - 4, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 2, j, k - 3, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 2, j, k - 2, AbyssalCraft.abystone, 0, 0);
		world.setBlock(i - 2, j, k - 1, AbyssalCraft.abystone, 0, 0);
		world.setBlock(i - 2, j, k, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 2, j, k + 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 2, j, k + 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 2, j + 1, k - 6, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 2, j + 1, k - 3, AbyssalCraft.abyfence, 0, 0);
		world.setBlock(i - 2, j + 1, k, AbyssalCraft.abyfence, 0, 0);
		world.setBlock(i - 2, j + 1, k + 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 2, j + 2, k - 6, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 2, j + 2, k + 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 2, j + 3, k - 6, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 2, j + 3, k + 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 2, j + 4, k - 6, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 2, j + 4, k + 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 2, j + 5, k - 6, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 2, j + 5, k - 5, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 2, j + 5, k - 4, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 2, j + 5, k - 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 2, j + 5, k + 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 1, j - 8, k - 3, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 1, j - 8, k - 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 1, j - 8, k - 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 1, j - 8, k, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 1, j - 7, k - 4, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 1, j - 7, k + 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 1, j - 6, k - 4, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 1, j - 6, k + 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 1, j - 5, k - 4, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 1, j - 5, k + 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 1, j - 4, k - 3, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 1, j - 4, k - 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 1, j - 4, k - 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 1, j - 4, k, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 1, j - 4, k + 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 1, j - 3, k - 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 1, j - 3, k, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 1, j - 3, k + 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 1, j - 2, k - 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 1, j - 2, k, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 1, j - 2, k + 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 1, j - 1, k - 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 1, j - 1, k, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 1, j - 1, k + 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 1, j, k - 6, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 1, j, k - 5, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 1, j, k - 4, AbyssalCraft.abystone, 0, 0);
		world.setBlock(i - 1, j, k - 3, AbyssalCraft.abystone, 0, 0);
		world.setBlock(i - 1, j, k - 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 1, j, k - 1, AbyssalCraft.abystone, 0, 0);
		world.setBlock(i - 1, j, k, AbyssalCraft.abystone, 0, 0);
		world.setBlock(i - 1, j, k + 1, AbyssalCraft.abystone, 0, 0);
		world.setBlock(i - 1, j, k + 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 1, j + 1, k + 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 1, j + 2, k + 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 1, j + 3, k + 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 1, j + 4, k - 6, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 1, j + 4, k + 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 1, j + 5, k - 5, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 1, j + 5, k - 4, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 1, j + 5, k - 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 1, j + 5, k, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 1, j + 5, k + 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i, j - 8, k - 3, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i, j - 8, k - 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i, j - 8, k - 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i, j - 8, k, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i, j - 7, k - 4, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i, j - 7, k - 3, Blocks.chest, 3, 0);
		TileEntityChest tileentitychest = (TileEntityChest)world.getTileEntity(i, j - 7, k - 3);
		if(tileentitychest != null)
			WeightedRandomChestContent.generateChestContents(rand, ChestCorridor.strongholdChestContents, tileentitychest, ChestGenHooks.getCount(STRONGHOLD_CORRIDOR, rand));
		world.setBlock(i, j - 7, k + 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i, j - 6, k - 4, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i, j - 6, k + 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i, j - 5, k - 4, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i, j - 5, k + 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i, j - 4, k - 3, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i, j - 4, k - 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i, j - 4, k - 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i, j - 4, k + 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i, j - 3, k - 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i, j - 3, k + 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i, j - 2, k - 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i, j - 2, k + 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i, j - 1, k - 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i, j - 1, k + 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i, j, k - 6, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i, j, k - 5, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i, j, k - 4, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i, j, k - 3, AbyssalCraft.abystone, 0, 0);
		world.setBlock(i, j, k - 2, AbyssalCraft.abystone, 0, 0);
		world.setBlock(i, j, k - 1, AbyssalCraft.abystone, 0, 0);
		world.setBlock(i, j, k, AbyssalCraft.cstone, 0, 0);
		world.setBlock(i, j, k + 1, AbyssalCraft.abystone, 0, 0);
		world.setBlock(i, j, k + 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i, j + 1, k + 1, Blocks.chest, 2, 0);
		TileEntityChest tileentitychest2 = (TileEntityChest)world.getTileEntity(i, j + 1, k + 1);
		if(tileentitychest2 != null)
			WeightedRandomChestContent.generateChestContents(rand, ChestGenHooks.getItems(DUNGEON_CHEST, rand), tileentitychest2, ChestGenHooks.getCount(DUNGEON_CHEST, rand));
		world.setBlock(i, j + 1, k + 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i, j + 2, k + 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i, j + 3, k + 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i, j + 4, k - 6, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i, j + 4, k + 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i, j + 5, k - 6, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i, j + 5, k - 4, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i, j + 5, k - 3, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i, j + 5, k - 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i, j + 5, k + 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 1, j - 8, k - 3, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 1, j - 8, k - 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 1, j - 8, k - 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 1, j - 8, k, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 1, j - 7, k - 4, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 1, j - 7, k + 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 1, j - 6, k - 4, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 1, j - 6, k + 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 1, j - 5, k - 4, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 1, j - 5, k + 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 1, j - 4, k - 3, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 1, j - 4, k - 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 1, j - 4, k - 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 1, j - 4, k, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 1, j - 4, k + 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 1, j - 3, k - 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 1, j - 3, k, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 1, j - 3, k + 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 1, j - 2, k - 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 1, j - 2, k, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 1, j - 2, k + 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 1, j - 1, k - 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 1, j - 1, k, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 1, j - 1, k + 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 1, j, k - 6, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 1, j, k - 5, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 1, j, k - 4, AbyssalCraft.abystone, 0, 0);
		world.setBlock(i + 1, j, k - 3, AbyssalCraft.abystone, 0, 0);
		world.setBlock(i + 1, j, k - 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 1, j, k - 1, AbyssalCraft.abystone, 0, 0);
		world.setBlock(i + 1, j, k, AbyssalCraft.abystone, 0, 0);
		world.setBlock(i + 1, j, k + 1, AbyssalCraft.abystone, 0, 0);
		world.setBlock(i + 1, j, k + 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 1, j + 1, k + 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 1, j + 2, k + 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 1, j + 3, k + 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 1, j + 4, k - 6, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 1, j + 4, k + 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 1, j + 5, k - 5, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 1, j + 5, k - 4, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 1, j + 5, k - 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 1, j + 5, k - 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 1, j + 5, k, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 1, j + 5, k + 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 2, j - 7, k - 3, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 2, j - 7, k - 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 2, j - 7, k - 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 2, j - 7, k, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 2, j - 6, k - 3, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 2, j - 6, k - 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 2, j - 6, k - 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 2, j - 6, k, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 2, j - 5, k - 3, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 2, j - 5, k - 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 2, j - 5, k - 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 2, j - 5, k, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 2, j, k - 6, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 2, j, k - 5, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 2, j, k - 4, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 2, j, k - 3, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 2, j, k - 2, AbyssalCraft.abystone, 0, 0);
		world.setBlock(i + 2, j, k - 1, AbyssalCraft.abystone, 0, 0);
		world.setBlock(i + 2, j, k, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 2, j, k + 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 2, j, k + 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 2, j + 1, k - 6, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 2, j + 1, k - 3, AbyssalCraft.abyfence, 0, 0);
		world.setBlock(i + 2, j + 1, k, AbyssalCraft.abyfence, 0, 0);
		world.setBlock(i + 2, j + 1, k + 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 2, j + 2, k - 6, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 2, j + 2, k + 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 2, j + 3, k - 6, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 2, j + 3, k + 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 2, j + 4, k - 6, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 2, j + 4, k + 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 2, j + 5, k - 5, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 2, j + 5, k - 4, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 2, j + 5, k - 3, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 2, j + 5, k - 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 2, j + 5, k, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 2, j + 5, k + 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 3, j, k - 6, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 3, j, k - 5, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 3, j, k - 4, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 3, j, k - 3, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 3, j, k - 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 3, j, k - 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 3, j, k, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 3, j, k + 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 3, j, k + 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 3, j + 1, k - 6, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 3, j + 1, k + 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 3, j + 2, k - 6, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 3, j + 2, k + 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 3, j + 3, k - 6, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 3, j + 3, k + 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 3, j + 4, k - 6, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 3, j + 4, k + 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 3, j + 5, k - 6, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 3, j + 5, k - 4, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 3, j + 5, k - 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 3, j + 5, k - 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 3, j + 5, k + 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 4, j, k - 6, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 4, j, k - 5, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 4, j, k - 4, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 4, j, k - 3, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 4, j, k - 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 4, j, k - 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 4, j, k, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 4, j, k + 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 4, j, k + 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 4, j + 1, k - 6, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 4, j + 1, k - 5, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 4, j + 1, k - 4, AbyssalCraft.abyfence, 0, 0);
		world.setBlock(i + 4, j + 1, k - 3, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 4, j + 1, k - 2, AbyssalCraft.abyfence, 0, 0);
		world.setBlock(i + 4, j + 1, k - 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 4, j + 1, k, AbyssalCraft.abyfence, 0, 0);
		world.setBlock(i + 4, j + 1, k + 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 4, j + 1, k + 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 4, j + 2, k - 6, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 4, j + 2, k - 5, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 4, j + 2, k - 4, AbyssalCraft.abyfence, 0, 0);
		world.setBlock(i + 4, j + 2, k - 3, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 4, j + 2, k - 2, AbyssalCraft.abyfence, 0, 0);
		world.setBlock(i + 4, j + 2, k - 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 4, j + 2, k, AbyssalCraft.abyfence, 0, 0);
		world.setBlock(i + 4, j + 2, k + 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 4, j + 2, k + 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 4, j + 3, k - 6, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 4, j + 3, k - 5, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 4, j + 3, k - 4, AbyssalCraft.abyfence, 0, 0);
		world.setBlock(i + 4, j + 3, k - 3, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 4, j + 3, k - 2, AbyssalCraft.abyfence, 0, 0);
		world.setBlock(i + 4, j + 3, k - 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 4, j + 3, k, AbyssalCraft.abyfence, 0, 0);
		world.setBlock(i + 4, j + 3, k + 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 4, j + 4, k - 6, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 4, j + 4, k - 5, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 4, j + 4, k - 4, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 4, j + 4, k - 3, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 4, j + 4, k - 2, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 4, j + 4, k - 1, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 4, j + 5, k - 5, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i + 4, j + 5, k - 3, AbyssalCraft.abybrick, 0, 0);
		world.setBlock(i - 3, j + 1, k - 5, Blocks.air, 0, 0);
		world.setBlock(i - 3, j + 1, k - 4, Blocks.air, 0, 0);
		world.setBlock(i - 3, j + 1, k - 3, Blocks.air, 0, 0);
		world.setBlock(i - 3, j + 1, k - 2, Blocks.air, 0, 0);
		world.setBlock(i - 3, j + 1, k - 1, Blocks.air, 0, 0);
		world.setBlock(i - 3, j + 1, k, Blocks.air, 0, 0);
		world.setBlock(i - 3, j + 1, k + 1, Blocks.air, 0, 0);
		world.setBlock(i - 3, j + 2, k - 5, Blocks.air, 0, 0);
		world.setBlock(i - 3, j + 2, k - 4, Blocks.air, 0, 0);
		world.setBlock(i - 3, j + 2, k - 3, Blocks.air, 0, 0);
		world.setBlock(i - 3, j + 2, k - 2, Blocks.air, 0, 0);
		world.setBlock(i - 3, j + 2, k - 1, Blocks.air, 0, 0);
		world.setBlock(i - 3, j + 2, k, Blocks.air, 0, 0);
		world.setBlock(i - 3, j + 2, k + 1, Blocks.air, 0, 0);
		world.setBlock(i - 3, j + 3, k - 5, Blocks.air, 0, 0);
		world.setBlock(i - 3, j + 3, k - 4, Blocks.air, 0, 0);
		world.setBlock(i - 3, j + 3, k - 3, Blocks.air, 0, 0);
		world.setBlock(i - 3, j + 3, k - 2, Blocks.air, 0, 0);
		world.setBlock(i - 3, j + 3, k - 1, Blocks.air, 0, 0);
		world.setBlock(i - 3, j + 3, k, Blocks.air, 0, 0);
		world.setBlock(i - 3, j + 3, k + 1, Blocks.air, 0, 0);
		world.setBlock(i - 3, j + 4, k - 5, Blocks.air, 0, 0);
		world.setBlock(i - 3, j + 4, k - 4, Blocks.air, 0, 0);
		world.setBlock(i - 3, j + 4, k - 3, Blocks.air, 0, 0);
		world.setBlock(i - 3, j + 4, k - 2, Blocks.air, 0, 0);
		world.setBlock(i - 3, j + 4, k - 1, Blocks.air, 0, 0);
		world.setBlock(i - 3, j + 4, k, Blocks.air, 0, 0);
		world.setBlock(i - 3, j + 4, k + 1, Blocks.air, 0, 0);
		world.setBlock(i - 2, j + 1, k - 5, Blocks.air, 0, 0);
		world.setBlock(i - 2, j + 1, k - 4, Blocks.air, 0, 0);
		world.setBlock(i - 2, j + 1, k - 2, Blocks.air, 0, 0);
		world.setBlock(i - 2, j + 1, k - 1, Blocks.air, 0, 0);
		world.setBlock(i - 2, j + 1, k + 1, Blocks.air, 0, 0);
		world.setBlock(i - 2, j + 2, k - 5, Blocks.air, 0, 0);
		world.setBlock(i - 2, j + 2, k - 4, Blocks.air, 0, 0);
		world.setBlock(i - 2, j + 2, k - 3, Blocks.torch, 5, 0);
		world.setBlock(i - 2, j + 2, k - 2, Blocks.air, 0, 0);
		world.setBlock(i - 2, j + 2, k - 1, Blocks.air, 0, 0);
		world.setBlock(i - 2, j + 2, k, Blocks.torch, 5, 0);
		world.setBlock(i - 2, j + 2, k + 1, Blocks.air, 0, 0);
		world.setBlock(i - 2, j + 3, k - 5, Blocks.air, 0, 0);
		world.setBlock(i - 2, j + 3, k - 4, Blocks.air, 0, 0);
		world.setBlock(i - 2, j + 3, k - 3, Blocks.air, 0, 0);
		world.setBlock(i - 2, j + 3, k - 2, Blocks.air, 0, 0);
		world.setBlock(i - 2, j + 3, k - 1, Blocks.air, 0, 0);
		world.setBlock(i - 2, j + 3, k, Blocks.air, 0, 0);
		world.setBlock(i - 2, j + 3, k + 1, Blocks.air, 0, 0);
		world.setBlock(i - 2, j + 4, k - 5, Blocks.air, 0, 0);
		world.setBlock(i - 2, j + 4, k - 4, Blocks.air, 0, 0);
		world.setBlock(i - 2, j + 4, k - 3, Blocks.air, 0, 0);
		world.setBlock(i - 2, j + 4, k - 2, Blocks.air, 0, 0);
		world.setBlock(i - 2, j + 4, k - 1, Blocks.air, 0, 0);
		world.setBlock(i - 2, j + 4, k, Blocks.air, 0, 0);
		world.setBlock(i - 2, j + 4, k + 1, Blocks.air, 0, 0);
		world.setBlock(i - 1, j - 7, k - 3, Blocks.air, 0, 0);
		world.setBlock(i - 1, j - 7, k - 2, Blocks.air, 0, 0);
		world.setBlock(i - 1, j - 7, k - 1, Blocks.air, 0, 0);
		world.setBlock(i - 1, j - 7, k, Blocks.air, 0, 0);
		world.setBlock(i - 1, j - 6, k - 3, Blocks.air, 0, 0);
		world.setBlock(i - 1, j - 6, k - 2, Blocks.air, 0, 0);
		world.setBlock(i - 1, j - 6, k - 1, Blocks.air, 0, 0);
		world.setBlock(i - 1, j - 6, k, Blocks.air, 0, 0);
		world.setBlock(i - 1, j - 5, k - 3, Blocks.air, 0, 0);
		world.setBlock(i - 1, j - 5, k - 2, Blocks.air, 0, 0);
		world.setBlock(i - 1, j - 5, k - 1, Blocks.air, 0, 0);
		world.setBlock(i - 1, j - 5, k, Blocks.air, 0, 0);
		world.setBlock(i - 1, j + 1, k - 6, Blocks.air, 0, 0);
		world.setBlock(i - 1, j + 1, k - 5, Blocks.air, 0, 0);
		world.setBlock(i - 1, j + 1, k - 4, Blocks.air, 0, 0);
		world.setBlock(i - 1, j + 1, k - 3, Blocks.air, 0, 0);
		world.setBlock(i - 1, j + 1, k - 2, Blocks.air, 0, 0);
		world.setBlock(i - 1, j + 1, k - 1, Blocks.air, 0, 0);
		world.setBlock(i - 1, j + 1, k, Blocks.air, 0, 0);
		world.setBlock(i - 1, j + 1, k + 1, Blocks.air, 0, 0);
		world.setBlock(i - 1, j + 2, k - 6, Blocks.air, 0, 0);
		world.setBlock(i - 1, j + 2, k - 5, Blocks.air, 0, 0);
		world.setBlock(i - 1, j + 2, k - 4, Blocks.air, 0, 0);
		world.setBlock(i - 1, j + 2, k - 3, Blocks.air, 0, 0);
		world.setBlock(i - 1, j + 2, k - 2, Blocks.air, 0, 0);
		world.setBlock(i - 1, j + 2, k - 1, Blocks.air, 0, 0);
		world.setBlock(i - 1, j + 2, k, Blocks.air, 0, 0);
		world.setBlock(i - 1, j + 2, k + 1, Blocks.air, 0, 0);
		world.setBlock(i - 1, j + 3, k - 6, Blocks.air, 0, 0);
		world.setBlock(i - 1, j + 3, k - 5, Blocks.air, 0, 0);
		world.setBlock(i - 1, j + 3, k - 4, Blocks.air, 0, 0);
		world.setBlock(i - 1, j + 3, k - 3, Blocks.air, 0, 0);
		world.setBlock(i - 1, j + 3, k - 2, Blocks.air, 0, 0);
		world.setBlock(i - 1, j + 3, k - 1, Blocks.air, 0, 0);
		world.setBlock(i - 1, j + 3, k, Blocks.air, 0, 0);
		world.setBlock(i - 1, j + 3, k + 1, Blocks.air, 0, 0);
		world.setBlock(i - 1, j + 4, k - 5, Blocks.air, 0, 0);
		world.setBlock(i - 1, j + 4, k - 4, Blocks.air, 0, 0);
		world.setBlock(i - 1, j + 4, k - 3, Blocks.air, 0, 0);
		world.setBlock(i - 1, j + 4, k - 2, Blocks.air, 0, 0);
		world.setBlock(i - 1, j + 4, k - 1, Blocks.air, 0, 0);
		world.setBlock(i - 1, j + 4, k, Blocks.air, 0, 0);
		world.setBlock(i - 1, j + 4, k + 1, Blocks.air, 0, 0);
		world.setBlock(i, j - 7, k - 2, Blocks.air, 0, 0);
		world.setBlock(i, j - 7, k - 1, Blocks.air, 0, 0);
		world.setBlock(i, j - 7, k, Blocks.ladder, 2, 0);
		world.setBlock(i, j - 6, k - 3, Blocks.air, 0, 0);
		world.setBlock(i, j - 6, k - 2, Blocks.air, 0, 0);
		world.setBlock(i, j - 6, k - 1, Blocks.air, 0, 0);
		world.setBlock(i, j - 6, k, Blocks.ladder, 2, 0);
		world.setBlock(i, j - 5, k - 3, Blocks.air, 0, 0);
		world.setBlock(i, j - 5, k - 2, Blocks.air, 0, 0);
		world.setBlock(i, j - 5, k - 1, Blocks.air, 0, 0);
		world.setBlock(i, j - 5, k, Blocks.ladder, 2, 0);
		world.setBlock(i, j - 4, k, Blocks.ladder, 2, 0);
		world.setBlock(i, j - 3, k, Blocks.ladder, 2, 0);
		world.setBlock(i, j - 2, k, Blocks.ladder, 2, 0);
		world.setBlock(i, j - 1, k, Blocks.ladder, 2, 0);
		world.setBlock(i, j + 1, k - 6, Blocks.air, 0, 0);
		world.setBlock(i, j + 1, k - 5, Blocks.air, 0, 0);
		world.setBlock(i, j + 1, k - 4, Blocks.air, 0, 0);
		world.setBlock(i, j + 1, k - 3, Blocks.air, 0, 0);
		world.setBlock(i, j + 1, k - 2, Blocks.air, 0, 0);
		world.setBlock(i, j + 1, k - 1, Blocks.air, 0, 0);
		world.setBlock(i, j + 1, k, Blocks.air, 0, 0);
		world.setBlock(i, j + 2, k - 6, Blocks.air, 0, 0);
		world.setBlock(i, j + 2, k - 5, Blocks.air, 0, 0);
		world.setBlock(i, j + 2, k - 4, Blocks.air, 0, 0);
		world.setBlock(i, j + 2, k - 3, Blocks.air, 0, 0);
		world.setBlock(i, j + 2, k - 2, Blocks.air, 0, 0);
		world.setBlock(i, j + 2, k - 1, Blocks.air, 0, 0);
		world.setBlock(i, j + 2, k, Blocks.air, 0, 0);
		world.setBlock(i, j + 2, k + 1, Blocks.air, 0, 0);
		world.setBlock(i, j + 3, k - 6, Blocks.air, 0, 0);
		world.setBlock(i, j + 3, k - 5, Blocks.air, 0, 0);
		world.setBlock(i, j + 3, k - 4, Blocks.air, 0, 0);
		world.setBlock(i, j + 3, k - 3, Blocks.air, 0, 0);
		world.setBlock(i, j + 3, k - 2, Blocks.air, 0, 0);
		world.setBlock(i, j + 3, k - 1, Blocks.air, 0, 0);
		world.setBlock(i, j + 3, k, Blocks.air, 0, 0);
		world.setBlock(i, j + 3, k + 1, Blocks.air, 0, 0);
		world.setBlock(i, j + 4, k - 5, Blocks.air, 0, 0);
		world.setBlock(i, j + 4, k - 4, Blocks.air, 0, 0);
		world.setBlock(i, j + 4, k - 3, Blocks.air, 0, 0);
		world.setBlock(i, j + 4, k - 2, Blocks.air, 0, 0);
		world.setBlock(i, j + 4, k - 1, Blocks.air, 0, 0);
		world.setBlock(i, j + 4, k, Blocks.air, 0, 0);
		world.setBlock(i, j + 4, k + 1, Blocks.air, 0, 0);
		world.setBlock(i + 1, j - 7, k - 3, Blocks.air, 0, 0);
		world.setBlock(i + 1, j - 7, k - 2, Blocks.air, 0, 0);
		world.setBlock(i + 1, j - 7, k - 1, Blocks.air, 0, 0);
		world.setBlock(i + 1, j - 7, k, Blocks.air, 0, 0);
		world.setBlock(i + 1, j - 6, k - 3, Blocks.air, 0, 0);
		world.setBlock(i + 1, j - 6, k - 2, Blocks.air, 0, 0);
		world.setBlock(i + 1, j - 6, k - 1, Blocks.air, 0, 0);
		world.setBlock(i + 1, j - 6, k, Blocks.air, 0, 0);
		world.setBlock(i + 1, j - 5, k - 3, Blocks.air, 0, 0);
		world.setBlock(i + 1, j - 5, k - 2, Blocks.air, 0, 0);
		world.setBlock(i + 1, j - 5, k - 1, Blocks.air, 0, 0);
		world.setBlock(i + 1, j - 5, k, Blocks.air, 0, 0);
		world.setBlock(i + 1, j + 1, k - 6, Blocks.air, 0, 0);
		world.setBlock(i + 1, j + 1, k - 5, Blocks.air, 0, 0);
		world.setBlock(i + 1, j + 1, k - 4, Blocks.air, 0, 0);
		world.setBlock(i + 1, j + 1, k - 3, Blocks.air, 0, 0);
		world.setBlock(i + 1, j + 1, k - 2, Blocks.air, 0, 0);
		world.setBlock(i + 1, j + 1, k - 1, Blocks.air, 0, 0);
		world.setBlock(i + 1, j + 1, k, Blocks.air, 0, 0);
		world.setBlock(i + 1, j + 1, k + 1, Blocks.air, 0, 0);
		world.setBlock(i + 1, j + 2, k - 6, Blocks.air, 0, 0);
		world.setBlock(i + 1, j + 2, k - 5, Blocks.air, 0, 0);
		world.setBlock(i + 1, j + 2, k - 4, Blocks.air, 0, 0);
		world.setBlock(i + 1, j + 2, k - 3, Blocks.air, 0, 0);
		world.setBlock(i + 1, j + 2, k - 2, Blocks.air, 0, 0);
		world.setBlock(i + 1, j + 2, k - 1, Blocks.air, 0, 0);
		world.setBlock(i + 1, j + 2, k, Blocks.air, 0, 0);
		world.setBlock(i + 1, j + 2, k + 1, Blocks.air, 0, 0);
		world.setBlock(i + 1, j + 3, k - 6, Blocks.air, 0, 0);
		world.setBlock(i + 1, j + 3, k - 5, Blocks.air, 0, 0);
		world.setBlock(i + 1, j + 3, k - 4, Blocks.air, 0, 0);
		world.setBlock(i + 1, j + 3, k - 3, Blocks.air, 0, 0);
		world.setBlock(i + 1, j + 3, k - 2, Blocks.air, 0, 0);
		world.setBlock(i + 1, j + 3, k - 1, Blocks.air, 0, 0);
		world.setBlock(i + 1, j + 3, k, Blocks.air, 0, 0);
		world.setBlock(i + 1, j + 3, k + 1, Blocks.air, 0, 0);
		world.setBlock(i + 1, j + 4, k - 5, Blocks.air, 0, 0);
		world.setBlock(i + 1, j + 4, k - 4, Blocks.air, 0, 0);
		world.setBlock(i + 1, j + 4, k - 3, Blocks.air, 0, 0);
		world.setBlock(i + 1, j + 4, k - 2, Blocks.air, 0, 0);
		world.setBlock(i + 1, j + 4, k - 1, Blocks.air, 0, 0);
		world.setBlock(i + 1, j + 4, k, Blocks.air, 0, 0);
		world.setBlock(i + 1, j + 4, k + 1, Blocks.air, 0, 0);
		world.setBlock(i + 2, j + 1, k - 5, Blocks.air, 0, 0);
		world.setBlock(i + 2, j + 1, k - 4, Blocks.air, 0, 0);
		world.setBlock(i + 2, j + 1, k - 2, Blocks.air, 0, 0);
		world.setBlock(i + 2, j + 1, k - 1, Blocks.air, 0, 0);
		world.setBlock(i + 2, j + 1, k + 1, Blocks.air, 0, 0);
		world.setBlock(i + 2, j + 2, k - 5, Blocks.air, 0, 0);
		world.setBlock(i + 2, j + 2, k - 4, Blocks.air, 0, 0);
		world.setBlock(i + 2, j + 2, k - 3, Blocks.torch, 5, 0);
		world.setBlock(i + 2, j + 2, k - 2, Blocks.air, 0, 0);
		world.setBlock(i + 2, j + 2, k - 1, Blocks.air, 0, 0);
		world.setBlock(i + 2, j + 2, k, Blocks.torch, 5, 0);
		world.setBlock(i + 2, j + 2, k + 1, Blocks.air, 0, 0);
		world.setBlock(i + 2, j + 3, k - 5, Blocks.air, 0, 0);
		world.setBlock(i + 2, j + 3, k - 4, Blocks.air, 0, 0);
		world.setBlock(i + 2, j + 3, k - 3, Blocks.air, 0, 0);
		world.setBlock(i + 2, j + 3, k - 2, Blocks.air, 0, 0);
		world.setBlock(i + 2, j + 3, k - 1, Blocks.air, 0, 0);
		world.setBlock(i + 2, j + 3, k, Blocks.air, 0, 0);
		world.setBlock(i + 2, j + 3, k + 1, Blocks.air, 0, 0);
		world.setBlock(i + 2, j + 4, k - 5, Blocks.air, 0, 0);
		world.setBlock(i + 2, j + 4, k - 4, Blocks.air, 0, 0);
		world.setBlock(i + 2, j + 4, k - 3, Blocks.air, 0, 0);
		world.setBlock(i + 2, j + 4, k - 2, Blocks.air, 0, 0);
		world.setBlock(i + 2, j + 4, k - 1, Blocks.air, 0, 0);
		world.setBlock(i + 2, j + 4, k, Blocks.air, 0, 0);
		world.setBlock(i + 2, j + 4, k + 1, Blocks.air, 0, 0);
		world.setBlock(i + 3, j + 1, k - 5, Blocks.air, 0, 0);
		world.setBlock(i + 3, j + 1, k - 4, Blocks.air, 0, 0);
		world.setBlock(i + 3, j + 1, k - 3, Blocks.air, 0, 0);
		world.setBlock(i + 3, j + 1, k - 2, Blocks.air, 0, 0);
		world.setBlock(i + 3, j + 1, k - 1, Blocks.air, 0, 0);
		world.setBlock(i + 3, j + 1, k, Blocks.air, 0, 0);
		world.setBlock(i + 3, j + 1, k + 1, Blocks.air, 0, 0);
		world.setBlock(i + 3, j + 2, k - 5, Blocks.air, 0, 0);
		world.setBlock(i + 3, j + 2, k - 4, Blocks.air, 0, 0);
		world.setBlock(i + 3, j + 2, k - 3, Blocks.air, 0, 0);
		world.setBlock(i + 3, j + 2, k - 2, Blocks.air, 0, 0);
		world.setBlock(i + 3, j + 2, k - 1, Blocks.air, 0, 0);
		world.setBlock(i + 3, j + 2, k, Blocks.air, 0, 0);
		world.setBlock(i + 3, j + 2, k + 1, Blocks.air, 0, 0);
		world.setBlock(i + 3, j + 3, k - 5, Blocks.air, 0, 0);
		world.setBlock(i + 3, j + 3, k - 4, Blocks.air, 0, 0);
		world.setBlock(i + 3, j + 3, k - 3, Blocks.air, 0, 0);
		world.setBlock(i + 3, j + 3, k - 2, Blocks.air, 0, 0);
		world.setBlock(i + 3, j + 3, k - 1, Blocks.air, 0, 0);
		world.setBlock(i + 3, j + 3, k, Blocks.air, 0, 0);
		world.setBlock(i + 3, j + 3, k + 1, Blocks.air, 0, 0);
		world.setBlock(i + 3, j + 4, k - 5, Blocks.air, 0, 0);
		world.setBlock(i + 3, j + 4, k - 4, Blocks.air, 0, 0);
		world.setBlock(i + 3, j + 4, k - 3, Blocks.air, 0, 0);
		world.setBlock(i + 3, j + 4, k - 2, Blocks.air, 0, 0);
		world.setBlock(i + 3, j + 4, k - 1, Blocks.air, 0, 0);
		world.setBlock(i + 3, j + 4, k, Blocks.air, 0, 0);
		world.setBlock(i + 3, j + 4, k + 1, Blocks.air, 0, 0);

		return true;
	}
}