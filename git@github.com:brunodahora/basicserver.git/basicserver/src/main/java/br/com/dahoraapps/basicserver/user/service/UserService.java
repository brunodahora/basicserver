package br.com.dahoraapps.basicserver.user.service;

import java.util.List;

import br.com.dahoraapps.basicserver.model.User;

/**
 *
 * User Service Interface
 *
 * @author dahoraapps.com
 * @since 01 Jun 2014
 * @version 1.0.0
 *
 */
public interface UserService {
 
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
     * @return List - User list
     */
    public List<User> getUsers();
}
