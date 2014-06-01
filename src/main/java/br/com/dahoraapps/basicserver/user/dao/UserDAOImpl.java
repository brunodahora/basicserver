package br.com.dahoraapps.basicserver.user.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import br.com.dahoraapps.basicserver.model.User;

/**
 *
 * User DAO
 *
 * @author dahoraapps.com
 * @since 01 Jun 2014
 * @version 1.0.0
 *
 */

public class UserDAOImpl implements UserDAO {

	private SessionFactory sessionFactory;

	/**
	 * Get Hibernate Session Factory
	 *
	 * @return SessionFactory - Hibernate Session Factory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * Set Hibernate Session Factory
	 *
	 * @param SessionFactory - Hibernate Session Factory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * Add User
	 *
	 * @param  User user
	 */
	@Override
	public void addUser(User user) {
		getSessionFactory().getCurrentSession().save(user);
	}

	/**
	 * Delete User
	 *
	 * @param  User user
	 */
	@Override
	public void deleteUser(User user) {
		getSessionFactory().getCurrentSession().delete(user);
	}

	/**
	 * Update User
	 *
	 * @param  User user
	 */
	@Override
	public void updateUser(User user) {
		getSessionFactory().getCurrentSession().update(user);
	}

	/**
	 * Get User
	 *
	 * @param  int User Id
	 * @return User
	 */
	@SuppressWarnings("unchecked")
	@Override
	public User getUserById(int id) {
		List<User> list = getSessionFactory().getCurrentSession()
				.createQuery("from User where id=?")
				.setParameter(0, id).list();
		return list.get(0);
	}

	/**
	 * Get User List
	 *
	 * @return List - User list
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsers() {
		List<User> list = getSessionFactory().getCurrentSession().createQuery("from User").list();
		return list;
	}

}
