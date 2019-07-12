import java.io.*;

// Recursively prints all the directories/files in the C drive (only works on a windows computer).

public class lister {

    private File file;

    public lister(File file) {
        this.file = file;
    }

    private void list(File file, String indent){
        try {
            if (file.isDirectory()) {
                File[] list = file.listFiles();
                System.out.println(indent + file.getName());
                for (File f : list) {
                    list(f, indent + "\t");
                }
            } else {
                System.out.println(indent + file.getName());
            }
        }catch (NullPointerException n){
            System.out.println(file.getName() + "has admin only access");
        }
    }

    public static void main(String[] args){
        File f = new File("C:\\"); //this can be replaced with any desired location
        lister lister = new lister(f);
        lister.list(f,"");
    }

}
