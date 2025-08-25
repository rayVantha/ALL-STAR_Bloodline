package net.sievert.allstar.datagen.model;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.data.PackOutput;
import net.sievert.allstar.Allstar;

public class AllstarModelProvider extends ModelProvider {

    private final PackOutput packOutput;
    public AllstarModelProvider(PackOutput output) {
        super(output, Allstar.MOD_ID);
        this.packOutput = output;

    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
          /*

        //Example
        itemModels.generateFlatItem(AllstarItems.ExampleItem.get(), ModelTemplates.FLAT_ITEM);

         */

    }



}
