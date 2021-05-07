package homeWorkDay5.dataAccess.abstracts;

import java.util.List;

import homeWorkDay5.entities.concretes.User;

public interface UserDao {
	void add(User user);
	void delete(User user);
	void update(User user);
	boolean emailCheck(User user);
	boolean loginCheck(String eMail, String password);
	
	List<User> getAll();
	
}
