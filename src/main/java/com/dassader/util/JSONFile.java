package com.dassader.util;

public class JSONFile {
    private String name;
    private boolean isFile;
    private boolean isDirectory;
    private boolean isHidden;

    public JSONFile(String name, boolean isFile, boolean isDirectory, boolean isHidden) {
        this.name = name;
        this.isFile = isFile;
        this.isDirectory = isDirectory;
        this.isHidden = isHidden;
    }

    public JSONFile() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFile() {
        return isFile;
    }

    public void setFile(boolean isFile) {
        this.isFile = isFile;
    }

    public boolean isDirectory() {
        return isDirectory;
    }

    public void setDirectory(boolean isDirectory) {
        this.isDirectory = isDirectory;
    }

    public boolean isHidden() {
        return isHidden;
    }

    public void setHidden(boolean isHidden) {
        this.isHidden = isHidden;
    }

    @Override
    public String toString() {
        return "{" +
                "\"name\": \"" + name + "\"," +
                "\"isFile\": \"" + isFile + "\"," +
                "\"isDirectory\": \"" + isDirectory + "\"," +
                "\"isHidden\": \"" + isHidden + "\"" +
                "}";
    }
}
