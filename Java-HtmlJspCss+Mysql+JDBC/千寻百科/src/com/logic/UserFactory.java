package com.logic;

public class UserFactory {
	 public User getUser(String userType){
	      if(userType == null){
	         return null;
	      }		
	      if(userType.equalsIgnoreCase("user")){
	         return new OrdinaryUser();
	      } else if(userType.equalsIgnoreCase("manager")){
	         return new Manager();
	      }
	      return null;
	   }
}
