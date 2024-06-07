package io.github.trashoflevillage.cubed_cards.items.custom;

import com.sun.security.auth.callback.TextCallbackHandler;
import io.github.trashoflevillage.cubed_cards.CubedCards;
import io.github.trashoflevillage.cubed_cards.items.ModItemGroups;
import io.github.trashoflevillage.cubed_cards.util.ModTags;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.client.item.TooltipData;
import net.minecraft.client.item.TooltipType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.context.LootContextType;
import net.minecraft.loot.entry.LootTableEntry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.command.LootCommand;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.OrderedText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextContent;
import net.minecraft.util.*;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PackItem extends Item {
    private static final int OPEN_DELAY = 20;
    private static final Random rng = Random.create();

    public PackItem(Settings settings) {
        super(settings);
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }

    public int getMaxUseTime(ItemStack stack) {
        return 72000;
    }

    @Override
    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        if (remainingUseTicks < getMaxUseTime(stack) && remainingUseTicks % OPEN_DELAY == 0) {
            if (!world.isClient()) dropLoot(world, user, stack);
            EquipmentSlot slot = EquipmentSlot.MAINHAND;
            if (user.getEquippedStack(slot) != stack) slot = EquipmentSlot.OFFHAND;
            stack.damage(1, user, slot);
        }
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        user.setCurrentHand(hand);
        return TypedActionResult.consume(itemStack);
    }

    private void dropLoot(World world, LivingEntity user, ItemStack usedItem) {
        TagKey<Item> tag;
        switch(usedItem.getDamage()) {
            case 3: tag = ModTags.Items.RARE_CARDS; break;
            case 4: if (rng.nextFloat() <= .3f) tag = ModTags.Items.SUPER_RARE_CARDS; else tag = ModTags.Items.COMMON_CARDS; break;
            case 5: if (rng.nextFloat() <= .1f) tag = ModTags.Items.LEGENDARY_CARDS; else tag = ModTags.Items.COMMON_CARDS; break;
            default: tag = ModTags.Items.COMMON_CARDS; break;
        }
        Item item = Registries.ITEM.getRandomEntry(tag, rng).get().value();
        if (item != null) {
            ItemEntity itemEntity = user.dropItem(item);
            if (itemEntity != null) itemEntity.setPickupDelay(0);
        }
    }
}
