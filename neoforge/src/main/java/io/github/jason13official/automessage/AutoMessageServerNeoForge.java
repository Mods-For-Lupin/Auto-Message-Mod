package io.github.jason13official.automessage;

import net.neoforged.neoforge.event.server.ServerAboutToStartEvent;

public class AutoMessageServerNeoForge {

  public AutoMessageServerNeoForge(final ServerAboutToStartEvent serverAboutToStartEvent) {

    AutoMessageServer.init(serverAboutToStartEvent.getServer());
  }
}
