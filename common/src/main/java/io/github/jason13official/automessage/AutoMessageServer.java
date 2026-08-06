package io.github.jason13official.automessage;

import io.github.jason13official.automessage.api.common.message.MessageType;
import io.github.jason13official.automessage.impl.common.message.ServerMessageService;
import java.net.URI;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;

public class AutoMessageServer {

  static MinecraftServer SERVER;

  public static void init(MinecraftServer server) {

    SERVER = server;

    ServerMessageService.load();
  }

  public static void onFirstJoinLevel(ServerPlayer player, ServerLevel level) {
    if (level == null || !ServerMessageService.instance.general.enabled) {
      return;
    }

    ServerMessageService.instance.ON_FIRST_JOIN_MESSAGES.forEach(message -> {

      boolean hasTag = player.entityTags().contains(message.identifier + ".firstJoin");

      if (message.repeats || !hasTag) {

        if (message.type == MessageType.CHAT) {
          if (message.link != null && !message.link.isEmpty()) {
            player.sendSystemMessage(Component.literal(message.text.replace("%player%", player.getDisplayName().getString()).replace("%link%", message.link)).withStyle(style -> {
              return style.withClickEvent(new ClickEvent.OpenUrl(URI.create(message.link)));
            }));
          } else {
            player.sendSystemMessage(Component.literal(message.text.replace("%player%", player.getDisplayName().getString())));
          }
        } else {
          player.sendOverlayMessage(Component.literal(message.text.replace("%player%", player.getDisplayName().getString())));
        }

        if (!hasTag) {
          player.addTag(message.identifier + ".firstJoin");
        }
      }
    });
  }

  public static void onJoinLevel(ServerPlayer player, ServerLevel level) {
    if (level == null || !ServerMessageService.instance.general.enabled) {
      return;
    }
    ServerMessageService.instance.ON_JOIN_LEVEL_MESSAGES.forEach(message -> {

      if (message.type == MessageType.CHAT) {
        if (message.link != null && !message.link.isEmpty()) {
          player.sendSystemMessage(Component.literal(message.text.replace("%player%", player.getDisplayName().getString()).replace("%link%", message.link)).withStyle(style -> {
            return style.withClickEvent(new ClickEvent.OpenUrl(URI.create(message.link)));
          }));
        } else {
          player.sendSystemMessage(Component.literal(message.text.replace("%player%", player.getDisplayName().getString())));
        }
      } else {
        player.sendOverlayMessage(Component.literal(message.text.replace("%player%", player.getDisplayName().getString())));
      }
    });
  }

  public static void onDeath(Player player) {
    ServerMessageService.instance.ON_DEATH_MESSAGES.forEach(message -> {

      if (message.type == MessageType.CHAT) {
        if (message.link != null && !message.link.isEmpty()) {
          player.sendSystemMessage(Component.literal(message.text.replace("%player%", player.getDisplayName().getString()).replace("%link%", message.link)).withStyle(style -> {
            return style.withClickEvent(new ClickEvent.OpenUrl(URI.create(message.link)));
          }));
        } else {
          player.sendSystemMessage(Component.literal(message.text.replace("%player%", player.getDisplayName().getString())));
        }
      } else {
        player.sendOverlayMessage(Component.literal(message.text.replace("%player%", player.getDisplayName().getString())));
      }
    });
  }

  public static void onRespawn(ServerPlayer player) {
    ServerMessageService.instance.ON_RESPAWN_MESSAGES.forEach(message -> {

      if (message.type == MessageType.CHAT) {
        if (message.link != null && !message.link.isEmpty()) {
          player.sendSystemMessage(Component.literal(message.text.replace("%player%", player.getDisplayName().getString()).replace("%link%", message.link)).withStyle(style -> {
            return style.withClickEvent(new ClickEvent.OpenUrl(URI.create(message.link)));
          }));
        } else {
          player.sendSystemMessage(Component.literal(message.text.replace("%player%", player.getDisplayName().getString())));
        }
      } else {
        player.sendOverlayMessage(Component.literal(message.text.replace("%player%", player.getDisplayName().getString())));
      }
    });
  }
}
