package io.github.trashoflevillage.cubed_cards.items;

import io.github.trashoflevillage.cubed_cards.CubedCards;
import io.github.trashoflevillage.cubed_cards.items.custom.CardBinderItem;
import io.github.trashoflevillage.cubed_cards.items.custom.CardItem;
import io.github.trashoflevillage.cubed_cards.items.custom.PackItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item PACK = registerItem("pack", new PackItem(new Item.Settings().maxDamage(6).maxCount(1)));
    public static final Item CARD_BINDER = registerItem("card_binder", new CardBinderItem(new Item.Settings().maxCount(1)));

    public static final Item CARD_CREEPER = registerItem("card_creeper", new CardItem(new Item.Settings()));
    public static final Item CARD_ZOMBIE = registerItem("card_zombie", new CardItem(new Item.Settings()));
    public static final Item CARD_SKELETON = registerItem("card_skeleton", new CardItem(new Item.Settings()));
    public static final Item CARD_SPIDER = registerItem("card_spider", new CardItem(new Item.Settings()));
    public static final Item CARD_PIGLIN = registerItem("card_piglin", new CardItem(new Item.Settings()));
    public static final Item CARD_CYBORG_ZOMBIE = registerItem("card_cyborg_zombie", new CardItem(new Item.Settings()));
    public static final Item CARD_GREAT_SLUDGE = registerItem("card_great_sludge", new CardItem(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(CubedCards.MOD_ID, name), item);
    }
    
    public static void registerModItems() {
        CubedCards.LOGGER.info("Registering items for " + CubedCards.MOD_ID + ".");
    }
}