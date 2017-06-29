package org.rapidpm.vaadin.server;

import org.rapidpm.vaadin.trainer.modules.login.LoginComponent;
import org.rapidpm.vaadin.trainer.modules.login.LoginSimpleImplComponent;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

/**
 *
 */
@Theme("valo")
public class MainUI extends UI {

  @Override
  protected void init(VaadinRequest request) {

    setContent(login());
//    setContent(loginSimpleImplComponent());
    setSizeFull();
  }

  private LoginComponent login() {
    LoginComponent content = new LoginComponent();
    content.postProcess();
    return content;
  }


  private LoginSimpleImplComponent loginSimpleImplComponent() {
    return new LoginSimpleImplComponent();
  }

}
