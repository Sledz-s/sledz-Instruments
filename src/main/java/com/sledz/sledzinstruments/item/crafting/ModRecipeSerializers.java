package com.sledz.sledzinstruments.item.crafting;

import com.sledz.sledzinstruments.SIMain;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModRecipeSerializers {

    public static final DeferredRegister<RecipeSerializer<?>> RECIPES = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, SIMain.MODID);
    public static void register(final IEventBus bus) {
        RECIPES.register(bus);
    }
}
