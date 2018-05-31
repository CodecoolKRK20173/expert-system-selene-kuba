package com.codecool.expert;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Fact {
  private final String description;
  private final Map<String, Boolean> valueId;

  public Fact(String id, String description) {
    String id1 = id;
    this.description = description;
    this.valueId = new HashMap<>();
  }

  public Set<String> getIdSet() {
    return this.valueId.keySet();
  }

  public Collection<Boolean> getValueSet() {
    return this.valueId.values();
  }

  public void setFactValueById(String id, boolean value) {
    valueId.put(id, value);
  }

  public boolean getValueById(String id) {
    return this.valueId.get(id);
  }

  public String getDescription() {
    return this.description;
  }
}
