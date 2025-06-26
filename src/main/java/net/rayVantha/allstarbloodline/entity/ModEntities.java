package net.rayVantha.allstarbloodline.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rayVantha.allstarbloodline.AllStarBloodline;
import net.rayVantha.allstarbloodline.entity.custom.StandArrowEntity;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, AllStarBloodline.MOD_ID);

    public static final RegistryObject<EntityType<StandArrowEntity>> STAND_ARROW_ENTITY =
            ENTITY_TYPES.register("stand_arrow_entity", // Nombre de registro de la entidad
                    () -> EntityType.Builder.<StandArrowEntity>of(StandArrowEntity::new, MobCategory.MISC)
                            .sized(0.5F, 0.5F) // Tamaño del hitbox de la entidad
                            .clientTrackingRange(4) // Rango en el que los clientes rastrean esta entidad
                            .updateInterval(20) // Con qué frecuencia se actualiza la entidad (1 tick = una vez)
                            // El nombre aquí debe ser único y coincidir con el usado para el renderer si es necesario.
                            .build(AllStarBloodline.MOD_ID + ":stand_arrow_entity"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
