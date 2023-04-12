package neutrongalaxy.masterj.neutrongalaxy.client.renderer;

import com.google.common.collect.ImmutableMap;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.datafixers.util.Pair;
import com.mojang.math.Vector3f;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import neutrongalaxy.masterj.neutrongalaxy.NeutronGalaxy;
import neutrongalaxy.masterj.neutrongalaxy.client.models.rocket_model;
import neutrongalaxy.masterj.neutrongalaxy.entities.RocketEntity;

import java.util.Map;
import java.util.stream.Stream;

public class RocketEntityRenderer extends EntityRenderer<RocketEntity> {

private final Map<RocketEntity.Type, Pair<ResourceLocation, rocket_model>> rocketResources;

    public RocketEntityRenderer(EntityRendererProvider.Context ctx) {
        super(ctx);
        this.shadowRadius = 0.8F;
        this.rocketResources = Stream.of(RocketEntity.Type.values()).collect(ImmutableMap.toImmutableMap((p_173938_) -> {
            return p_173938_;
        }, (p_234575_) -> {
            return Pair.of(new ResourceLocation(NeutronGalaxy.MODID, "textures/entities/rocket.png"), this.createRocketModel(ctx));
        }));
    }

    private rocket_model createRocketModel(EntityRendererProvider.Context p_234569_) {
        ModelLayerLocation modellayerlocation = rocket_model.LAYER_LOCATION;
        return new rocket_model(p_234569_.bakeLayer(modellayerlocation));
    }

    public void render(RocketEntity p_113929_, float p_113930_, float p_113931_, PoseStack p_113932_, MultiBufferSource p_113933_, int p_113934_) {
        p_113932_.pushPose();
//        p_113932_.translate(0.0D, 0.375D, 0.0D);
        p_113932_.translate(0.0D, 4.5D, 0.0D);
        p_113932_.mulPose(Vector3f.YP.rotationDegrees(180.0F - p_113930_));
        float f = (float)p_113929_.getHurtTime() - p_113931_;
        float f1 = p_113929_.getDamage() - p_113931_;
        if (f1 < 0.0F) {
            f1 = 0.0F;
        }

        if (f > 0.0F) {
            p_113932_.mulPose(Vector3f.XP.rotationDegrees(Mth.sin(f) * f * f1 / 10.0F * (float)p_113929_.getHurtDir()));
        }

        Pair<ResourceLocation, rocket_model> pair = getModelWithLocation(p_113929_);
        ResourceLocation resourcelocation = pair.getFirst();
        rocket_model rocketModel = pair.getSecond();
        p_113932_.scale(-3F, -3F, 3F);
        p_113932_.mulPose(Vector3f.YP.rotationDegrees(90.0F));
        rocketModel.setupAnim(p_113929_, p_113931_, 0.0F, -0.1F, 0.0F, 0.0F);
        VertexConsumer vertexconsumer = p_113933_.getBuffer(rocketModel.renderType(resourcelocation));
        rocketModel.renderToBuffer(p_113932_, vertexconsumer, p_113934_, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);

        p_113932_.popPose();
        super.render(p_113929_, p_113930_, p_113931_, p_113932_, p_113933_, p_113934_);
    }

    @Deprecated // forge: override getModelWithLocation to change the texture / model
    public ResourceLocation getTextureLocation(RocketEntity p_113927_) {
        return getModelWithLocation(p_113927_).getFirst();
    }

    public Pair<ResourceLocation, rocket_model> getModelWithLocation(RocketEntity rocket) {
        return this.rocketResources.get(rocket.getRocketType());
    }
}