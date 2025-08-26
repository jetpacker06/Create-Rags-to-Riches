package com.jetpacker06.createragstoriches.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SugarCaneBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.PlantType;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;

public class CrimsonCaneBlock extends SugarCaneBlock {
    public CrimsonCaneBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean canSurvive(@NotNull BlockState pState, LevelReader pLevel, BlockPos pPos) {
        BlockState soil = pLevel.getBlockState(pPos.below());
        if (soil.is(this)) {
            return true;
        }
        if (!soil.is(BlockTags.SOUL_FIRE_BASE_BLOCKS)) {
            return false;
        }

        for(Direction direction : Direction.Plane.HORIZONTAL) {
            BlockState blockstate1 = pLevel.getBlockState(pPos.below().relative(direction));
            if (blockstate1.is(Blocks.MAGMA_BLOCK)) {
                return true;
            }
        }

        return false;
    }

    public @NotNull PlantType getPlantType(@NotNull BlockGetter world, @NotNull BlockPos pos) {
        return PlantType.NETHER;
    }

    @Override
    @ParametersAreNonnullByDefault
    @SuppressWarnings("deprecation")
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pMovedByPiston) {
        super.onRemove(pState, pLevel, pPos, pNewState, pMovedByPiston);
    }
}
