package mainPackage;

import javax.swing.*;
import java.util.ArrayList;

public class NormalUser {
	
	private String username;
    private String password;
    private ArrayList<Story> savedStories;

    public NormalUser(String username, String password) {
        this.username = username;
        this.password = password;
        this.savedStories = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    // methods
    public void viewSavedStories() {
    	if (savedStories.isEmpty()) {
            JOptionPane.showMessageDialog(null, "You haven't saved any stories yet.");
        } else {
            StringBuilder savedStoriesInfo = new StringBuilder("Your saved stories:\n");
            for (Story story : savedStories) {
                savedStoriesInfo.append("- ").append(story.getTitle()).append("\n");
            }
            JOptionPane.showMessageDialog(null, savedStoriesInfo.toString());
        }
    }
    
    public void writeStory(Library library) {
    	String genre = JOptionPane.showInputDialog(null, "Choose a genre:");
        if (genre == null) return; // User canceled

        // get template for selected genre from library
        Story template = library.getTemplateByGenre(genre);
        if (template == null) {
            JOptionPane.showMessageDialog(null, "No template available for the selected genre.");
            return;
        }

        // ask user to fill in blanks
        ArrayList<String> filledBlanks = new ArrayList<>();
        for (String line : template.getContent()) {
            String filled = JOptionPane.showInputDialog(null, "Enter a " + line + ":");
            if (filled == null) return; // User canceled
            filledBlanks.add(filled);
        }

        // create story with filled blanks
        Story filledStory = new Story("Filled Story", genre, filledBlanks); 
        savedStories.add(filledStory);
        JOptionPane.showMessageDialog(null, "Story created and saved successfully.");
    }

    public void goToLibrary(Library library) {
    	if (library.isEmpty()) {
            JOptionPane.showMessageDialog(null, "The library is empty.");
        } else {
            library.displayLibrary();
        }
    }

    // add a story to saved stories list
    public void addSavedStory(Story story) {
        savedStories.add(story);
    }

}
