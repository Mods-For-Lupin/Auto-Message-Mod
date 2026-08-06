package io.github.jason13official.automessage;

import net.minecraft.server.MinecraftServer;

public class AutoMessageServerFabric {

  public AutoMessageServerFabric(MinecraftServer server) {
    AutoMessageServer.init(server);
  }
}
