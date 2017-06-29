package org.rapidpm.vaadin.trainer.modules.login;

import java.util.Objects;

import org.rapidpm.vaadin.trainer.api.LoginService;

/**
 *
 */
public class LoginServiceImpl implements LoginService {

  @Override
  public boolean check(String login, String password) {
    return ! Objects.isNull(login) && ! Objects.isNull(password)
           && (
               (login.equals("admin") && password.equals("admin"))
               || (login.equals("max") && password.equals("max"))

           );
  }
}
