package com.shulkerboxinside.mixin;

import net.minecraft.world.inventory.ShulkerBoxSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ShulkerBoxBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/** Lets shulker boxes be placed into a shulker box through the GUI (click, shift-click, drag). */
@Mixin(ShulkerBoxSlot.class)
public class ShulkerBoxSlotMixin {
    @Inject(method = "mayPlace", at = @At("HEAD"), cancellable = true)
    private void shulkerboxinside$allowShulkers(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (Block.byItem(stack.getItem()) instanceof ShulkerBoxBlock) {
            cir.setReturnValue(true);
        }
    }
}
