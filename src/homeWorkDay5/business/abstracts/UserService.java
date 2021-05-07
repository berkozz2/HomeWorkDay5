package homeWorkDay5.business.abstracts;

import homeWorkDay5.entities.concretes.User;

public interface UserService {
	void register(User user);
	void login(String eMail, String password);
	void loginWithGoogle();
}
