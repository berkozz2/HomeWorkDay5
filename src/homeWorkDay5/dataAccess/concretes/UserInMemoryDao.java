package homeWorkDay5.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import homeWorkDay5.dataAccess.abstracts.UserDao;
import homeWorkDay5.entities.concretes.User;

public class UserInMemoryDao implements UserDao {
	
	ArrayList<User> users = new ArrayList<>();	
	@Override
	public void add(User user) {
		users.add(user);
		System.out.println(user.getFirstName() + " : Adl� kullan�c� veritaban�na kay�t oldu.");
		
	}

	@Override
	public void delete(User user) {
		System.out.println("Kullan�c� veritaban�ndan silindi. " + user.getFirstName());
		
	}

	@Override
	public void update(User user) {
		System.out.println("Kullan�c� veritaban� bilgileri g�ncellendi." + user.getFirstName());
		
	}

	@Override
	public List<User> getAll() {
		
		return users;
	}


	@Override
	public boolean emailCheck(User user) {
		
		for (User us : users) {
			if(us.geteMail() == user.geteMail()) {
				return false;
			}
			
		}
		return true;
		
	}

	@Override
	public boolean loginCheck(String eMail, String password) {
		
		for (User use : users) {
			if(use.geteMail() == eMail && use.getPassword() == password) {
				return true;
			}
		}
		return false;
	}

	

}
