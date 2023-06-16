package com.saf_saicoop.controller;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class main {
	
   public static void main(String args[]) {
	   long expiresIn = 10; // Ejemplo de valor de expires_in en segundos

       LocalDateTime fechaActual = LocalDateTime.now();
       LocalDateTime fechaExpiracion = fechaActual.plus(expiresIn, ChronoUnit.SECONDS);

       System.out.println("Fecha actual: " + fechaActual);
       System.out.println("Fecha de expiración: " + fechaExpiracion);
       boolean bandera = true;
       while(bandera) {
    	   System.out.println("Dentro del while:"+LocalDateTime.now());
    	   if(LocalDateTime.now().isAfter(fechaExpiracion)) {
    		   System.out.println("Expirado");
    		   bandera = false;
    	   }
       }
}
}
