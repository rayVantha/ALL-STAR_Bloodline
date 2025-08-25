package net.sievert.allstar.datagen.model;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;
import net.sievert.allstar.Allstar;
import net.sievert.allstar.registry.AllstarItems;
import org.jetbrains.annotations.NotNull;

public class AllstarModelProvider extends ModelProvider {

    private final PackOutput packOutput;
    public AllstarModelProvider(PackOutput output) {
        super(output, Allstar.MOD_ID);
        this.packOutput = output;

    }

    @Override
    protected void registerModels(@NotNull BlockModelGenerators blockModels, ItemModelGenerators itemModels) {

        itemModels.generateFlatItem(AllstarItems.STAND_ARROW.get(), ModelTemplates.FLAT_HANDHELD_ITEM);

    }



}
