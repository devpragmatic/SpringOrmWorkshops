package pl.coderslab.dao;

import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;

public class AuthorGenericDao extends GenericDao<Author>{

    public AuthorGenericDao() {
        super(Author.class);
    }
    
}
