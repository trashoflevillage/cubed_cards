package io.github.trashoflevillage.cubed_cards.datagen;

import io.github.trashoflevillage.cubed_cards.items.ModItems;
import io.github.trashoflevillage.cubed_cards.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModTags.Items.COMMON_CARDS)
                .add(ModItems.CARD_CREEPER)
                .add(ModItems.CARD_ZOMBIE)
                .add(ModItems.CARD_SKELETON)
                .add(ModItems.CARD_SPIDER);

        getOrCreateTagBuilder(ModTags.Items.RARE_CARDS)
                .add(ModItems.CARD_PIGLIN);

        getOrCreateTagBuilder(ModTags.Items.SUPER_RARE_CARDS)
                .add(ModItems.CARD_CYBORG_ZOMBIE);

        getOrCreateTagBuilder(ModTags.Items.LEGENDARY_CARDS)
                .add(ModItems.CARD_GREAT_SLUDGE);
    }
}
