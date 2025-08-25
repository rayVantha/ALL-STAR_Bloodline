package net.sievert.allstar.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.sievert.allstar.datagen.block.AllstarBlockLootTableProvider;
import net.sievert.allstar.datagen.block.AllstarBlockTagProvider;
import net.sievert.allstar.datagen.item.AllstarItemTagProvider;
import net.sievert.allstar.datagen.lang.AllstarLanguageProvider;
import net.sievert.allstar.datagen.model.AllstarModelProvider;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Main entry point for registering all datagen providers.
 * Registered via Allstar constructor:
 *     modEventBus.addListener(AllstarDataGenerator::gatherServerData);
 *     modEventBus.addListener(AllstarDataGenerator::gatherClientData);
 */
public class AllstarDataGenerator {

    public static void gatherServerData(GatherDataEvent.Server event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookup = event.getLookupProvider();

        BlockTagsProvider blockTagsProvider = new AllstarBlockTagProvider(packOutput, lookup);
        generator.addProvider(true, blockTagsProvider);

        generator.addProvider(true, new LootTableProvider(
                packOutput,
                Collections.emptySet(),
                List.of(
                        new LootTableProvider.SubProviderEntry(
                                AllstarBlockLootTableProvider::new,
                                LootContextParamSets.BLOCK
                        )
                ),
                lookup
        ));

        generator.addProvider(true, new AllstarItemTagProvider(packOutput, lookup, blockTagsProvider.contentsGetter()));
    }

    public static void gatherClientData(GatherDataEvent.Client event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();

        generator.addProvider(true, new AllstarModelProvider(packOutput));
        generator.addProvider(true, new AllstarLanguageProvider(packOutput));
    }
}
