package com.sledz.sledzinstruments.item;

import com.sledz.sledzinstruments.SIMain;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class SIModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SIMain.MODID);

    public static final RegistryObject<CreativeModeTab> SLEDZ_INSTRUMENTS_TAB = CREATIVE_MODE_TABS.register("sledz_instruments_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("creativetab.sledz_instruments_tab"))
                    .icon(() -> new ItemStack(ModItems.HARMONICA.get()))
                    .build()
    );

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}