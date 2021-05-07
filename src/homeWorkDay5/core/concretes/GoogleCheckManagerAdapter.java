package homeWorkDay5.core.concretes;

import homeWorkDay5.core.abstracts.GoogleCheckService;
import homeWorkDay5.googleValidation.GoogleValidation;

public class GoogleCheckManagerAdapter implements GoogleCheckService{

	@Override
	public boolean isGoogleValid(String message) {
		
		GoogleValidation googleValidation = new GoogleValidation();
		googleValidation.googleValid(message);
		
		return true;
	}

}
