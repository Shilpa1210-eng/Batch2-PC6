package org.cdac.POJO;

import org.cdac.utils.HibernateUtils;
import org.hibernate.Session;

public class UsersDaoImpl implements UsersDao {
	
	@Override
    public boolean authenticateUser(String username, String password) {
        try (Session session = HibernateUtils.getFactory().openSession()) {
            Users user = session.get(Users.class, username);
            return user != null && user.getPassword().equals(password);
        }
    }
}
