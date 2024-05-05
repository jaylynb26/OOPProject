package mainPackage;

import java.util.ArrayList;

public class Story {
    private String title;
    private String genre;
    private ArrayList<String> content;
    private boolean isTemplate;

    public Story(String title, String genre, ArrayList<String> content) {
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

    public ArrayList<String> getContent() {
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

    public void setContent(ArrayList<String> content) {
        this.content = content;
    }

    public void setTemplate(boolean isTemplate) {
        this.isTemplate = isTemplate;
    }

    // print story method
    public void printStory() {
        for (String line : content) {
            System.out.println(line);
        }
    }
}