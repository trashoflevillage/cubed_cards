package io.github.trashoflevillage.cubed_cards.blocks;

import io.github.trashoflevillage.cubed_cards.CubedCards;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block TABLE = registerBlock("table", new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK,
                new Identifier(CubedCards.MOD_ID, name),
                block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(
                Registries.ITEM,
                new Identifier(CubedCards.MOD_ID, name),
                new BlockItem(block,
                new Item.Settings()));
    }

    public static void registerModBlocks() {
        CubedCards.LOGGER.info("Registering blocks for " + CubedCards.MOD_ID);
    }
}
