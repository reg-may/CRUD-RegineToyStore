package com.regine.form;

import java.util.List;

import org.apache.struts.action.ActionForm;

import com.regine.persistence.User;

public class UserForm extends ActionForm {
    private static final long serialVersionUID = 1L;
 
    private String dispatch;
    private String name;
    private Integer age;
    private Integer id; 
    private List<User> users;
    private List<User> usersearch;

    
    public void reset() {
        this.name = null;
        this.age = null;
        
    }
 
    public String getDispatch() {
        return dispatch;
    }
 
    public void setDispatch(String dispatch) {
        this.dispatch = dispatch;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public Integer getAge() {
        return age;
    }
 
    public void setAge(Integer age) {
        this.age = age;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUpdatedUser(int index) {
		return this.users.get(index);
    }
	

	public List<User> getUsers(){
		return this.users;
	}
	
	public void setUsers(Integer id, User user){
		this.users.add(id, user);;
	}
	
	public void setUsers(List<User> users){
		this.users = users;
	}

	public User getUser(Integer id) {
		return this.users.get(id);
	}
	public void setUser(Integer id, User user){
		this.users.add(id, user);
	}

	public List<User> getUsersearch() {
		return usersearch;
	}

	public void setUsersearch(List<User> usersearch) {
		this.usersearch = usersearch;
	}

}