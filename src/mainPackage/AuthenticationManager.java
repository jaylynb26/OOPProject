package mainPackage;

import java.util.ArrayList;

public class AuthenticationManager {
	
	private static ArrayList<UserCredentials> normalUsers = new ArrayList<>();

    static {
        // demo users
        normalUsers.add(new UserCredentials("user1", "password1"));
        normalUsers.add(new UserCredentials("user2", "password2"));
        normalUsers.add(new UserCredentials("user3", "password3"));
    }

    // method to get normal users
    public static ArrayList<UserCredentials> getNormalUsers() {
        return normalUsers;
    }
    
    // method to add user credentials to the list
    public static void addUser(String username, String password) {
        normalUsers.add(new UserCredentials(username, password));
    }

}
