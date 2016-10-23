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

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;

import com.shinoow.abyssalcraft.AbyssalCraft;
import com.shinoow.abyssalcraft.api.AbyssalCraftAPI;
import com.shinoow.abyssalcraft.api.block.ACBlocks;
import com.shinoow.abyssalcraft.api.entity.EntityUtil;

public class BlockAntiliquid extends BlockFluidClassic {

	public static final MaterialLiquid antimatter = new MaterialLiquid(MapColor.silverColor);


	public BlockAntiliquid() {
		super(AbyssalCraft.antifluid, Material.water);
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		return FULL_BLOCK_AABB;
	}

	@Override
	public AxisAlignedBB getSelectedBoundingBox(IBlockState blockState, World worldIn, BlockPos pos)
	{
		return NULL_AABB;
	}

	@Override
	public MapColor getMapColor(IBlockState state){
		return MapColor.silverColor;
	}

	@Override
	public boolean canDisplace(IBlockAccess world, BlockPos pos) {
		if(world.getBlockState(pos).getBlock() == ACBlocks.liquid_coralium || world.getBlockState(pos).getMaterial() == Material.water &&
				world.getBlockState(pos).getBlock() != ACBlocks.liquid_coralium && world.getBlockState(pos).getBlock() != this || world.getBlockState(pos).getMaterial() == Material.lava)
			return true;
		return super.canDisplace(world, pos);
	}

	@Override
	public boolean displaceIfPossible(World world, BlockPos pos) {

		if(!world.isRemote && world.getBlockState(pos).getBlock() == ACBlocks.liquid_coralium)
			world.setBlockState(pos, ACBlocks.coralium_stone.getDefaultState());

		if(!world.isRemote && world.getBlockState(pos).getMaterial() == Material.water && world.getBlockState(pos).getBlock() != ACBlocks.liquid_coralium && world.getBlockState(pos).getBlock() != this)
			world.setBlockState(pos, Blocks.packed_ice.getDefaultState());

		if(!world.isRemote && world.getBlockState(pos).getMaterial() == Material.lava)
			world.setBlockState(pos, Blocks.obsidian.getDefaultState());

		return super.displaceIfPossible(world, pos);
	}

	@Override
	public void onEntityCollidedWithBlock(World par1World, BlockPos pos, IBlockState state, Entity par5Entity) {
		super.onEntityCollidedWithBlock(par1World, pos, state, par5Entity);

		if(par5Entity instanceof EntityLivingBase && !EntityUtil.isEntityAnti((EntityLivingBase)par5Entity)){
			((EntityLivingBase)par5Entity).addPotionEffect(new PotionEffect(MobEffects.moveSlowdown, 400));
			((EntityLivingBase)par5Entity).addPotionEffect(new PotionEffect(MobEffects.blindness, 400));
			((EntityLivingBase)par5Entity).addPotionEffect(new PotionEffect(MobEffects.weakness, 400));
			((EntityLivingBase)par5Entity).addPotionEffect(new PotionEffect(MobEffects.hunger, 400));
			((EntityLivingBase)par5Entity).addPotionEffect(new PotionEffect(MobEffects.nightVision, 400));
			((EntityLivingBase)par5Entity).addPotionEffect(new PotionEffect(AbyssalCraftAPI.antimatter_potion, 200));
		}
		if(par5Entity instanceof EntityItem && AbyssalCraft.antiItemDisintegration)
			par5Entity.setDead();
	}
}