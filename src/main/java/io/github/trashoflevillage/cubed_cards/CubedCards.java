package io.github.trashoflevillage.cubed_cards;

import io.github.trashoflevillage.cubed_cards.blocks.ModBlocks;
import io.github.trashoflevillage.cubed_cards.items.ModItemGroups;
import io.github.trashoflevillage.cubed_cards.items.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.block.TrialSpawnerBlock;
import net.minecraft.block.entity.TrialSpawnerBlockEntity;
import net.minecraft.block.entity.VaultBlockEntity;
import net.minecraft.block.spawner.TrialSpawnerLogic;
import net.minecraft.loot.LootTable;
import net.minecraft.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CubedCards implements ModInitializer {
	public static final String MOD_ID = "cubed_cards";
	public static final Logger LOGGER = LoggerFactory.getLogger("Cubed Cards");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Initializing Cubed Cards");

		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();

		LOGGER.info("Cubed Cards initialized!");
	}
}