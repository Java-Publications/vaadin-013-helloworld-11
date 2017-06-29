package junit.org.rapidpm.vaadin.trainer.login;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.vaadin.testbench.elements.ButtonElement;
import junit.org.rapidpm.vaadin.helloworld.server.junit5.extensions.pageobject.PageObject;
import junit.org.rapidpm.vaadin.helloworld.server.junit5.vaadin.VaadinTest;

/**
 *
 */

@VaadinTest
public class LoginUITest {


  @DisplayName("Login positive")
  @Test
  void test001(@PageObject LoginUIPageObject pageObject) {
    pageObject.loadPage();

    pageObject.login.get().setValue("admin");
    pageObject.password.get().setValue("admin");

    pageObject.buttonOK.get().click();

    // Assert if new layout is loaded
    // the Caption "Dashboard" is not refactoring safe
//    ButtonElement dashboard = pageObject.btn().id(buttonID().apply(LoginComponent.class, LoginComponent.BUTTON_CAPTION_LOGOUT));
    ButtonElement logOut = pageObject.buttonLogout.get();
    Assert.assertNotNull(logOut);


    logOut.click();
    Assert.assertEquals("", pageObject.login.get().getValue());
    Assert.assertEquals("", pageObject.password.get().getValue());

  }


  @DisplayName("Login negative")
  @Test
  void test002(@PageObject LoginUIPageObject pageObject) {
    pageObject.loadPage();

    pageObject.login.get().setValue("Login");
    pageObject.password.get().setValue("XXX");

    pageObject.buttonOK.get().click();
    //ASSERT : check if Message is visible - Notification

    Assert.assertEquals("", pageObject.login.get().getValue());
    Assert.assertEquals("", pageObject.password.get().getValue());
  }

  @DisplayName("Login cancel")
  @Test
  void test003(@PageObject LoginUIPageObject pageObject) {
    pageObject.loadPage();

    pageObject.login.get().setValue("Login");
    pageObject.password.get().setValue("XXX");

    pageObject.buttonCancel.get().click();
    //ASSERT : check if Message is visible - Notification

    Assert.assertEquals("", pageObject.login.get().getValue());
    Assert.assertEquals("", pageObject.password.get().getValue());
  }
}
