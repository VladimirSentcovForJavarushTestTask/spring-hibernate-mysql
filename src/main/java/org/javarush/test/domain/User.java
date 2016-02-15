package org.javarush.test.domain;

import org.apache.log4j.Logger;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * For a complete reference see
 * <a href="http://docs.jboss.org/hibernate/stable/annotations/reference/en/html_single/">
 * Hibernate Annotations Communit Documentations</a>
 */

@Entity
@Table(name = "USER")
public class User implements Serializable, Comparable<User> {
    protected static Logger logger = Logger.getLogger(User.class.getSimpleName());
    @Id
    @GeneratedValue
    @Column(name = "ID", length = 8, updatable = false)
    private Integer id;

    @Column(name = "NAME", length = 25)
    private String name;

    @Column(name = "AGE")
    private Integer age = 0;

    @Column(name = "IS_ADMIN")
    private Boolean isAdmin = false;

    @Column(name = "CREATED_DATE", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date = new Date();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String firstName) {
        this.name = firstName;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + name + '\'' +
                ", isAdmin=" + isAdmin +
                ", date=" + date +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(User o) {

        return getId() - o.getId();
    }

}
