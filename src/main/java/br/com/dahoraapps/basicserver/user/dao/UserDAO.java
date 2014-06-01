package br.com.dahoraapps.basicserver.user.dao;

import java.util.List;

import br.com.dahoraapps.basicserver.model.User;

 
/**
 *
 * User DAO Interface
 *
 \* @author dahoraapps.com
 * @since 25 Mar 2012
 * @version 1.0.0
 *
 */
public interface UserDAO {
 
    /**
     * Add User
     *
     * @param  User user
     */
    public void addUser(User user);
 
    /**
     * Update User
     *
     * @param  User user
     */
    public void updateUser(User user);
 
    /**
     * Delete User
     *
     * @param  User user
     */
    public void deleteUser(User user);
 
    /**
     * Get User
     *
     * @param  int User Id
     */
    public User getUserById(int id);
 
    /**
     * Get User List
     *
     */
    public List<User> getUsers();
}
