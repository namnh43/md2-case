package file;

import java.io.*;
import java.util.List;

public class ReadFile<T> {
    private String fileName;
    private File file;

    public ReadFile(String fileName) {
        this.fileName = fileName;
        file = new File(fileName);
    }
    public List<T> readFromFile() {
        List<T> list = null;
        try {
            FileInputStream is = new FileInputStream(file);
            ObjectInputStream objs = new ObjectInputStream(is);
            list = (List<T>) objs.readObject();
            is.close();
            objs.close();
        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
            System.err.println("File input not existed!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
