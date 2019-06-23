package pl.coderslab.dao;

import pl.coderslab.entity.Book;

public class BookGenericDao extends GenericDao<Book>{

    public BookGenericDao() {
        super(Book.class);
    }

}
