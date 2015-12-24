package com.mik.gwt.shared.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by mikitjuk on 16.12.15.
 */
@Entity
@Table(name = "users")
public class Users implements Serializable{

    private static final long serialVersionUID = 5072296376487582068L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    private Integer id;

    @Column(name = "login", nullable = false, insertable = true, updatable = true, length = 32)
    private String login;

    @Column(name = "password", nullable = false, insertable = true, updatable = true, length = 250)
    private String password;

    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 126)
    private String name;

    public Users() {
    }

    public Users(String login, String password, String name) {
        this.login = login;
        this.password = password;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (id != null ? !id.equals(users.id) : users.id != null) return false;
        if (login != null ? !login.equals(users.login) : users.login != null) return false;
        if (name != null ? !name.equals(users.name) : users.name != null) return false;
        if (password != null ? !password.equals(users.password) : users.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
