package net.sievert.allstar.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sievert.allstar.Allstar;

import java.util.function.Supplier;

public class AllstarCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Allstar.MOD_ID);


    public static final Supplier<CreativeModeTab> ALLSTAR =
            CREATIVE_MODE_TABS.register("allstar_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.allstar.allstar"))
                    .icon(() -> new ItemStack(AllstarItems.STAND_ARROW.get()))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(AllstarItems.STAND_ARROW);

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }


}
