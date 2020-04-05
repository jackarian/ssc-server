/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ariannamondo.mag.config.endpoint;

/**
 *
 * @author jackarian
 */
public class ServiceEndpoint {

    public static final String ROOT_END_POINT = "/api";

    /**
     * Autenticazione
     */
    public static final String AUTH      = ROOT_END_POINT + "/auth";
    public static final String LOGIN     = AUTH + "/login";
    public static final String LOGOUT    = AUTH + "/logout";
    public static final String REGISTER   = AUTH + "/register";

    /**
     * Rirsorsa user
     */
    public static final String USER        = ROOT_END_POINT + "/user";
    public static final String USER_GROUPS = USER + "/{user}/groups";
    
    

}
