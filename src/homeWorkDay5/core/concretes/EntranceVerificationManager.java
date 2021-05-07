package homeWorkDay5.core.concretes;

import java.util.regex.Pattern;

import homeWorkDay5.core.abstracts.EntranceVerificationService;
import homeWorkDay5.entities.concretes.User;

public class EntranceVerificationManager implements EntranceVerificationService {

	public boolean isValidEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}

	public boolean isValidPassword(String password) {
		if (password == null || password.length() < 6) {
			return false;
		}

		return true;
	}

	public boolean isValidString(String name) {

		if (name == null || name.length() < 2) {
			return false;
		}
		for (char c : name.toCharArray()) {
			if (Character.isDigit(c)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean isValid(User user) {
		if(!isValidEmail(user.geteMail())) {
			System.out.println("Email kurallar�na uygun giriniz.");
			return false;
		}
		if(!isValidPassword(user.getPassword())) {
			System.out.println("Parolan�z 6 karakter veya uzun olmal�d�r.");
		}
		if(!isValidString(user.getFirstName())) {
			System.out.println("�sminiz en az 2 karakterden olu�mal�d�r.");
		}
		if(!isValidString(user.getLastName())) {
			System.out.println("Soyisminiz en az 2 karakterden olu�mal�d�r.");
		}

		return true;
	}

}
