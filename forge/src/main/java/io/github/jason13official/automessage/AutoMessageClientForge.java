package io.github.jason13official.automessage;

import net.minecraftforge.eventbus.api.IEventBus;

public class AutoMessageClientForge {

  public AutoMessageClientForge(final IEventBus modEventBus) {

    AutoMessageClient.init();
  }
}
