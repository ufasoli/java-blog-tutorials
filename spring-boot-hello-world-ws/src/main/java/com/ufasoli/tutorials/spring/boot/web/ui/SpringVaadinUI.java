package com.ufasoli.tutorials.spring.boot.web.ui;

import com.google.gwt.thirdparty.guava.common.collect.Lists;
import com.ufasoli.tutorials.spring.boot.model.Book;
import com.ufasoli.tutorials.spring.boot.repositories.BookRepository;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.VaadinUI;

/**
 * Created with IntelliJ IDEA.
 * User: Ulises Fasoli
 * Date: 06.02.14
 * Time: 14:01
 */
@VaadinUI
public class SpringVaadinUI extends UI {

    @Autowired
    protected BookRepository bookRepository;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
            getPage().setTitle("Vaadin UI");

        BeanItemContainer<Book> books = new BeanItemContainer<Book>(Book.class);
        books.addAll(Lists.newArrayList(bookRepository.findAll()));


        Table tbl = new Table();

        tbl.setContainerDataSource(books);

        setContent(tbl);

    }
}
