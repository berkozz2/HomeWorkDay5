package homeWorkDay5.core.abstracts;

import homeWorkDay5.entities.concretes.User;

public interface EntranceVerificationService {
	
	boolean isValid (User user);
}
