import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class Story {
	
	private int userID;
	private boolean share;
	ArrayList<String> content = new ArrayList<String>(); 
	
	Story(){}
	
	Story(ArrayList<String> text){
		this.content = text;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public boolean isShare() {
		return share;
	}

	public void setShare(boolean shared) {
		this.share = shared;
	}

	public ArrayList<String> getContent() {
		return content;
	}

	public void setContent(ArrayList<String> content) {
		this.content = content;
	}
	
	
	
	public void createNew(String fileName) {
		
		ArrayList<String> newContent = new ArrayList<String>();
		try {
		      File file = new File(fileName);
		      Scanner scan = new Scanner(file);
		      while (scan.hasNextLine()) {
		        String data = scan.nextLine();
		        
		        
		      }
		      scan.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		this.setContent(newContent);}
	


	public void printStory() {
	
	}
}