package org.example;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class ContainerServiceTest{

    @Test
    public void getObject(){
        BookRepository bookRepository = ContainerService.getObject(BookRepository.class);
        Assert.assertNotNull(bookRepository);
    }

    @Test
    public void getObject_BookService(){
        BookService bookService = ContainerService.getObject(BookService.class);
        Assert.assertNotNull(bookService);
    }

    @Test
    public void getObject_service() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        BookRepository bookRepository = Service.getObject(BookRepository.class);
        Assert.assertNotNull(bookRepository);

    }

}