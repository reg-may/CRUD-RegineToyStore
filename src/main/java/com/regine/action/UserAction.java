package com.regine.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.chain.contexts.ActionContext;
import org.apache.struts.chain.contexts.ServletActionContext;

import com.regine.dao.UserDAO;
import com.regine.form.UserForm;
import com.regine.persistence.User;


public class UserAction extends DispatchAction {
	
	List<User> users;
	List<User> usersearch;
	UserForm userForm;
	
	public UserAction(){
		userForm = new UserForm();
		users = new UserDAO().getAllUsers();
		userForm.setUsers(users);
		System.out.println("All: "+userForm.getUsers());
	}
	
    public ActionForward goToSearchPage(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        //request.setAttribute("users", users);
        return mapping.findForward("search");
    }
    
    public ActionForward goToAddPage(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        return mapping.findForward("add");
    }
    
    public ActionForward searchUsers(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        UserForm userForm = (UserForm) form;
        usersearch = new UserDAO().getUsers(userForm.getName());
        userForm.setUsersearch(usersearch);
        System.out.println("Search: "+userForm.getUsersearch().toString());
        request.setAttribute("users", userForm.getUsersearch());
        return mapping.findForward("search");
    }
    
    public ActionForward addUser(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        UserForm userForm = (UserForm) form;
        String result = new UserDAO().createUser(userForm.getName(), userForm.getAge());
        if(result.equals("success")){
            request.setAttribute("success", true);
            userForm.reset();
        }else{
            request.setAttribute("failure", true);
        }
        return mapping.findForward("add");
    }
    public ActionForward updateUser(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response){
    	
    		   
    	      UserForm userF = (UserForm) form;
    	    Integer id = (Integer) request.getAttribute("userid");
    	    System.out.println("id request: "+id);
    	      System.out.println("ID: "+userF.getId());
    	       User user = userForm.getUser(1);
    	       user.setAge(7);
    	       user.setName("Mochi");
    	       System.out.println("Age: "+user.getAge());
    	       userForm.setUser(1, user);
    	       String result = new UserDAO().updateUser(user);
    	       
				return mapping.findForward("search");
    	
    }
}