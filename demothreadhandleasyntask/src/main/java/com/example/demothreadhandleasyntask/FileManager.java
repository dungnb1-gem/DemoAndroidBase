package com.example.demothreadhandleasyntask;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;

public class FileManager {
    public static final String ROOT_PATH
            = Environment.getExternalStorageDirectory().getPath();
    private static final String ERROR = "error_FileManager";

    public FileOutputStream getFileOutputStream(String path) {
        try {
            File f = new File(path);
            f.getParentFile().mkdirs();
            f.createNewFile();
            FileOutputStream os = new FileOutputStream(f);
            return os;
        } catch (Exception ex) {
            Log.e(ERROR, "Error create file");
        }
        return null;
    }

}
