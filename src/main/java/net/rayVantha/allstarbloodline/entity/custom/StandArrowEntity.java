package net.rayVantha.allstarbloodline.entity.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
// Importar ModItems para getPickupItem
import net.rayVantha.allstarbloodline.item.ModItems;
// Asegúrate de tener tu ModEntities.STAND_ARROW_ENTITY registrado y accesible.
// import net.rayVantha.allstarbloodline.entity.ModEntities;

public class StandArrowEntity extends AbstractArrow {

    // Necesitarás un constructor que coincida con cómo lo llamas desde StandArrowItem.
    // Opción 1: Si solo pasas Level y shooter desde StandArrowItem
    public StandArrowEntity(EntityType<? extends AbstractArrow> entityType, Level level) {
        super(entityType, level);
    }

    public StandArrowEntity(EntityType<? extends AbstractArrow> entityType, double x, double y, double z, Level level) {
        super(entityType, x, y, z, level);
    }

    public StandArrowEntity(EntityType<? extends AbstractArrow> entityType, LivingEntity shooter, Level level) {
        super(entityType, shooter, level);
    }

    // Este es un constructor común y útil.
    // Asegúrate de que ModEntities.STAND_ARROW_ENTITY esté definido antes de usarlo.
    /*
    public StandArrowEntity(Level level, LivingEntity shooter) {
        super(ModEntities.STAND_ARROW_ENTITY.get(), shooter, level);
    }

    public StandArrowEntity(Level level, double x, double y, double z) {
        super(ModEntities.STAND_ARROW_ENTITY.get(), x, y, z, level);
    }
    */

    // Constructor que podrías usar desde createArrow si pasas el ItemStack
    // public StandArrowEntity(Level level, LivingEntity shooter, ItemStack piercingIgnoreItemStack) {
    //     super(ModEntities.STAND_ARROW_ENTITY.get(), shooter, level, piercingIgnoreItemStack);
    // }


    @Override
    protected ItemStack getPickupItem() {
        // Devuelve el item StandArrow cuando la flecha se recoge del suelo.
        return new ItemStack(ModItems.STANDARROW.get());
    }

    // Aquí puedes añadir lógica personalizada para tu flecha, como:
    // - Efectos al impactar
    // - Daño específico
    // - Comportamiento de vuelo

    // Ejemplo de cómo podrías querer inicializar tu entidad si la registras así:
    // public static final RegistryObject<EntityType<StandArrowEntity>> STAND_ARROW_ENTITY = ENTITY_TYPES.register("stand_arrow",
    //        () -> EntityType.Builder.<StandArrowEntity>of(StandArrowEntity::new, MobCategory.MISC)
    //                .sized(0.5F, 0.5F)
    //                .clientTrackingRange(4)
    //                .updateInterval(20)
    //                .build(new ResourceLocation(AllStarBloodline.MOD_ID, "stand_arrow").toString()));
    // En ese caso, el constructor StandArrowEntity(EntityType<? extends AbstractArrow> entityType, Level level) sería llamado.
    // Y el constructor StandArrowEntity(EntityType<? extends AbstractArrow> entityType, LivingEntity shooter, Level level)
    // o StandArrowEntity(EntityType<? extends AbstractArrow> entityType, double x, double y, double z, Level level)
    // serían usados por el sistema.

    // Un constructor más completo y preferido para que StandArrowItem lo llame:
    public StandArrowEntity(EntityType<? extends StandArrowEntity> entityType, LivingEntity shooter, Level level, ItemStack itemStack) {
        super(entityType, shooter, level, itemStack);
    }

    // Si registras tu entidad así:
    // STAND_ARROW_ENTITY = ENTITY_TYPES.register("stand_arrow_entity",
    //    () -> EntityType.Builder.of(StandArrowEntity::new, MobCategory.MISC)
    //                          .sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20)
    //                          .build("stand_arrow_entity"));
    // El constructor StandArrowEntity(EntityType<StandArrowEntity> type, Level world) será invocado por el sistema.
    // Luego, cuando lo crees en tu StandArrowItem, usarías algo como:
    // new StandArrowEntity(ModEntities.STAND_ARROW_ENTITY.get(), shooter, level, stack)
    // Esto requiere el constructor: StandArrowEntity(EntityType<? extends StandArrowEntity> entityType, LivingEntity shooter, Level level, ItemStack itemStack)

}
