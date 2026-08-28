package com.sledz.sledzinstruments.server;

import com.sledz.sledzinstruments.SIMain;
import com.cstav.genshinstrument.event.InstrumentOpenStateChangedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(bus = Bus.FORGE, modid = SIMain.MODID)
public class ServerEvents {

    @SubscribeEvent
    public static void onInstrumentClosedStateClosed(final InstrumentOpenStateChangedEvent event) {
        if (event.player.level().isClientSide)
            return;
    }

}
