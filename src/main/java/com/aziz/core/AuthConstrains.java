/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aziz.core;

/**
 *
 * @author Maruf
 */
public class AuthConstrains {
    public static final String KEY = "ABCD33ABCD333LMN";
    public static final String HEADER = "TOKEN";
    public static final String USER = "USER";
    public static final String ID = "ID";
    public static final String MAIL = "EMAIL";
    public static final String NON_FILTERING_PATH_PATTERN[] = {"/core/auth/**","/v2/api-docs", "/swagger-resources/configuration/ui", "/configuration/ui", "/swagger-resources", "/swagger-resources/configuration/security", "/configuration/security", "/swagger-ui.html", "/webjars/**"};
    public static final String FILTERING_PATH_PATTERN = "/**";

}
