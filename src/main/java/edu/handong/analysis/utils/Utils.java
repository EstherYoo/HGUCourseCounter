package edu.handong.analysis.utils;
import java.io.*;
import java.util.ArrayList;

public class Utils {

	public static ArrayList<String> getLines(String file,boolean removeHeader) {
		ArrayList<String> lines = new ArrayList<>();
		BufferedReader bufferedReader = null;
        try{

    	    FileReader fileReader = new FileReader(file);
    	    bufferedReader = new BufferedReader(fileReader);
    	    String line = null;
    	  
    	    while ((line = bufferedReader.readLine()) != null) {
    	    	if(removeHeader) {
    	    		removeHeader = false;
    	    	    continue;
    	    	  }
    	    	lines.add(line);
    	    }
        } catch(FileNotFoundException e){
        	System.out.println("The file path does not exist. Please check your CLI argument!");
        	System.exit(0);
        } catch(IOException e){
            e.printStackTrace();
        } finally{
            try{
                if(bufferedReader != null){
                	bufferedReader.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
	    return lines;
	}

	public static void writeAFile(ArrayList<String> lines, String targetFileName) {
		BufferedWriter bufWriter = null;
        try{
            bufWriter = new BufferedWriter(new FileWriter(targetFileName));
            
            for (String line : lines) 
                bufWriter.append(line);
            	bufWriter.append(System.lineSeparator());
            bufWriter.flush();
        }catch(FileNotFoundException e){
            System.out.println("The file path does not exist. Please check your CLI argument!");
            System.exit(0);
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(bufWriter != null){
                    bufWriter.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
	}
}
