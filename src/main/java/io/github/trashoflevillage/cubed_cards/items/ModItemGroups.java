package io.github.trashoflevillage.cubed_cards.items;

import io.github.trashoflevillage.cubed_cards.CubedCards;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup CARDS_GROUP =
            Registry.register(Registries.ITEM_GROUP,
                    new Identifier(CubedCards.MOD_ID,
                    "cards"),
                    FabricItemGroup.builder().displayName(Text.translatable("itemgroup.cards"))
                    .icon(() -> new ItemStack(ModItems.PACK)).entries((displayContext, entries) -> {
                                entries.add(ModItems.PACK);
                                entries.add(ModItems.CARD_BINDER);
                                entries.add(ModItems.CARD_CREEPER);
                                entries.add(ModItems.CARD_ZOMBIE);
                                entries.add(ModItems.CARD_SKELETON);
                                entries.add(ModItems.CARD_SPIDER);
                                entries.add(ModItems.CARD_PIGLIN);
                                entries.add(ModItems.CARD_CYBORG_ZOMBIE);
                                entries.add(ModItems.CARD_GREAT_SLUDGE);
                    }).build());

    public static void registerItemGroups() {

    }
}
