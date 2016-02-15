package org.javarush.test.service;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.javarush.test.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Service for processing Users
 */

@Service("userService")
@Transactional
public class UserService {

    protected static Logger logger = Logger.getLogger(UserService.class.getSimpleName());
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    /**
     * Retrieves all persons
     *
     * @return a list of persons
     */
    public List<User> getAll() {
        logger.debug("Retrieving all persons");

        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Create a Hibernate query (HQL)
        Query query = session.createQuery("FROM  User");
        // Retrieve all
        return query.list();
    }

    /**
     * Retrieves a single person
     */
    public User get(Integer id) {
        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Retrieve existing user first
        User user = (User) session.get(User.class, id);

        return user;
    }

    /**
     * Adds a new user
     */
    public void add(User user) {
        logger.debug("Adding new user");
        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();
        // Save
        session.save(user);
    }

    /**
     * Deletes an existing user
     *
     * @param id the id of the existing person
     */
    public void delete(Integer id) {
        logger.debug("Deleting existing user");
        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();
        // Retrieve existing user first
        User user = (User) session.get(User.class, id);
        // Delete
        session.delete(user);
    }

    /**
     * Edits an existing user
     */
    public void edit(User user) {
        logger.debug("Editing existing user" + user.getId());
        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();
        // Retrieve existing user via id
        User existingUser = (User) session.get(User.class, user.getId());
        // Assign updated values to this user
        existingUser.setName(user.getName());
        existingUser.setAge(user.getAge());
        existingUser.setAdmin(user.getAdmin());
        // Save for updates
        session.save(existingUser);
    }

    /**
     * Retrieves all persons byName
     *
     * @return a list of persons
     */
    public List<User> getAllByName(String name) {
        logger.debug("Retrieving users by name");
        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();
        // Create a Hibernate query (SQL)
        Query query = session
                .createSQLQuery(String.format("SELECT * FROM USER WHERE NAME = '%s'", name))
                .addEntity(User.class);
        return query.list();
    }

    /**
     * Retrieves all persons byName
     *
     * @return a list of persons by SQL query
     */
    public List<User> getAllBySQL(String sql) {
        logger.debug("Retrieving users by SQL");
        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();
        // Create a Hibernate query (SQL)
        sql = sql.trim();
        if (!sql.split(" ")[0].equalsIgnoreCase("SELECT")) throw new IllegalArgumentException(sql);
        Query query = session.createSQLQuery(sql).addEntity(User.class);
        return query.list();
    }
}