package mainPackage;

import javax.swing.*;
import java.util.ArrayList;

public class Library {
    private ArrayList<Story> stories;

    public Library() {
        this.stories = new ArrayList<>();
    }

    // getters
    public ArrayList<Story> getStories() {
        return stories;
    }

    // add story to the library
    public void addStory(Story story) {
        stories.add(story);
    }

    // remove story from the library
    public void removeStory(Story story) {
        stories.remove(story);
    }

    // check if library is empty
    public boolean isEmpty() {
        return stories.isEmpty();
    }

    // display library's contents
    public void displayLibrary() {
        StringBuilder libraryInfo = new StringBuilder("Library contents:\n");
        for (Story story : stories) {
            libraryInfo.append("- ").append(story.getTitle()).append("\n");
        }
        JOptionPane.showMessageDialog(null, libraryInfo.toString());
    }

    // retrieve a story template by genre
    public Story getTemplateByGenre(String genre) {
        for (Story story : stories) {
            if (story.getGenre().equalsIgnoreCase(genre) && story.isTemplate()) {
                return story;
            }
        }
        return null; // template not found for given genre
    }
}