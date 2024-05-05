package mainPackage;

import javax.swing.*;
import java.util.ArrayList;

public class Admin {
	
	private String username;
    private String password;
    private Library library;

    public Admin(String username, String password, Library library) {
        this.username = username;
        this.password = password;
        this.library = library;
    }

    // getters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    // methods
    public void viewLibrary() {
    	 if (library.isEmpty()) {
             JOptionPane.showMessageDialog(null, "The library is empty.");
         } else {
             library.displayLibrary();
         }
    }

    public void editStories() {
        if (library.isEmpty()) {
            JOptionPane.showMessageDialog(null, "The library is empty. No stories to edit.");
            return;
        }

        String storyTitle = JOptionPane.showInputDialog(null, "Enter the title of the story to edit:");
        if (storyTitle == null) return; // User canceled

        // find story in library
        Story storyToEdit = null;
        for (Story story : library.getStories()) {
            if (story.getTitle().equalsIgnoreCase(storyTitle)) {
                storyToEdit = story;
                break;
            }
        }

        if (storyToEdit == null) {
            JOptionPane.showMessageDialog(null, "Story not found in the library.");
            return;
        }

        // display the story content
        JOptionPane.showMessageDialog(null, "Editing story...\n" + storyToEdit.getContent());
    }

    public void deleteStories() {
        if (library.isEmpty()) {
            JOptionPane.showMessageDialog(null, "The library is empty. No stories to delete.");
            return;
        }

        String storyTitle = JOptionPane.showInputDialog(null, "Enter the title of the story to delete:");
        if (storyTitle == null) return; // User canceled

        // find and remove story from library
        Story storyToRemove = null;
        for (Story story : library.getStories()) {
            if (story.getTitle().equalsIgnoreCase(storyTitle)) {
                storyToRemove = story;
                break;
            }
        }

        if (storyToRemove == null) {
            JOptionPane.showMessageDialog(null, "Story not found in the library.");
            return;
        }

        library.removeStory(storyToRemove);
        JOptionPane.showMessageDialog(null, "Story deleted successfully.");
    }


    public void createTemplates() {
        // create templates (choose genre, write story template, etc.)
        JOptionPane.showMessageDialog(null, "Creating templates...");
    }

}
