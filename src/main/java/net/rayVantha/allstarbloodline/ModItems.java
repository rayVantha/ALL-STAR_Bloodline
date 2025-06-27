package net.rayVantha.allstarbloodline;

import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, AllStarBloodline.MOD_ID);

    public static final RegistryObject<Item> STANDARROW = ITEMS.register("standarrow",
            () -> new ArrowItem(new Item.Properties())); // Usar StandArrowItem en lugar de ArrowItem



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}