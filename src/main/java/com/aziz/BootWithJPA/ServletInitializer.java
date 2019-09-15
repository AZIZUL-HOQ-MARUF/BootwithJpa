/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aziz.BootWithJPA;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 *
 * @author LENOVO
 */
public class ServletInitializer extends SpringBootServletInitializer{

    //This Class and Method is needed when packaging type = war file.
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BootWithJpaApplication.class);
        //To change body of generated methods, choose Tools | Templates.
    }
    
}
