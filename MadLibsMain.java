import java.util.Scanner;

public class MadLibsMain {

	public static void main(String[] args) {
		User admin = new Admin();
		Scanner scan = new Scanner(System.in);
		User type = authenticate(scan);
		if (type == Admin) {
			displayAdminMenu();
		}
		elif(type == normalUser){
			displayNormalMenu();
		}
}
	

	static User authenticate(Scanner scan) {
		
		System.out.println("Welcome to the login system!");
        while (true) {
            System.out.println("1. Login as normal user");
            System.out.println("2. Login as admin");
            System.out.println("3. Create new account");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scan.nextInt();
            		switch (choice) {
                    case 1:
                        System.out.print("Enter username: ");
                        String normalUsername = scan.nextLine();
                        System.out.print("Enter password: ");
                        String normalPassword = scan.nextLine();
                        if (admin.loginUser(normalUsername, normalPassword)) {
                            System.out.println("Normal user logged in successfully!");
                        } else {
                            System.out.println("Invalid username or password.");
                        }
                        break;
                    case 2:
                        // Admin login logic
                        break;
                    case 3:
                        System.out.print("Enter new username: ");
                        String newUsername = scan.nextLine();
                        System.out.print("Enter new password: ");
                        String newPassword = scan.nextLine();
                        admin.createUser(newUsername, newPassword);
                        System.out.println("Account created successfully!");
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
	
}

}
