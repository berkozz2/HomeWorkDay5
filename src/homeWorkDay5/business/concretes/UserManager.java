package homeWorkDay5.business.concretes;

import homeWorkDay5.business.abstracts.UserService;
import homeWorkDay5.core.abstracts.EmailCheckService;
import homeWorkDay5.core.abstracts.EntranceVerificationService;
import homeWorkDay5.core.abstracts.GoogleCheckService;
import homeWorkDay5.dataAccess.abstracts.UserDao;
import homeWorkDay5.entities.concretes.User;

public class UserManager implements UserService {

	private EmailCheckService emailCheckService;
	private EntranceVerificationService entranceVerificationService;
	private UserDao userDao;
	private GoogleCheckService googleCheckService;
	
	public UserManager(EmailCheckService emailCheckService, EntranceVerificationService entranceVerificationService,
			UserDao userDao, GoogleCheckService googleCheckService) {
		super();
		this.emailCheckService = emailCheckService;
		this.entranceVerificationService = entranceVerificationService;
		this.userDao = userDao;
		this.googleCheckService = googleCheckService;
	}

	@Override
	public void register(User user) {
		if(!entranceVerificationService.isValid(user)) {
			System.out.println("Kullan�c� bilgileriniz hatal� girilmi�tir. Tekrar kontrol ediniz.");
		}else if(!userDao.emailCheck(user)){
			System.out.println("Mail adresi daha �nceden kullan�lm��t�r.");
		}else {
			userDao.add(user);
			emailCheckService.sendMailVerification();
		}
		
	}

	@Override
	public void login(String eMail, String password) {
		if(userDao.loginCheck(eMail, password)) {
			System.out.println("Ba�ar�l� giri� yapt�n�z.");
		}else {
			System.out.println("Kullan�c� ad� veya �ifreniz hatal�.");
		}
		
	}

	@Override
	public void loginWithGoogle() {
		googleCheckService.isGoogleValid("");
		
	}
	
	

}
