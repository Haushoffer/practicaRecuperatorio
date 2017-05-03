package edu.ucbcba.taller.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by coreI7 on 30/04/2017.
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Terminal> terminals;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private User parentId;

    @OneToMany(mappedBy = "parentId", cascade = CascadeType.ALL)
    private  Set<User> user;


    public Set<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "company_user", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "company_id"))
    private Set<Company> companies;

  /*  public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }*/

    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }

    public User getParentId() {
        return parentId;
    }

    public void setParentId(User parentId) {
        this.parentId = parentId;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Terminal> getTerminals() {
        return terminals;
    }

    public void setTerminals(Set<Terminal> terminals) {
        this.terminals = terminals;
    }



}
