package com.codecool.expert;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Fact {
  String id;
  String description;
  Map<String, Boolean> valueId;

  public Fact(String id, String description) {
    this.id = id;
    this.description = description;
    this.valueId = new HashMap<>();
  }

  public Set<String> getIdSet() {
    return this.valueId.keySet();
  }

  public void setFactValueById(String id, boolean value) {
    this.valueId.set(id, value);
  }

  public boolean getValueById(String id) {
    return this.valueId.get(id);
  }

  public String getDescription() {
    return this.description;
  }
}
