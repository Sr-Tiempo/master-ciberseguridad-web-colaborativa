package controllers;


import helpers.HashUtils;
import models.User;
import play.mvc.Controller;

public class PublicContentBase extends Controller {

    
    public static void register(){
        render();
    }

    public static void processRegister(String username, String password, String passwordCheck, String type){
		if(esValido(username)){
			User u = new User(username, HashUtils.getMd5(password), type, -1);
			u.save();
			registerComplete();
		}else{
			renderTemplate("errors/error_username.html");
		}
    }
	
	public static boolean esValido(String username){
		return username != null && username.matches("^[A-Za-z]{3,8}$");
	}

    public static void registerComplete(){
        render();
    }

}
