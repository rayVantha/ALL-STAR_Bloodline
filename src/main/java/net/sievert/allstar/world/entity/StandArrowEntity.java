package net.sievert.allstar.world.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.sievert.allstar.registry.AllstarEntities;
import net.sievert.allstar.registry.AllstarItems;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class StandArrowEntity extends AbstractArrow {

    public StandArrowEntity(EntityType<? extends StandArrowEntity> type, Level level) {
        super(type, level);
    }

    public StandArrowEntity(Level level, LivingEntity owner, ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        super(AllstarEntities.STAND_ARROW.get(), owner, level, pickupItemStack, firedFromWeapon);
    }

    public StandArrowEntity(Level level, double x, double y, double z, ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        super(AllstarEntities.STAND_ARROW.get(), x, y, z, level, pickupItemStack, firedFromWeapon);
    }

    @Override
    protected @NotNull ItemStack getDefaultPickupItem() {
        return new ItemStack(AllstarItems.STAND_ARROW.get());
    }
}
