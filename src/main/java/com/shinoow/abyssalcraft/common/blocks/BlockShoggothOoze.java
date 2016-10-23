/*******************************************************************************
 * AbyssalCraft
 * Copyright (c) 2012 - 2016 Shinoow.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 * 
 * Contributors:
 *     Shinoow -  implementation
 ******************************************************************************/
package com.shinoow.abyssalcraft.common.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import com.shinoow.abyssalcraft.AbyssalCraft;
import com.shinoow.abyssalcraft.api.AbyssalCraftAPI;
import com.shinoow.abyssalcraft.api.block.ACBlocks;
import com.shinoow.abyssalcraft.common.entity.EntityLesserShoggoth;

public class BlockShoggothOoze extends BlockACBasic {

	private static List<Block> blockBlacklist = new ArrayList<Block>();

	public BlockShoggothOoze(){
		super(Material.ground, 1.0F, 1.0F, SoundType.SAND);
		setTickRandomly(AbyssalCraft.oozeExpire);
	}

	@Override
	public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World world, BlockPos pos)
	{
		float f = 0.25F;
		return new AxisAlignedBB(0, 0, 0, 1, 1 - f, 1);
	}

	@Override
	public int quantityDropped(Random par1Random)
	{
		return 0;
	}

	@Override
	public void onEntityCollidedWithBlock(World world, BlockPos pos, Entity entity)
	{
		if(!(entity instanceof EntityLesserShoggoth)){
			entity.motionX *= 0.4D;
			entity.motionZ *= 0.4D;
		}
	}

	@Override
	public void updateTick(World par1World, BlockPos pos, IBlockState state, Random par5Random) {
		if(AbyssalCraft.oozeExpire)
			if (!par1World.isRemote && par5Random.nextInt(10) == 0 && par1World.getLightFromNeighbors(pos.up()) >= 13)
				par1World.setBlockState(pos, Blocks.dirt.getDefaultState());
	}

	@Override
	public int tickRate(World worldIn)
	{
		return AbyssalCraft.oozeExpire ? 200 : super.tickRate(worldIn);
	}

	@Override
	public boolean canPlaceBlockOnSide(World worldIn, BlockPos pos, EnumFacing side)
	{
		return super.canPlaceBlockAt(worldIn, pos);
	}

	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
	{
		IBlockState block = worldIn.getBlockState(pos);
		if(!block.getMaterial().isLiquid() && block.getMaterial() != Material.air && !block.getBlock().hasTileEntity(worldIn.getBlockState(pos))
				&& block.isOpaqueCube() && block.isFullCube() && block.getBoundingBox(worldIn, pos) != null)
			if(block.getMaterial() == Material.leaves && AbyssalCraft.oozeLeaves || block.getMaterial() == Material.grass && AbyssalCraft.oozeGrass
			|| block.getMaterial() == Material.ground && AbyssalCraft.oozeGround || block.getMaterial() == Material.sand && AbyssalCraft.oozeSand
			|| block.getMaterial() == Material.rock && AbyssalCraft.oozeRock || block.getMaterial() == Material.cloth && AbyssalCraft.oozeCloth
			|| block.getMaterial() == Material.wood && AbyssalCraft.oozeWood || block.getMaterial() == Material.gourd && AbyssalCraft.oozeGourd
			|| block.getMaterial() == Material.iron && AbyssalCraft.oozeIron || block.getMaterial() == Material.clay && AbyssalCraft.oozeClay)
				return !blockBlacklist.contains(block.getBlock()) && !AbyssalCraftAPI.getShoggothBlockBlacklist().contains(block.getBlock());
		return false;
	}

	public void initBlacklist(){
		blockBlacklist.add(ACBlocks.shoggoth_ooze);
		blockBlacklist.add(Blocks.bedrock);
		blockBlacklist.add(Blocks.crafting_table);
		blockBlacklist.add(ACBlocks.ethaxium);
		blockBlacklist.add(ACBlocks.ethaxium_brick);
		blockBlacklist.add(ACBlocks.ethaxium_pillar);
		blockBlacklist.add(ACBlocks.dark_ethaxium_brick);
		blockBlacklist.add(ACBlocks.dark_ethaxium_pillar);
		blockBlacklist.add(ACBlocks.monolith_stone);
		blockBlacklist.add(ACBlocks.shoggoth_biomass);
		blockBlacklist.add(ACBlocks.block_of_ethaxium);
	}
}