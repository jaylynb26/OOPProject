import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class Library {
	
	ArrayList<Story> library = new ArrayList<Story>();
	protected boolean shared; 
	
	
	Library(){}
	
	Library(ArrayList<Story> lib, boolean share){
		this.library = lib;
		this.shared = share;
	}
	
	
	public ArrayList<Story> importLibrary() {
		ArrayList<Story> newLib = new ArrayList<Story>();
		
		return newLib;
	}
	
	public void addStory() {
		
	}
	
	public void deleteStory() {
		
	}
	
	public void printAll() {
		
	}
}
