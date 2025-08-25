package net.sievert.allstar.datagen.block;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.sievert.allstar.Allstar;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class AllstarBlockTagProvider extends BlockTagsProvider {
    public AllstarBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, Allstar.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {

        /*

        //Example
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(AllstarBlocks.EXAMPLE.get());

         */

    }

}