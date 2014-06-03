package br.com.dahoraapps.basicserver.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import br.com.dahoraapps.basicserver.model.User;
import br.com.dahoraapps.basicserver.user.service.UserService;

/**
 *
 * User Managed Bean
 *
 * @author dahoraapps.com
 * @since 01 Jun 2014
 * @version 1.0.0
 *
 */
@ManagedBean(name="userMB")
@RequestScoped
public class UserManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "success";
	private static final String ERROR   = "error";

	//Spring User Service is injected...
	@Autowired
	UserService userService;

	List<User> userList;

	private int id;
	private String name;
	private String surname;
	
	public UserManagedBean() {
		WebApplicationContext ctx =  FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		userService = ctx.getBean(UserService.class);
	}

	/**
	 * Add User
	 *
	 * @return String - Response Message
	 */
	public String addUser() {
		try {
			User user = new User();
			user.setId(getId());
			user.setName(getName());
			user.setSurname(getSurname());
			getUserService().addUser(user);
			return SUCCESS;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}   

		return ERROR;
	}

	/**
	 * Reset Fields
	 *
	 */
	public void reset() {
		this.setId(0);
		this.setName("");
		this.setSurname("");
	}

	/**
	 * Get User List
	 *
	 * @return List - User List
	 */
	public List<User> getUserList() {
		userList = new ArrayList<User>();
		userList.addAll(getUserService().getUsers());
		return userList;
	}

	/**
	 * Get User Service
	 *
	 * @return IUserService - User Service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Set User Service
	 *
	 * @param IUserService - User Service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Set User List
	 *
	 * @param List - User List
	 */
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	/**
	 * Get User Id
	 *
	 * @return int - User Id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set User Id
	 *
	 * @param int - User Id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Get User Name
	 *
	 * @return String - User Name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set User Name
	 *
	 * @param String - User Name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get User Surname
	 *
	 * @return String - User Surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * Set User Surname
	 *
	 * @param String - User Surname
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

}
