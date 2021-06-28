/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etat;

import java.io.Serializable;

/**
 *
 * @author yuri
 */
public class Authentification implements Serializable {
    
    private String login = "admin";
    private String password = "admin";
    
    public Authentification() {}

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
