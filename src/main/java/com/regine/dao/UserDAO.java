package com.regine.dao;

import java.util.List;

import org.apache.struts.action.ActionForm;
import org.hibernate.Query;
import org.hibernate.Session;

import com.regine.form.UserForm;
import com.regine.hibernate.HibernateUtil;
import com.regine.persistence.User;
  
public class UserDAO  {
    
	public String createUser(String name, Integer age) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            User user = new User();
            user.setName(name);
            user.setAge(age);
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Error creating User :" + e.getMessage());
            session.getTransaction().rollback();
            return "failure" ;
        }
        return "success";
    }
    
    public List<User> getAllUsers() {
    	 Session session = HibernateUtil.getSessionFactory().openSession();
    	 List<User> users = null;
    	 try{
    		 session.beginTransaction();
    		 String hql = "FROM User";
    		 Query query = session.createQuery(hql);
    		 users = query.list();
    	 }catch(Exception e){
    		 System.err.println("Error getting All Users :" + e);
             session.getTransaction().rollback();
    	 }
    	 
    	 return users;
    }
 
    public List<User> getUsers(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<User> users = null;
        try {
            session.beginTransaction();
            users = session
                    .createQuery("from User where name like :name")
                    .setParameter("name", "%" + name + "%").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Error getting Users :" + e);
            session.getTransaction().rollback();
        }
        return users;
    }
    
    public String updateUser(User user){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
        	session.beginTransaction();
        	session.update(user);
        	session.getTransaction().commit();
            
        }catch(Exception e){
        	 System.err.println("Error updating Users :" + e +"Session:: "+session);
        	 System.out.println("Session: "+session);
             session.getTransaction().rollback();
        }
    	return "success";
    }
}