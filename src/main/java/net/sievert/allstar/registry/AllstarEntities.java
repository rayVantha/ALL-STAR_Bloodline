package net.sievert.allstar.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sievert.allstar.Allstar;
import net.sievert.allstar.world.entity.StandArrowEntity;

import java.util.function.Supplier;

public class AllstarEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(Registries.ENTITY_TYPE, Allstar.MOD_ID);

    public static final ResourceKey<EntityType<?>> STAND_ARROW_KEY =
            ResourceKey.create(Registries.ENTITY_TYPE,
                    ResourceLocation.fromNamespaceAndPath(Allstar.MOD_ID, "stand_arrow"));

    public static final Supplier<EntityType<StandArrowEntity>> STAND_ARROW =
            ENTITY_TYPES.register("stand_arrow",
                    () -> EntityType.Builder.<StandArrowEntity>of(
                                    StandArrowEntity::new,
                                    MobCategory.MISC
                            )
                            .sized(0.5f, 0.5f)
                            .clientTrackingRange(4)
                            .updateInterval(20)
                            .build(STAND_ARROW_KEY)
            );

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
