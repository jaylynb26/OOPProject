import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class Library {
	
	ArrayList<Story> library = new ArrayList<Story>();
	protected boolean shared; 
	
	
	Library(){
		
	}
	
	Library(ArrayList<Story> lib, boolean share){
		this.library = lib;
		this.shared = share;
	}
		
	public void addStory(Story newStory) {
		
		this.library.add(newStory);
		newStory.setIndex(this.library.indexOf(newStory));
		
	}
	
	public void deleteStory(Story removeStory) {
		this.library.remove(removeStory.index);
	}
	
	public void printAll() {
		for(int i = 0; i < this.library.size(); i++) {
			library.get(i).printStory(); 
			System.out.println(" ");
		}
	}
}
