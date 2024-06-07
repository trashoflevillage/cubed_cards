package io.github.trashoflevillage.cubed_cards.datagen;

import io.github.trashoflevillage.cubed_cards.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.PACK, Models.GENERATED);
        itemModelGenerator.register(ModItems.CARD_BINDER, Models.GENERATED);

        itemModelGenerator.register(ModItems.CARD_CREEPER, Models.GENERATED);
        itemModelGenerator.register(ModItems.CARD_ZOMBIE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CARD_SKELETON, Models.GENERATED);
        itemModelGenerator.register(ModItems.CARD_SPIDER, Models.GENERATED);
        itemModelGenerator.register(ModItems.CARD_PIGLIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.CARD_CYBORG_ZOMBIE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CARD_GREAT_SLUDGE, Models.GENERATED);
    }
}
