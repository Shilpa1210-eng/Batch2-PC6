package Day6Hibernate.Hibernate1;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        Configuration hibernateConfiguration = new Configuration();
//        hibernateConfiguration.configure("hibernate.cfg.xml");
//        
//        SessionFactory hibernateFactory = hibernateConfiguration.buildSessionFactory();
//        
//        Session hibernate = hibernateFactory.openSession();
//        
//        hibernate.beginTransaction();
//        
//        Users obj = new Users("test", "test", "test", "1231231234");
//        
//        hibernate.persist(obj);
//        
//        hibernate.getTransaction().commit();
//        
//        System.out.println("Entered!");
    	
    	Configuration hibernateConfiguration = null;
    	SessionFactory hibernateFactory = null;
    	Session hibernateSession = null;
    	
    	try(Scanner sc = new Scanner(System.in)) {
    		
    		hibernateConfiguration = new Configuration();
    		hibernateConfiguration.configure("hibernate.cfg.xml");
    		hibernateFactory = hibernateConfiguration.buildSessionFactory();
    		hibernateSession = hibernateFactory.openSession();
    		int choice;
    		do {
    			System.out.println("----------------------Menu----------------------\n"
    					+ "1) Insert User\n"
    					+ "2) Update User\n"
    					+ "3) Remove User\n"
    					+ "4) Find User"
    					+ "0) Exit!");
    			
    			choice = sc.nextInt();
    			
    			switch(choice) {
    			case 1: {
    				System.out.print("Enter username: ");
    				String username = sc.next();
    				System.out.print("Enter password: ");
    				String password = sc.next();
    				System.out.print("Enter name: ");
    				String name = sc.next();
    				System.out.print("Enter phone: ");
    				String phone = sc.next();
    				Users userObj = new Users(username, password, name, phone);
    				hibernateSession.beginTransaction();
    				hibernateSession.persist(userObj);
    				hibernateSession.getTransaction().commit();
    				System.out.println("User Entered!");
    			}; break;
    			case 2: {
    				System.out.print("Enter username: ");
    				String username = sc.next();
    				System.out.print("Enter updated password: ");
    				String password = sc.next();
    				hibernateSession.beginTransaction();
    				Users userObj = hibernateSession.get(Users.class, username);
    				if(userObj != null) {
    					userObj.setPassword(password);
    					System.out.println("Updated!");
    				} else {
    					System.out.println("User not found!");
    				}
    				hibernateSession.getTransaction().commit();
    				System.out.println("User Updated!");
    			}; break;
    			case 3: {
    				hibernateSession.beginTransaction();
    				System.out.print("Enter username: ");
    				String username = sc.next();
    				Users userObj = hibernateSession.get(Users.class, username);
    				if(userObj != null) {
    					hibernateSession.remove(userObj);
    				} else {
    					System.out.println("User not found!");
    				}
    				hibernateSession.getTransaction().commit();
    				System.out.println("User Deleted!");
    			}; break;
    			case 4: {
    				System.out.print("Enter username: ");
    				String username = sc.next();
    				hibernateSession.beginTransaction();
    				Users userObj = hibernateSession.get(Users.class, username);
    				if(userObj != null) {
    					System.out.println(userObj);
    				} else {
    					System.out.println("User not found!");
    				}
    				hibernateSession.getTransaction().commit();
    				System.out.println("User Found!");
    			}; break;
    			case 0: System.out.println("Exit!"); break;
    			default: System.out.println("Enter valid input!");
    			}
    		} while (choice != 0);
    	} finally {
    		if(hibernateSession != null) {
    			hibernateSession.close();
    		}
    		if(hibernateFactory != null) {
    			hibernateFactory.close();
    		}
    	}
    	
    }
}
