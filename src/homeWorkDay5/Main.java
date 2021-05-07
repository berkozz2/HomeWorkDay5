package homeWorkDay5;

import homeWorkDay5.business.abstracts.UserService;
import homeWorkDay5.business.concretes.UserManager;
import homeWorkDay5.core.concretes.EmailCheckManager;
import homeWorkDay5.core.concretes.EntranceVerificationManager;
import homeWorkDay5.core.concretes.GoogleCheckManagerAdapter;
import homeWorkDay5.dataAccess.concretes.UserInMemoryDao;
import homeWorkDay5.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		
		User user1 = new User();
		user1.setId(1);
		user1.setFirstName("Berk");
		user1.setLastName("Ozmenekse");
		user1.seteMail("ozkadmak@gmail.com");
		user1.setPassword("1234567");
		
		User user2 = new User();
		user2.setId(1);
		user2.setFirstName("Burak");
		user2.setLastName("Ozmenekse");
		user2.seteMail("ozkadmak@gmail.com");
		user2.setPassword("12345");
		
		UserService userService = new UserManager(new EmailCheckManager(), new EntranceVerificationManager(), new UserInMemoryDao(), new GoogleCheckManagerAdapter());
		
		userService.login("ozkadmak@gmail.com", "12344");
		System.out.println("---------------------");
		
		userService.register(user1);
		System.out.println("----------------------");
		
		userService.login("ozkadmak@gmail.com", "1234567");
		System.out.println("------------------------");
		
		userService.loginWithGoogle();
		
		

	}

}
