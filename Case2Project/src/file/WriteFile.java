package file;

import java.io.*;
import java.util.List;

public class WriteFile<T> {
    private File file;
    private String  fileName;

    public WriteFile(String fileName) {
        this.fileName = fileName;
        file = new File(fileName);
    }
    public void writeToFile(List<T> list){
        try {
            FileOutputStream os = new FileOutputStream(file);
            ObjectOutputStream objs = new ObjectOutputStream(os);
            objs.writeObject(list);
            objs.close();
            os.close();
        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//            System.err.println("File not existed!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
