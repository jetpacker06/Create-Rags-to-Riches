package com.jetpacker06.createragstoriches.register;

import com.jetpacker06.createragstoriches.CreateRTR;
import com.simibubi.create.AllCreativeModeTabs;
import com.simibubi.create.AllFluids;
import com.simibubi.create.AllTags;
import com.simibubi.create.foundation.utility.Color;
import com.simibubi.create.infrastructure.config.AllConfigs;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.builders.FluidBuilder;
import com.tterrag.registrate.util.entry.FluidEntry;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import org.joml.Vector3f;

import java.util.function.Supplier;

import static com.simibubi.create.Create.REGISTRATE;

public class RTRFluids {
    private static Registrate REGISTRATE;

    public static ResourceLocation still = new ResourceLocation("crtr:fluid/molten_netherite_still");
    public static ResourceLocation flow = new ResourceLocation("crtr:fluid/molten_netherite_flow");

    public static FluidEntry<ForgeFlowingFluid.Flowing> MOLTEN_NETHERITE;
    public static ItemEntry<BucketItem> MOLTEN_NETHERITE_BUCKET;

    public static void register(Registrate registrate) {
        REGISTRATE = registrate;

        var f1 = basicFluid("molten_netherite", 0xff42ddf5);
        MOLTEN_NETHERITE_BUCKET = getBucket(f1);
        MOLTEN_NETHERITE = f1.register();

    }
    public static FluidBuilder<ForgeFlowingFluid.Flowing, Registrate> basicFluid(String name) {
        return basicFluid(name, 0xffffffff);
    }

    /**
     * Creates a fluid with a given color. Use the format 0xAA(hex)
     */
    public static FluidBuilder<ForgeFlowingFluid.Flowing, Registrate> basicFluid(String name, int color) {
        return REGISTRATE.fluid(name, still, flow, (p, r1, r2) -> new NoColorFluidAttributes(p, color))
                .properties(p -> p.viscosity(500).density(500).temperature(1500).sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA))
                .fluidProperties(p -> p.tickRate(10).slopeFindDistance(4).explosionResistance(100f))
                .source(ForgeFlowingFluid.Source::new);
    }

    public static ItemEntry<BucketItem> getBucket(FluidBuilder<ForgeFlowingFluid.Flowing, Registrate> fluid) {
        return fluid.bucket().properties(p -> p.stacksTo(1)).register();
    }

    /**
     * (Edited from Create)
     * Removing alpha from tint prevents optifine from forcibly applying biome
     * colors to modded fluids (Makes translucent fluids disappear)
     */
    public static class NoColorFluidAttributes extends AllFluids.TintedFluidType {
        private final int color;
        public NoColorFluidAttributes(Properties properties, int color) {
            super(properties, still, flow);
            this.color = color;
        }

        @Override
        protected int getTintColor(FluidStack stack) {
            return color;
        }

        @Override
        public int getTintColor(FluidState state, BlockAndTintGetter world, BlockPos pos) {
            return color;
        }

    }
}
