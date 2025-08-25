package net.sievert.allstar.registry;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sievert.allstar.Allstar;

public class AllstarItems {


    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Allstar.MOD_ID);

    public static final DeferredItem<Item> STAND_ARROW = ITEMS.registerItem(
            "stand_arrow",
            props -> new Item(props.rarity(Rarity.RARE))
    );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
