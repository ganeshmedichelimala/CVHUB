import java.util.*;

class User {
	private String email;
	private String username;
	private String password;

	User(String email, String username, String password) {
		this.email = email;
		this.username = username;
		this.password = password;
	}

	void setEmail(String email) {
		this.email = email;
	}

	void setUserName(String username) {
		this.username = username;
	}

	void setPassword(String password) {
		this.password = password;
	}

	String getEmail() {
		return email;
	}

	String getUserName() {
		return username;
	}

	String getPassword() {
		return password;
	}
}

class CvHub {
	static HashMap<String, User> users = new HashMap<>();
	static ArrayList<String> usernames = new ArrayList<>();
	static HashSet<String> emails = new HashSet<>();
	static User currentUser = null;
	static Scanner in = new Scanner(System.in);

	public static boolean containNumbers(String username) {
		boolean found = false;
		for (int i = 0; i < username.length(); i++) {
			char c = username.charAt(i);
			if (c >= '0' && c <= '9') {
				found = true;
				break;
			}
		}
		return found;

	}

	public static boolean containSpecialSymbols(String username) {
		String specialCharacters = "!@#$%^&*()_+{}[]|\\:;\"'<>,.?/~`-=";
		boolean found = false;
		for (int i = 0; i < username.length(); i++) {
			for (int j = 0; j < specialCharacters.length(); j++) {
				if (username.charAt(i) == specialCharacters.charAt(j)) {
					found = true;
					break;
				}
			}
		}
		return found;

	}

	public static boolean validUsername(String username) {
		if (usernames.contains(username)) {
			System.out.println("\t\t\t\t\t\t\t Username already taken. Try another one!");
			return false;
		}
		if (username.length() < 5) {
			System.out.print("\t\t\t\t\t\t\t username should be of minimum 5 character");
			System.out.println();
			return false;
		}

		if (containSpecialSymbols(username)) {
			System.out.println("\t\t\t\t\t\t\t  Username could not contain special characters");
			return false;
		}
		if (!(containNumbers(username))) {
			System.out.println("\t\t\t\t\t\t\t Username must contain atleast 1 numeric");
			return false;
		}

		return true;
	}

	public static boolean validPassword(String password) {

		if (password.length() < 8) {
			System.out.println("\t\t\t\t\t\t\t password should be of minimum 8 character");
			return false;
		}
		if (!containSpecialSymbols(password)) {
			System.out.println("\t\t\t\t\t\t\t  password should contain atleast 1 special characters");
			return false;
		}
		if (!containNumbers(password)) {
			System.out.println("\t\t\t\t\t\t\t      password should contain atleast 1 Number");
			return false;
		}
		return true;
	}

	public static boolean validEmail(String email) {
		if (emails.contains(email)) {
			System.out.println("\t\t\t\t\t\t\t Email already registered. Try logging in!");
			return false;
		}
		if (email == null || email.isEmpty()) {
			System.out.println("\t\t\t\t\t\t\t\t\t\t email cannot be empty! ");

			return false; // Check if empty or null
		}
		if (!email.endsWith("@gmail.com")) {
			System.out.println("\t\t\t\t\t\t\t      email Should end with @gmail.com");
			return false;
		}
		int atIndex = email.indexOf('@');
		if (atIndex < 1) {
			System.out.println("\t\t\t\t\t\t\t      '@' Should not be at the start");
			return false;
		}
		if (email.contains(" ")) {
			System.out.println("\t\t\t\t\t\t\t      No spaces Allowed in email");
			return false;
		}
		return true;
	}

	public static void signup() {
		String email = "";
		boolean emailb = true;
		while (emailb) {
			System.out.println("\t\t\t\t\t\t\t\t Enter a valid email : ");
			email = in.next();
			if (validEmail(email)) {
				emailb = false;
			} else {
				System.out.println("\n\t\t\t\t\t\t\t\t\t Please try Again....\n");
			}
		}

		boolean usernameb = true;
		String username = "";
		while (usernameb) {
			System.out.println("\t\t\t\t\t\t\t\t Enter the username :(min 5 characters) ");
			username = in.next();
			if (validUsername(username)) {
				usernames.add(username);
				usernameb = false;
			} else {
				System.out.println();
				System.out.println("\t\t\t\t\t\t\t\t\t Please try Again....");
				System.out.println();
			}
		}
		boolean passwordb = true;
		String password = "";
		while (passwordb) {
			System.out.println("\t\t\t\t\t\t\t\t Enter the password :(min 8 characters) ");
			password = in.next();
			if (!validPassword(password)) {
				System.out.println();
				System.out.println("\t\t\t\t\t\t\t\t\t Please try Again....");
				System.out.println();

			} else {
				passwordb = false;
			}

		}
		users.put(email, new User(email, username, password));
	}

	public static void signin() {

	}

	public static void main(String[] args) {
		// Monitor
		System.out.println("\t\t\t\t\t\t\t\t      _______________________");
		System.out.println("\t\t\t\t\t\t\t\t     |                       |");
		System.out.println("\t\t\t\t\t\t\t\t     |                       |");
		System.out.println("\t\t\t\t\t\t\t\t     |    CVHUB TERMINAL     |");
		System.out.println("\t\t\t\t\t\t\t\t     |   >_ Welcome to CVHUB |");
		System.out.println("\t\t\t\t\t\t\t\t     |                       |");
		System.out.println("\t\t\t\t\t\t\t\t     |_______________________|");

		// Stand
		System.out.println("\t\t\t\t\t\t\t\t            |       |");
		System.out.println("\t\t\t\t\t\t\t\t            |       |");
		System.out.println("\t\t\t\t\t\t\t\t            |_______|");

		// Keyboard
		System.out.println("\t\t\t\t\t\t\t\t    /=======================\\");
		System.out.println("\t\t\t\t\t\t\t\t   | [ ] [ ] [ ] [ ] [ ] [ ] |");
		System.out.println("\t\t\t\t\t\t\t\t   | [ ] [ ] [ ] [ ] [ ] [ ] |");
		System.out.println("\t\t\t\t\t\t\t\t   | [_________SPACE________] |");
		System.out.println("\t\t\t\t\t\t\t\t    \\=======================/\n");

		System.out.println("\t\t\t\t\t\t            CCCCC   V     V   H     H   U    U  BBBBBB");
		System.out.println("\t\t\t\t\t\t            C       V     V   H     H   U    U  B    B");
		System.out.println("\t\t\t\t\t\t            C       V     V   H     H   U    U  B    B");
		System.out.println("\t\t\t\t\t\t            C       V     V   HHHHHHH   U    U  BBBBBB");
		System.out.println("\t\t\t\t\t\t            C        V   V    H     H   U    U  B    B");
		System.out.println("\t\t\t\t\t\t            C         V V     H     H   U    U  B    B");
		System.out.println("\t\t\t\t\t\t            CCCCC      V      H     H   UUUUUU  BBBBBB");
		System.out.println();
		System.out.println();
		boolean running = true;
		while (running) {

			System.out.println("\t\t\t\t\t\t            ------------ Select the option ------------");
			System.out.println();
			System.out.println("\t\t\t\t\t\t\t\t\t   1.Join the Hub\n");
			System.out.println("\t\t\t\t\t\t\t\t\t   2.Enter the Hub\n");
			System.out.println("\t\t\t\t\t\t\t\t\t   3.Leave the Hub\n");

			int choice = in.nextInt();
			switch (choice) {
				case 1:
					signup();

					break;
				case 2:
					signup();
					break;
				case 3:
					System.out.println();
					System.out.println("\t\t\t\t\t\t            ------------   Thank You!  ------------");
					System.out.println();
					System.out.println("\t\t\t\t\t\t            ----------- Committer: You  ------------");
					System.out.println();
					System.out.println("\t\t\t\t\t\t            ----------- Repository: CvHub ------------");
					System.out.println();
					System.out.println("\t\t\t\t\t\t             -> We truly appreciate your support!             ");
					System.out.println();
					System.out.println("\t\t\t\t\t\t  -> Keep committing, keep pushing, and keep building amazing             ");
					running = false;
					break;
			}

		}

	}

}
