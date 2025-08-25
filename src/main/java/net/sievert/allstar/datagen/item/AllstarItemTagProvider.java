package net.sievert.allstar.datagen.item;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.sievert.allstar.Allstar;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class AllstarItemTagProvider extends ItemTagsProvider {
    public AllstarItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                  CompletableFuture<TagLookup<Block>> blockTags) {
        super(output, lookupProvider, blockTags, Allstar.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {

        /*

        //Example
        tag(ItemTags.DURABILITY_ENCHANTABLE)
                .add(JolCraftItems.IRON_SPANNER.get());

         */

    }


}