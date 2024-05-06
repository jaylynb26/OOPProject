package mainPackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TemplateLoader {

    public static void main(String[] args) {
      
        String templatesDirectory = "templates/";
        List<Template> templates = new ArrayList<>();

        File[] templateFiles = new File(templatesDirectory).listFiles();
        if (templateFiles != null) {
            for (File file : templateFiles) {
                if (file.isFile()) {
                    Template template = loadTemplate(file);
                    if (template != null) {
                        templates.add(template);
                    }
                }
            }
        }

        for (Template template : templates) {
            System.out.println(template);
        }
    }

    private static Template loadTemplate(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String title = null;
            String genre = null;
            StringBuilder contentBuilder = new StringBuilder();

            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("Title: ")) {
                    title = line.substring("Title: ".length());
                } else if (line.startsWith("Genre: ")) {
                    genre = line.substring("Genre: ".length());
                } else {
                    contentBuilder.append(line).append("\n");
                }
            }

            if (title != null && genre != null) {
                String content = contentBuilder.toString();
                return new Template(title, genre, content);
            } else {
                System.err.println("Missing title or genre in file: " + file.getName());
                return null;
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + file.getName());
            e.printStackTrace();
            return null;
        }
    }

    static class Template {
        private final String title;
        private final String genre;
        private final String content;

        public Template(String title, String genre, String content) {
            this.title = title;
            this.genre = genre;
            this.content = content;
        }

        @Override
        public String toString() {
            return "Template{" +
                    "title='" + title + '\'' +
                    ", genre='" + genre + '\'' +
                    ", content='" + content + '\'' +
                    '}';
        }
    }
}
