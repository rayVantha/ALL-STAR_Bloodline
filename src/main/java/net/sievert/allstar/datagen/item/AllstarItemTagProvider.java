package net.sievert.allstar.datagen.item;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.sievert.allstar.Allstar;
import net.sievert.allstar.registry.AllstarItems;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class AllstarItemTagProvider extends ItemTagsProvider {
    public AllstarItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                  CompletableFuture<TagLookup<Block>> blockTags) {
        super(output, lookupProvider, blockTags, Allstar.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {

        tag(ItemTags.ARROWS)
                .add(AllstarItems.STAND_ARROW.get());

    }


}