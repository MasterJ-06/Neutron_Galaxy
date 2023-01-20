package neutrongalaxy.masterj.neutrongalaxy.base;

import net.minecraft.core.BlockPos;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseRailBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.RailShape;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import neutrongalaxy.masterj.neutrongalaxy.entities.RocketEntity;
import neutrongalaxy.masterj.neutrongalaxy.init.BlockInit;

import java.util.List;
import java.util.function.Predicate;

public class RocketItem extends Item {

    public RocketItem(Item.Properties p_220015_) {
        super(p_220015_);
    }

    public InteractionResult useOn(UseOnContext ctx) {
        Level level = ctx.getLevel();
        BlockPos blockpos = ctx.getClickedPos();
        BlockState blockstate = level.getBlockState(blockpos);
        if (!blockstate.is(BlockInit.LAUNCH_PAD.get())) {
            return InteractionResult.FAIL;
        } else {
            ItemStack itemstack = ctx.getItemInHand();
            if (!level.isClientSide) {

                level.addFreshEntity(new RocketEntity(level, (double)blockpos.getX() + 0.5D, (double)blockpos.getY() + 0.0625D, (double)blockpos.getZ() + 0.5D));
                level.gameEvent(GameEvent.ENTITY_PLACE, blockpos, GameEvent.Context.of(ctx.getPlayer(), level.getBlockState(blockpos.below())));
            }

            itemstack.shrink(1);
            return InteractionResult.sidedSuccess(level.isClientSide);
        }
    }
}
