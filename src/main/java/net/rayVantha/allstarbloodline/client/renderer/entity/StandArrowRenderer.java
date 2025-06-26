package net.rayVantha.allstarbloodline.client.renderer.entity;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.rayVantha.allstarbloodline.AllStarBloodline;
import net.rayVantha.allstarbloodline.entity.custom.StandArrowEntity;

public class StandArrowRenderer extends ArrowRenderer<StandArrowEntity> {

    // Textura de la flecha de vainilla para usar como ejemplo.
    // Si quieres usar una textura personalizada en el futuro, cámbiala aquí.
    // Por ejemplo: new ResourceLocation(AllStarBloodline.MOD_ID, "textures/entity/projectiles/stand_arrow.png");
    public static final ResourceLocation TEXTURE = new ResourceLocation("minecraft", "textures/entity/projectiles/arrow.png");

    public StandArrowRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(StandArrowEntity entity) {
        return TEXTURE;
    }
}
