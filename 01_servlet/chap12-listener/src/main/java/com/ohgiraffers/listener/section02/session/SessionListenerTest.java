package com.ohgiraffers.listener.section02.session;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class SessionListenerTest implements HttpSessionListener, HttpSessionAttributeListener {


    public SessionListenerTest() {
    	
    	System.out.println("1 session listener 인스턴스 생성");
      
    }

    public void attributeReplaced(HttpSessionBindingEvent se)  { 
        System.out.println("2 session attribute 수정");
        System.out.println("2 session에서 수정된 attr : " +  se.getName() + ", " + se.getValue());
    }


    public void sessionCreated(HttpSessionEvent se)  { 
        System.out.println("3 session 생성 !!");
        System.out.println("3 생성된 sessio : " + se.getSession().getId());
    }


    public void sessionDestroyed(HttpSessionEvent se)  { 
         System.out.println("4 session 소멸 !!");
    }

    public void attributeRemoved(HttpSessionBindingEvent se)  { 
         System.out.println("5 session attribute 삭제");
    }


    public void attributeAdded(HttpSessionBindingEvent se)  { 
    	System.out.println("6 sessio attribute 추가");
    }
	
}
