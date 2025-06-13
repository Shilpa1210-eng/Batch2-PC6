package org.cdac.listeners;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.cdac.utils.HibernateUtils;

@WebListener
public class hibernateListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Initializing Hibernate...");
        HibernateUtils.init();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Shutting down Hibernate...");
        HibernateUtils.shutdown();
    }
}

