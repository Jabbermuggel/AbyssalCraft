package com.shinoow.abyssalcraft.integration.nei;

import net.minecraft.item.ItemStack;
import codechicken.nei.api.*;

import com.shinoow.abyssalcraft.AbyssalCraft;

public class NEIACConfig implements IConfigureNEI {

	@Override
	public void loadConfig() {
		API.registerRecipeHandler(new CrystallizerRecipeHandler());
		API.registerUsageHandler(new CrystallizerRecipeHandler());

		API.registerRecipeHandler(new TransmutatorRecipeHandler());
		API.registerUsageHandler(new TransmutatorRecipeHandler());

		API.hideItem(new ItemStack(AbyssalCraft.devsword));
		API.hideItem(new ItemStack(AbyssalCraft.crystallizer_on));
		API.hideItem(new ItemStack(AbyssalCraft.transmutator_on));
	}

	@Override
	public String getName() {

		return "AbyssalCraft Plugin";
	}

	@Override
	public String getVersion() {

		return AbyssalCraft.version;
	}
}