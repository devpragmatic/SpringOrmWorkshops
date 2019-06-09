package pl.coderslab.entity;

import javax.persistence.*;

@Entity
public class Phone {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Person user;

    @ManyToOne
    private Person owner;

    private String number;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getUser() {
        return user;
    }

    public void setUser(Person user) {
        this.user = user;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}