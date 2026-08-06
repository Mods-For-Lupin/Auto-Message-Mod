package io.github.jason13official.automessage;

import java.util.function.Consumer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class AutoMessageClientForge {

  public AutoMessageClientForge(final IEventBus modEventBus) {

    modEventBus.addListener((Consumer<FMLClientSetupEvent>) event -> AutoMessageClient.init());
  }
}
