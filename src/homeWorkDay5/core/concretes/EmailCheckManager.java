package homeWorkDay5.core.concretes;

import homeWorkDay5.core.abstracts.EmailCheckService;

public class EmailCheckManager implements EmailCheckService{

	@Override
	public void sendMailVerification() {
		System.out.println("Doðrulama maili gönderildi.");
		
	}

}
