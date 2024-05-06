package mainPackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TemplateLoader {

    public static List<Story> loadTemplatesFromFolder(String folderPath) {
        List<Story> templates = new ArrayList<>();

        File folder = new File(folderPath);
        File[] templateFiles = folder.listFiles();
        
        if (templateFiles != null) {
            for (File file : templateFiles) {
                if (file.isFile()) {
                    Story template = loadTemplate(file);
                    if (template != null) {
                        templates.add(template);
                    }
                }
            }
        }

        return templates;
    }

    private static Story loadTemplate(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String title = null;
            String genre = null;
            List<String> content = new ArrayList<>();

            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("Title: ")) {
                    title = line.substring("Title: ".length());
                } else if (line.startsWith("Genre: ")) {
                    genre = line.substring("Genre: ".length());
                } else {
                    content.add(line);
                }
            }

            if (title != null && genre != null && !content.isEmpty()) {
                return new Story(title, genre, content);
            } else {
                System.err.println("Missing title, genre, or content in file: " + file.getName());
                return null;
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + file.getName());
            e.printStackTrace();
            return null;
        }
    }
}
