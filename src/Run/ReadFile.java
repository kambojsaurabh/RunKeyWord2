package Run;

import java.io.File;

public class ReadFile implements IAutoConstant{

	public static void main(String[] args) {
		File folder = new File(SCRIPT_XL_PATH);
		File[] listOfFiles = folder.listFiles();

		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		        String fileName = listOfFiles[i].getName();
			    String[] name=fileName.split(".xlsx"); 
			    //using java foreach loop to print elements of string array  
			    for(String w:name){  
			    System.out.println(w);   
			    }
		        } else if (listOfFiles[i].isDirectory()) {
		        System.out.println("Directory " + listOfFiles[i].getName());
		      }
		    }
		    
		   
		
	

}}

