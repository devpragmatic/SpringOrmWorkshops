package pl.coderslab.dao;

import pl.coderslab.entity.Publisher;

public class PublisherGenericDao extends GenericDao<Publisher> {
    public PublisherGenericDao() {
        super(Publisher.class);
    }
}
