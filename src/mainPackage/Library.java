package mainPackage;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Library {
    private ArrayList<Story> stories;

    public Library() {
        this.stories = new ArrayList<>();
        loadTemplates();
    }

    // getters
    public ArrayList<Story> getStories() {
        return stories;
    }
    
 
    // load the txt templates
    private void loadTemplates() {
        String projectDir = System.getProperty("user.dir");
        String[] genres = {"fantasy", "sci-fi", "horror"};
        for (String genre : genres) {
            String filename = projectDir + "/src/mainPackage/templates/" + genre + ".txt";
            Path filePath = Paths.get(filename);
            System.out.println("Loading template for " + genre + " from: " + filePath.toAbsolutePath());
            if (!Files.exists(filePath)) {
                System.err.println("Template file does not exist: " + filePath.toAbsolutePath());
                continue; // skip to next genre if file does not exist
            }
            try (BufferedReader br = Files.newBufferedReader(filePath)) {
                String title = br.readLine().substring("Title: ".length());
                String genreFromFile = br.readLine().substring("Genre: ".length());
                StringBuilder contentBuilder = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    contentBuilder.append(line).append("\n");
                }
                String[] contentLines = contentBuilder.toString().split("\n");
                List<String> contentList = Arrays.asList(contentLines);
                Story story = new Story(title, genreFromFile, contentList);
                System.out.println("Loaded story: " + story.getTitle() + " (" + story.getGenre() + ")");
                stories.add(story);
            } catch (IOException e) {
                System.err.println("Error loading template for genre " + genre + ": " + e.getMessage());
            }
        }
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
    
//    public static void main(String[] args) {
//        Library library = new Library();
//        ArrayList<Story> stories = library.getStories();
//
//        if (stories.isEmpty()) {
//            System.out.println("No story templates loaded.");
//        } else {
//            System.out.println("Loaded story templates:");
//            for (Story story : stories) {
//                System.out.println("Title: " + story.getTitle());
//                System.out.println("Genre: " + story.getGenre());
//                System.out.println("Content: " + story.getContent());
//                System.out.println();
//            }
//        }
//    }
}
