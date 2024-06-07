package io.github.trashoflevillage.cubed_cards.util;

import io.github.trashoflevillage.cubed_cards.CubedCards;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(CubedCards.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> COMMON_CARDS =
                createTag("common_cards");

        public static final TagKey<Item> RARE_CARDS =
                createTag("rare_cards");

        public static final TagKey<Item> SUPER_RARE_CARDS =
                createTag("super_rare_cards");

        public static final TagKey<Item> LEGENDARY_CARDS =
                createTag("legendary_cards");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(CubedCards.MOD_ID, name));
        }
    }
}
