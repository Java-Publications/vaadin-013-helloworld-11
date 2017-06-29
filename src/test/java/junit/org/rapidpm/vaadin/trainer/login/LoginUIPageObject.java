package junit.org.rapidpm.vaadin.trainer.login;

import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;
import org.rapidpm.vaadin.trainer.modules.login.LoginComponent;
import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.PasswordFieldElement;
import com.vaadin.testbench.elements.TextFieldElement;
import junit.org.rapidpm.vaadin.helloworld.server.junit5.vaadin.AbstractVaadinPageObject;

/**
 *
 */
public class LoginUIPageObject extends AbstractVaadinPageObject {

  public LoginUIPageObject(WebDriver webDriver) {
    super(webDriver);
  }

  public Supplier<ButtonElement> buttonOK = () -> btn().id(LoginComponent.ID_BUTTON_OK);
  public Supplier<ButtonElement> buttonCancel = () -> btn().id(LoginComponent.ID_BUTTON_CANCEL);
  public Supplier<ButtonElement> buttonLogout = () -> btn().id(LoginComponent.ID_BUTTON_LOGOUT);

  public Supplier<TextFieldElement> login = () -> textField().id(LoginComponent.ID_TEXTFIELD_LOGIN);
  public Supplier<PasswordFieldElement> password = () -> passwordField().id(LoginComponent.ID_PASSWORDFIELD_PASSWORD);

}
