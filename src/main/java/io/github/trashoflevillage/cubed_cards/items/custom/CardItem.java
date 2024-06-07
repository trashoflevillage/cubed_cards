package io.github.trashoflevillage.cubed_cards.items.custom;

import io.github.trashoflevillage.cubed_cards.util.ModTags;
import net.minecraft.client.item.TooltipType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

import java.util.List;

public class CardItem extends Item {
    public CardItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);

        Text rarityTooltipText = null;

        if (stack.isIn(ModTags.Items.COMMON_CARDS)) rarityTooltipText = Text.translatable("cardrarity.common");
        else if (stack.isIn(ModTags.Items.RARE_CARDS)) rarityTooltipText = Text.translatable("cardrarity.rare");
        else if (stack.isIn(ModTags.Items.SUPER_RARE_CARDS)) rarityTooltipText = Text.translatable("cardrarity.super_rare");
        else if (stack.isIn(ModTags.Items.LEGENDARY_CARDS)) rarityTooltipText = Text.translatable("cardrarity.legendary");

        if (rarityTooltipText != null) tooltip.add(rarityTooltipText);
    }
}
