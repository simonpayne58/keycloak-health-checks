package de.tdlabs.keycloak.extensions.healthchecker.model;

import java.util.HashMap;
import java.util.Map;

public class KeycloakHealthStatus implements HealthStatus {

  private final String checkName;
  private final HealthState state;
  private final Map<String, Object> attributes;

  private KeycloakHealthStatus(String checkName, HealthState state) {
    this.checkName = checkName;
    this.state = state;
    this.attributes = new HashMap<>();
  }

  public static KeycloakHealthStatus up(String checkName) {
    return new KeycloakHealthStatus(checkName, HealthState.UP);
  }

  public static KeycloakHealthStatus down(String checkName) {
    return new KeycloakHealthStatus(checkName, HealthState.DOWN);
  }

  public KeycloakHealthStatus withAttribute(String key, Object value) {
    attributes.put(key, value);
    return this;
  }

  public String getName() {
    return checkName;
  }

  public HealthState getState() {
    return state;
  }

  public Map<String, Object> getAttributes() {
    return new HashMap<>(attributes);
  }

  public Map<String, Object> getDetails() {

    Map<String, Object> info = getAttributes();
    info.put("state", state);

    return info;
  }
}
