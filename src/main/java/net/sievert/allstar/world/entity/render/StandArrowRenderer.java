package net.sievert.allstar.world.entity.render;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.ArrowRenderState;
import net.minecraft.resources.ResourceLocation;
import net.sievert.allstar.world.entity.StandArrowEntity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class StandArrowRenderer extends ArrowRenderer<StandArrowEntity, ArrowRenderState> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath("allstar", "textures/entity/projectile/stand_arrow.png");

    public StandArrowRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    protected @NotNull ResourceLocation getTextureLocation(@NotNull ArrowRenderState state) {
        return TEXTURE;
    }

    @Override
    public @NotNull ArrowRenderState createRenderState() {
        return new ArrowRenderState();
    }
}
