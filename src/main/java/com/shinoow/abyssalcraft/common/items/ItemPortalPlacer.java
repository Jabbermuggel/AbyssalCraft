/*******************************************************************************
 * AbyssalCraft
 * Copyright (c) 2012 - 2020 Shinoow.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 *
 * Contributors:
 *     Shinoow -  implementation
 ******************************************************************************/
package com.shinoow.abyssalcraft.common.items;

import java.util.List;
import java.util.stream.Collectors;

import com.shinoow.abyssalcraft.api.dimension.DimensionData;
import com.shinoow.abyssalcraft.api.dimension.DimensionDataRegistry;
import com.shinoow.abyssalcraft.api.ritual.RitualRegistry;
import com.shinoow.abyssalcraft.common.entity.EntityPortal;
import com.shinoow.abyssalcraft.lib.ACLib;
import com.shinoow.abyssalcraft.lib.ACTabs;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemPortalPlacer extends ItemACBasic {

	private final int key;

	public ItemPortalPlacer(int key, String unlocalizedName){
		super(unlocalizedName);
		this.key = key;
		maxStackSize = 1;
		setCreativeTab(ACTabs.tabTools);
	}

	@Override
	public boolean isFull3D()
	{
		return true;
	}

	@Override
	public String getItemStackDisplayName(ItemStack par1ItemStack) {

		switch(key){
		case 1:
			return TextFormatting.DARK_RED + super.getItemStackDisplayName(par1ItemStack);
		case 2:
			return TextFormatting.BLUE + super.getItemStackDisplayName(par1ItemStack);
		default:
			return super.getItemStackDisplayName(par1ItemStack);
		}
	}

	@Override
	public void addInformation(ItemStack par1ItemStack, World world, List list, ITooltipFlag is){
		list.add(I18n.format("tooltip.portalplacer.1"));
		list.add(I18n.format("tooltip.portalplacer.2"));
		if(key > 0)
			list.add(I18n.format("tooltip.portalplacer.3"));
		if(Minecraft.getMinecraft().world != null && Minecraft.getMinecraft().world.provider != null)
			if(!isCorrectDim(Minecraft.getMinecraft().world.provider.getDimension()))
				list.add(TextFormatting.DARK_RED+""+TextFormatting.ITALIC+I18n.format("tooltip.portalplacer.4"));
		if(!par1ItemStack.hasTagCompound())
			par1ItemStack.setTagCompound(new NBTTagCompound());
		int dim = par1ItemStack.getTagCompound().getInteger("Dimension");
		list.add(String.format("Dimension: %s", DimensionDataRegistry.instance().getDimensionNameMappings().get(dim)));
		DimensionData data = DimensionDataRegistry.instance().getDataForDim(dim);
		if(data != null && world != null) {
			int currDim = world.provider.getDimension();
			boolean nope = false;
			if(data.getId() == currDim) {
				nope = true;
			} else {
				if(!data.getConnectedDimensions().isEmpty() && !data.getConnectedDimensions().contains(currDim)) {
					//TODO insert gateway key override check here
					nope = true;
				} else {
					if(!RitualRegistry.instance().canPerformAction(currDim, 4)) {
						nope = true;
					}
				}
			}
			if(nope)
				list.add(TextFormatting.DARK_RED+""+TextFormatting.ITALIC+"You can't create a portal for that dimension here!");
		}
	}

	private boolean isCorrectDim(int dim){
		switch(key){
		case 0:
			if(dim == 0 || dim == ACLib.abyssal_wasteland_id)
				return true;
			else if(DimensionDataRegistry.instance().getGatewayKeyOverride(dim) == 0)
				return true;
			else return false;
		case 1:
			if(dim == 0 || dim == ACLib.abyssal_wasteland_id ||
			dim == ACLib.dreadlands_id)
				return true;
			else if(DimensionDataRegistry.instance().getGatewayKeyOverride(dim) >= 0 && DimensionDataRegistry.instance().getGatewayKeyOverride(dim) < 2)
				return true;
			else return false;
		case 2:
			if(dim == 0 || dim == ACLib.abyssal_wasteland_id ||
			dim == ACLib.dreadlands_id ||
			dim == ACLib.omothol_id ||
			dim == ACLib.dark_realm_id)
				return true;
			else if(DimensionDataRegistry.instance().getGatewayKeyOverride(dim) >= 0)
				return true;
			else return false;
		default:
			return false;
		}
	}

	private boolean dimWarning(int dim){
		switch(key){
		case 0:
			if(dim == ACLib.dreadlands_id ||
			dim == ACLib.omothol_id ||
			dim == ACLib.dark_realm_id)
				return true;
			else if(DimensionDataRegistry.instance().getGatewayKeyOverride(dim) > 0)
				return true;
			else return false;
		case 1:
			if(dim == ACLib.omothol_id ||
			dim == ACLib.dark_realm_id)
				return true;
			else if(DimensionDataRegistry.instance().getGatewayKeyOverride(dim) > 1)
				return true;
			else return false;
		default:
			return false;
		}
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
		ItemStack stack = playerIn.getHeldItem(handIn);
	
		if(!worldIn.isRemote){
			
			if(!stack.hasTagCompound())
				stack.setTagCompound(new NBTTagCompound());
			
			int dim = stack.getTagCompound().getInteger("Dimension");
			int newDim = 0;
			List<DimensionData> dims = DimensionDataRegistry.instance().getDimensions().stream().filter(d -> d.getGatewayKey() <= key).collect(Collectors.toList());
			if(playerIn.isSneaking()) {
				for(int i = dims.size()-1; i > 0; i--) {
					DimensionData data = dims.get(i);
					if(data.getId() == dim) {
						if(i == 0) {
							newDim = dims.get(dims.size() -1).getId();
						} else {
							newDim = dims.get(i-1).getId();
						}
						break;
					}
				}
			} else {
				for(int i = 0; i < dims.size(); i++) {
					DimensionData data = dims.get(i);
					if(data.getId() == dim) {
						if(i == dims.size() -1) {
							newDim = dims.get(0).getId();
						} else {
							newDim = dims.get(i+1).getId();
						}
						break;
					}
				}
			}
			
			stack.getTagCompound().setInteger("Dimension", newDim);
			playerIn.sendStatusMessage(new TextComponentString(String.format("%d", newDim)), true);
		}
		
        return new ActionResult<ItemStack>(EnumActionResult.PASS, stack);
    }
}
