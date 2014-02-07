package com.ufasoli.tutorials.spring.boot.web.ui;

import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.VaadinUI;
import org.vaadin.spring.navigator.SpringViewProvider;

/**
 * Created with IntelliJ IDEA.
 * User: Ulises Fasoli
 * Date: 06.02.14
 * Time: 14:01
 */
@VaadinUI
public class SpringVaadinUI extends UI {


    @Autowired
    protected SpringViewProvider viewProvider;

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        getPage().setTitle("Spring boot Vaadin UI");

        Navigator navigator = new Navigator(this, this);
        navigator.addProvider(viewProvider);

        setNavigator(navigator);
    }
}
