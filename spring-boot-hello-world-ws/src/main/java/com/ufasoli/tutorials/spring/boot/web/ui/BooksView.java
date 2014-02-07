package com.ufasoli.tutorials.spring.boot.web.ui;

import com.google.gwt.thirdparty.guava.common.collect.Lists;
import com.ufasoli.tutorials.spring.boot.model.Book;
import com.ufasoli.tutorials.spring.boot.repositories.BookRepository;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.UIScope;
import org.vaadin.spring.VaadinComponent;
import org.vaadin.spring.navigator.VaadinView;

import javax.annotation.PostConstruct;

/**
 * Created with IntelliJ IDEA.
 * User: Ulises Fasoli
 * Date: 06.02.14
 * Time: 15:50
 */
@VaadinView(name = "", ui = SpringVaadinUI.class)
@UIScope
@VaadinComponent
public class BooksView extends VerticalLayout implements View {

    private Navigator navigator;

    @Autowired
    protected BookRepository bookRepository;


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        navigator = event.getNavigator();
    }


    @PostConstruct
    public void init(){


        MenuBar menuBar = new MenuBar();
        menuBar.addItem("Home", new MenuBar.Command() {
            @Override
            public void menuSelected(MenuBar.MenuItem selectedItem) {
                 navigator.navigateTo("");
            }
        }) ;

        BeanItemContainer<Book> books = new BeanItemContainer<Book>(Book.class);
        books.addAll(Lists.newArrayList(bookRepository.findAll()));


        Table booksTable = new Table();
        booksTable.setContainerDataSource(books);
        booksTable.setVisibleColumns(new Object[]{"isbn", "title", "author", "description"});

        VerticalLayout vl = new VerticalLayout();
        vl.setWidth("500px");
        vl.addComponent(menuBar);
        vl.addComponent(booksTable);

        addComponent(vl);
    }
}
