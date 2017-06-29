package org.rapidpm.vaadin.trainer.modules.login;

import static com.vaadin.ui.UI.getCurrent;

import java.util.Objects;

import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 *
 */
public class LoginSimpleImplComponent extends Panel {

  private final TextField login = new TextField();
  private final PasswordField password = new PasswordField();
  private final Button ok = new Button();
  private final Button cancel = new Button();
  private final HorizontalLayout buttons = new HorizontalLayout(ok, cancel);

  private final VerticalLayout layout = new VerticalLayout(login, password, buttons);


  public LoginSimpleImplComponent() {
    setCaption("Login required");
    setContent(layout);
    setSizeFull();

    // init
    login.setId("login");
    login.setCaption("Login");

    password.setId("password");
    password.setCaption("Password"); //TODO i18n

    ok.setId("ok");
    ok.setCaption("Ok");
    ok.addClickListener((Button.ClickListener) event -> {
      boolean isValid = checkLoginData(login.getValue(), password.getValue());
      clearInputFields();
      getCurrent().setContent((isValid) ? mainView() : this);
    });

    cancel.setId("cancel");
    cancel.setCaption("Cancel");
    cancel.addClickListener((Button.ClickListener) event -> clearInputFields());
  }


  private void clearInputFields() {
    login.setValue("");
    password.setValue("");
  }


  private boolean checkLoginData(String login, String password) {
    return ! (Objects.isNull(login) || Objects.isNull(password))
           && (! (login.isEmpty() || password.isEmpty())
               && (login.equals("admin") && password.equals("admin")));
  }

  private Component mainView() {
    Button logOut = new Button("LogOut");
    logOut.addClickListener(e -> {
      getCurrent().getSession().close();
      getCurrent().getPage().setLocation("/");
    });
    return logOut;
  }


}
