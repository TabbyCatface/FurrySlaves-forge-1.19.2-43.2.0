package com.tabbycatface.nsfw.furryslaves.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Rod_Block extends DirectionalBlock {
    // There is also a HorizontalDirectionalBlock
    public Rod_Block(Properties properties) {
        super(properties);
    }


    // Defining bounding boxes for a rod:
    // (X) (East-West)
    private static final VoxelShape SHAPE_EW_X =
            Block.box(0, 6, 6, 16, 10, 10);
    // (Y) (Up-Down)
    private static final VoxelShape SHAPE_UD_Y =
            Block.box(6, 0, 6, 10, 16, 10);
    // (Z) (North-South)
    private static final VoxelShape SHAPE_NS_Z =
            Block.box(6, 6, 0, 10, 10, 16);

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos blockPos, CollisionContext context) {
        Direction dir_ = state.getValue(FACING);

        if (dir_ == Direction.EAST || dir_ == Direction.WEST) {
            return SHAPE_EW_X;
        } else if (dir_ == Direction.NORTH || dir_ == Direction.SOUTH) {
            return SHAPE_NS_Z;
        }
        return SHAPE_UD_Y;
    }


    /*
    // A function to cycle through states by right clicking the block
    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult result) {

        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            level.setBlock(blockPos, state.cycle(FACING), 3);
        }

        return super.use(state, level, blockPos, player, hand, result);
    }
     */




    // Next three are taken from furnace block to control placement rotation
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext placeContext) {
        return this.defaultBlockState().setValue(FACING, placeContext.getNearestLookingDirection().getOpposite());
    }





    // Adding the property to the block state builder so it counts during chunk rebuild
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}