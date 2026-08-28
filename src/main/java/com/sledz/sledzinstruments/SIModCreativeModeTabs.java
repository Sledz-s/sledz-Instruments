package com.sledz.sledzinstruments;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;

public class SIModCreativeModeTabs {
    
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SIMain.MODID);
    public static void register(final IEventBus bus) {
        TABS.register(bus);
    }
}
