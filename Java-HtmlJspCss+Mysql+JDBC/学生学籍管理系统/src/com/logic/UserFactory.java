package com.logic;

public class UserFactory {
	 public User getUser(String userType){
	      if(userType == null){
	         return null;
	      }		
	      if(userType.equalsIgnoreCase("student")){
	         return new Student();
	      } else if(userType.equalsIgnoreCase("teacher")){
	         return new Teacher();
	      } else if(userType.equalsIgnoreCase("manager")){
	         return new Manager();
	      }
	      return null;
	   }
}
