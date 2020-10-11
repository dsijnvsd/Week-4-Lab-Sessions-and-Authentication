/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.Serializable;

/**
 *
 * @author 809968
 */
public class User implements Serializable{
    private String username;
    private String password;
    
    public User(){
    }
    
    public User(String name, String password){
        this.username = name;
        this.password = password;
        
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
}
