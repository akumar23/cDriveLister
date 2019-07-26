import java.io.*;

// Recursively prints all the directories/files in the C drive (only works on a windows computer).

public class lister {

    private File file;

    public lister(File file) {
        this.file = file;
    }

    private void list(File file, String indent){
        
        // a try catch block to ensure that the program doesn't break when it encounters an admin only folder
        
        try {
            
            // checks if the current file is a directory
            
            if (file.isDirectory()) {
                
                // creates an array of all the files in the directory
                
                File[] list = file.listFiles();
                
                // prints out the directory name
                
                System.out.println(indent + file.getName());
                
                // goes through each file in the directory then lists each of them with an extra indent 
                
                for (File f : list) {
                    list(f, indent + "\t");
                }
            } else {
                
                // if the file isn't a directory it just prints the name of the file with the indent
                
                System.out.println(indent + file.getName());
            }
        } catch (NullPointerException n) {
            System.out.println(file.getName() + "has admin only access");
        }
    }

    public static void main(String[] args) {
        File f = new File("C:\\"); //this can be replaced with any desired location
        lister lister = new lister(f);
        lister.list(f,"");
    }

}
