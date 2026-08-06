package io.github.jason13official.automessage.api.common.message;

import com.google.gson.annotations.SerializedName;

public enum MessageSchedule {

  @SerializedName("on_first_join") ON_FIRST_JOIN,
  @SerializedName("on_join_level") ON_JOIN_LEVEL,
  @SerializedName("on_death") ON_DEATH,
  @SerializedName("on_respawn") ON_RESPAWN,
}
