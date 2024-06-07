package com.ohgiraffers.listener.section01.context;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.ServletRequestAttributeEvent;
import jakarta.servlet.ServletRequestAttributeListener;
import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionActivationListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class ContextListenerTest implements ServletContextListener, ServletContextAttributeListener, HttpSessionListener, HttpSessionAttributeListener, HttpSessionActivationListener, HttpSessionBindingListener, ServletRequestListener, ServletRequestAttributeListener {

   
    public ContextListenerTest() {
    	
    	System.out.println("context listener 인스턴스 생성");
    }


    public void attributeReplaced(ServletContextAttributeEvent scae)  { 
       System.out.println("context attribute 수정");
    }

    public void attributeRemoved(ServletContextAttributeEvent scae)  { 
    	System.out.println("context attribute 삭제");
    }


    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("context init!!");
    }


    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("context destroy !!");
    }


    public void attributeAdded(ServletContextAttributeEvent scae)  { 
    	System.out.println("context attribute added");
    }

	
}
