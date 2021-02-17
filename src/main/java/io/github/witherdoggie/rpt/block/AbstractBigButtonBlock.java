package io.github.witherdoggie.rpt.block;

import net.minecraft.block.AbstractButtonBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.enums.WallMountLocation;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public abstract class AbstractBigButtonBlock extends AbstractButtonBlock {

    public static final BooleanProperty POWERED;
    protected static final VoxelShape CEILING_X_SHAPE;
    protected static final VoxelShape CEILING_Z_SHAPE;
    protected static final VoxelShape FLOOR_X_SHAPE;
    protected static final VoxelShape FLOOR_Z_SHAPE;
    protected static final VoxelShape NORTH_SHAPE;
    protected static final VoxelShape SOUTH_SHAPE;
    protected static final VoxelShape WEST_SHAPE;
    protected static final VoxelShape EAST_SHAPE;
    protected static final VoxelShape CEILING_X_PRESSED_SHAPE;
    protected static final VoxelShape CEILING_Z_PRESSED_SHAPE;
    protected static final VoxelShape FLOOR_X_PRESSED_SHAPE;
    protected static final VoxelShape FLOOR_Z_PRESSED_SHAPE;
    protected static final VoxelShape NORTH_PRESSED_SHAPE;
    protected static final VoxelShape SOUTH_PRESSED_SHAPE;
    protected static final VoxelShape WEST_PRESSED_SHAPE;
    protected static final VoxelShape EAST_PRESSED_SHAPE;


    protected AbstractBigButtonBlock(boolean wooden, Settings settings) {
        super(wooden, settings);
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction direction = (Direction)state.get(FACING);
        boolean bl = (Boolean)state.get(POWERED);
        switch((WallMountLocation)state.get(FACE)) {
            case FLOOR:
                if (direction.getAxis() == Direction.Axis.X) {
                    return bl ? FLOOR_X_PRESSED_SHAPE : FLOOR_X_SHAPE;
                }

                return bl ? FLOOR_Z_PRESSED_SHAPE : FLOOR_Z_SHAPE;
            case WALL:
                switch(direction) {
                    case EAST:
                        return bl ? EAST_PRESSED_SHAPE : EAST_SHAPE;
                    case WEST:
                        return bl ? WEST_PRESSED_SHAPE : WEST_SHAPE;
                    case SOUTH:
                        return bl ? SOUTH_PRESSED_SHAPE : SOUTH_SHAPE;
                    case NORTH:
                    default:
                        return bl ? NORTH_PRESSED_SHAPE : NORTH_SHAPE;
                }
            case CEILING:
            default:
                if (direction.getAxis() == Direction.Axis.X) {
                    return bl ? CEILING_X_PRESSED_SHAPE : CEILING_X_SHAPE;
                } else {
                    return bl ? CEILING_Z_PRESSED_SHAPE : CEILING_Z_SHAPE;
                }
        }
    }

    static {
        POWERED = Properties.POWERED;
        CEILING_X_SHAPE = Block.createCuboidShape(2.0D, 14.0D, 5.0D, 14.0D, 16.0D, 11.0D);
        CEILING_Z_SHAPE = Block.createCuboidShape(5.0D, 14.0D, 2.0D, 11.0D, 16.0D, 14.0D);
        FLOOR_X_SHAPE = Block.createCuboidShape(2.0D, 0.0D, 5.0D, 14.0D, 2.0D, 11.0D);
        FLOOR_Z_SHAPE = Block.createCuboidShape(5.0D, 0.0D, 2.0D, 11.0D, 2.0D, 14.0D);
        NORTH_SHAPE = Block.createCuboidShape(2.0D, 6.0D, 14.0D, 14.0D, 10.0D, 16.0D);
        SOUTH_SHAPE = Block.createCuboidShape(2.0D, 6.0D, 0.0D, 14.0D, 10.0D, 2.0D);
        WEST_SHAPE = Block.createCuboidShape(14.0D, 6.0D, 2.0D, 16.0D, 10.0D, 14.0D);
        EAST_SHAPE = Block.createCuboidShape(0.0D, 6.0D, 2.0D, 2.0D, 10.0D, 14.0D);
        CEILING_X_PRESSED_SHAPE = Block.createCuboidShape(2.0D, 14.0D, 5.0D, 14.0D, 16.0D, 11.0D);
        CEILING_Z_PRESSED_SHAPE = Block.createCuboidShape(5.0D, 14.0D, 2.0D, 11.0D, 16.0D, 14.0D);
        FLOOR_X_PRESSED_SHAPE = Block.createCuboidShape(2.0D, 0.0D, 5.0D, 14.0D, 2.0D, 11.0D);
        FLOOR_Z_PRESSED_SHAPE = Block.createCuboidShape(5.0D, 0.0D, 2.0D, 11.0D, 2.0D, 14.0D);
        NORTH_PRESSED_SHAPE = Block.createCuboidShape(2.0D, 6.0D, 14.0D, 14.0D, 10.0D, 16.0D);
        SOUTH_PRESSED_SHAPE = Block.createCuboidShape(2.0D, 6.0D, 0.0D, 14.0D, 10.0D, 2.0D);
        WEST_PRESSED_SHAPE = Block.createCuboidShape(14.0D, 6.0D, 2.0D, 16.0D, 10.0D, 14.0D);
        EAST_PRESSED_SHAPE = Block.createCuboidShape(0.0D, 6.0D, 2.0D, 2.0D, 10.0D, 14.0D);
    }
}
