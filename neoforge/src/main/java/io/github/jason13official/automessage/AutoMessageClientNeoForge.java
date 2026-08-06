package io.github.jason13official.automessage;

import java.util.function.Consumer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

public class AutoMessageClientNeoForge {

  public AutoMessageClientNeoForge(final IEventBus modEventBus) {

    modEventBus.addListener((Consumer<FMLClientSetupEvent>) event -> AutoMessageClient.init());
  }
}
