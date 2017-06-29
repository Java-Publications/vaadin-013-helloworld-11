package org.rapidpm.vaadin.trainer.api;

/**
 *
 */
@FunctionalInterface
public interface LoginService {
  boolean check(String login, String password);
}
