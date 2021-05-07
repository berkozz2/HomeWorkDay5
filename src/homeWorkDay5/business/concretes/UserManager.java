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
			System.out.println("Kullanýcý bilgileriniz hatalý girilmiþtir. Tekrar kontrol ediniz.");
		}else if(!userDao.emailCheck(user)){
			System.out.println("Mail adresi daha önceden kullanýlmýþtýr.");
		}else {
			userDao.add(user);
			emailCheckService.sendMailVerification();
		}
		
	}

	@Override
	public void login(String eMail, String password) {
		if(userDao.loginCheck(eMail, password)) {
			System.out.println("Baþarýlý giriþ yaptýnýz.");
		}else {
			System.out.println("Kullanýcý adý veya þifreniz hatalý.");
		}
		
	}

	@Override
	public void loginWithGoogle() {
		googleCheckService.isGoogleValid("");
		
	}
	
	

}
