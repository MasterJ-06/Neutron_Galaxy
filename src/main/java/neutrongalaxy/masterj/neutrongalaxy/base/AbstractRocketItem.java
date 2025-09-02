package neutrongalaxy.masterj.neutrongalaxy.base;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import neutrongalaxy.masterj.neutrongalaxy.entities.RocketEntity;
import neutrongalaxy.masterj.neutrongalaxy.init.BlockInit;

public class AbstractRocketItem extends Item {

    public AbstractRocketItem(Properties p_220015_) {
        super(p_220015_);
    }

    public InteractionResult useOn(UseOnContext ctx) {
        Level level = ctx.getLevel();
        BlockPos blockpos = ctx.getClickedPos();
        BlockState blockstate = level.getBlockState(blockpos);
        if (!blockstate.is(BlockInit.LAUNCH_PAD.get())) {// || !blockstate.is(Blocks.RAIL) || !blockstate.is(Blocks.POWERED_RAIL)
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
