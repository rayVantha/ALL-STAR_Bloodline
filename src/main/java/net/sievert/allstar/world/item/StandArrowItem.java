package net.sievert.allstar.world.item;

import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.sievert.allstar.world.entity.StandArrowEntity;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class StandArrowItem extends ArrowItem {

    public StandArrowItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResult use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand hand) {
        super.use(level, player, hand);

        int requiredLevels = 30;
        int currentLevels = player.experienceLevel;

        if (currentLevels < requiredLevels && !player.isCreative()) {
            DamageSources sources = level.damageSources();
            DamageSource failSource = sources.source(
                    ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath("allstar", "stand_arrow_fail"))
            );
            player.hurt(failSource, Float.MAX_VALUE);
            return InteractionResult.SUCCESS;
        }

        player.giveExperienceLevels(-requiredLevels);
        player.addEffect(new MobEffectInstance(MobEffects.NAUSEA, 20 * 30, 0));
        player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 20 * 30, 0));
        player.setHealth(1.0F);
        player.playSound(SoundEvents.AMBIENT_CAVE.value(), 1.0F, 1.0F);
        player.swing(hand);

        return InteractionResult.SUCCESS;
    }

    @Override
    public @NotNull Projectile asProjectile(@NotNull Level level, Position pos, ItemStack stack, @NotNull Direction dir) {
        StandArrowEntity arrow = new StandArrowEntity(level, pos.x(), pos.y(), pos.z(), stack.copyWithCount(1), null);
        arrow.pickup = AbstractArrow.Pickup.ALLOWED;
        return arrow;
    }

    @Override
    public @NotNull AbstractArrow createArrow(@NotNull Level level, ItemStack ammo, @NotNull LivingEntity shooter, @Nullable ItemStack weapon) {
        return new StandArrowEntity(level, shooter, ammo.copyWithCount(1), weapon);
    }
}