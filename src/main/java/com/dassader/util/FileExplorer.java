package com.dassader.util;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Andrii_Kulikov
 */
public class FileExplorer {
    private static FileExplorer fileExplorer = null;

    public static FileExplorer init(String path) {
        if (fileExplorer == null) {
            fileExplorer = new FileExplorer(path);
        }
        return fileExplorer;
    }

    public static FileExplorer init(String path, FileFilter fileFilter) {
        if (fileExplorer == null) {
            fileExplorer = new FileExplorer(path, fileFilter);
        }
        return fileExplorer;
    }

    String path;
    FileFilter fileFilter;

    private FileExplorer(String path, FileFilter fileFilter) {
        this.path = path;
        this.fileFilter = fileFilter;
    }

    public FileExplorer(String path) {
        this.path = path;
        this.fileFilter = null;
    }

    public void setFileFilter(FileFilter fileFilter) {
        this.fileFilter = fileFilter;
    }

    public void next(String path) {
        setPath(this.path + System.getProperty("file.separator") + path);
    }

    public void setPath(String path) {
        File file = new File(path);
        if (!file.exists()) {
            throw new IllegalArgumentException("Такого файла не существует: " + path);
        }
        this.path = path;
    }

    public ArrayList<File> getFileList() {
        ArrayList<File> folders = new ArrayList<File>();
        ArrayList<File> files = new ArrayList<File>();
        File[] listFile;
        File file = new File(path);
        if (!file.exists()) {
            throw new IllegalArgumentException("Такого файла не существует: " + path);
        }
        if (fileFilter == null) {
            listFile = file.listFiles();
        } else {
            listFile = file.listFiles(this.fileFilter);
        }

        for (File fileList : listFile) {
            if (fileList.isFile()) {
                files.add(fileList);
            } else {
                folders.add(fileList);
            }
        }

        Collections.sort(folders, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        Collections.sort(files, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        folders.addAll(files);
        return folders;
    }

    public String getJSONFileList() {
        ArrayList<File> target = getFileList();
        StringBuffer buffer = new StringBuffer();

        buffer.append("[");
        for (File file : target) {
            buffer.append(new JSONFile(file.getName(), file.isFile(), file.isDirectory(), file.isHidden()));
            buffer.append(",");
            buffer.append("\n");
        }
        buffer.append("]");
        String k = buffer.toString().replace(",]", "]");
        return k;
    }

    public String getPath() {
        return path;
    }

    public static String getFileExtention(String filename) {
        int dotPos = filename.lastIndexOf(".") + 1;
        return filename.substring(dotPos);
    }
}
