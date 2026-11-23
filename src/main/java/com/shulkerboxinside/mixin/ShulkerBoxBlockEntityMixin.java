package com.shulkerboxinside.mixin;

import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ShulkerBoxBlock;
import net.minecraft.world.level.block.entity.ShulkerBoxBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/** Lets hoppers/droppers insert shulker boxes into a placed shulker box. */
@Mixin(ShulkerBoxBlockEntity.class)
public class ShulkerBoxBlockEntityMixin {
    @Inject(method = "canPlaceItemThroughFace", at = @At("HEAD"), cancellable = true)
    private void shulkerboxinside$allowShulkers(int slot, ItemStack stack, Direction direction,
                                              CallbackInfoReturnable<Boolean> cir) {
        if (Block.byItem(stack.getItem()) instanceof ShulkerBoxBlock) {
            cir.setReturnValue(true);
        }
    }
}
