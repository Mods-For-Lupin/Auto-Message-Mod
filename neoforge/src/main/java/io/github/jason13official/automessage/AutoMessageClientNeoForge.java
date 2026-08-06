package io.github.jason13official.automessage;

import net.minecraft.client.Minecraft;
import net.neoforged.bus.api.IEventBus;

public class AutoMessageClientNeoForge {

  public AutoMessageClientNeoForge(final IEventBus modEventBus) {

    AutoMessageClient.init(Minecraft.getInstance());
  }
}
