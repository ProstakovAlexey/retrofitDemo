package client_json;

import java.util.ArrayList;

// POJO класс для получения списка файлов
public class FilesList {
    private ArrayList<String> files = new ArrayList<String>();

    public void setFiles(ArrayList<String> files) {
        this.files = files;
    }

    public String getFilesString() {
        StringBuilder result = new StringBuilder();
        for (String file : files) {
            result.append(file);
            result.append(";");
        }
        return result.toString();
    }
}
