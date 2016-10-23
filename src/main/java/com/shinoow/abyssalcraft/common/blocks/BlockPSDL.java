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

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.shinoow.abyssalcraft.AbyssalCraft;

public class BlockPSDL extends Block {

	public BlockPSDL()
	{
		super(Material.rock);
		this.setHarvestLevel("pickaxe", 5);
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		return new AxisAlignedBB(0.2F, 0.0F, 0.2F, 0.8F, 1.0F, 0.8F);
	}

	@Override
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state)
	{
		return false;
	}

	@Override
	public void randomDisplayTick(IBlockState state, World par1World, BlockPos pos, Random par5Random)
	{
		super.randomDisplayTick(state, par1World, pos, par5Random);

		if(AbyssalCraft.particleBlock)
			if (par5Random.nextInt(10) == 0)
				par1World.spawnParticle(EnumParticleTypes.SMOKE_LARGE, pos.getX() + par5Random.nextFloat(), pos.getY() + 1.1F, pos.getZ() + par5Random.nextFloat(), 0.0D, 0.0D, 0.0D);
	}
}