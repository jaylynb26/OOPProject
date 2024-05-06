package mainPackage;

import java.util.ArrayList;
import java.util.List;

public class Story {
    private String title;
    private String genre;
    private List<String> content;
    private boolean isTemplate;

    public Story(String title, String genre, List<String> content) {
        this.title = title;
        this.genre = genre;
        this.content = content;
        this.isTemplate = false;
    }

    // getters
    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public List<String> getContent() {
        return content;
    }

    // check template
    public boolean isTemplate() {
        return isTemplate;
    }

    // setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }

    public void setTemplate(boolean isTemplate) {
        this.isTemplate = isTemplate;
    }

    // print story method
    public void printStory() {
        System.out.println("Title: " + title);
        System.out.println("Genre: " + genre);
        System.out.println("Content:");
        System.out.println(content);
    }
    
}