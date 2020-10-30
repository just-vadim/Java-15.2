package ru.netology.manager;

import java.util.*;

public class FileOpenManager {
    private Map<String, String> entity = new HashMap();

    public FileOpenManager(Map<String, String> entity) {
        this.entity = entity;
    }

    public void add(String extension, String app) {
        entity.put(extension.toLowerCase(), app);
    }

    public String getApp(String extension) {
        return entity.get(extension);
    }

    public void removeBinding(String extension) {
        entity.remove(extension);
    }

    public ArrayList<String> getRegisteredExtensions() {
        ArrayList<String> result = new ArrayList<>();
        for (Map.Entry<String, String> entry : entity.entrySet()) {
            if (entry.getValue() != null) {
                result.add(entry.getKey());
            }
        }
        Collections.sort(result);
        return result;
    }

    public ArrayList<String> getBindedApps() {
        ArrayList<String> result = new ArrayList<>();
        for (Map.Entry<String, String> entry : entity.entrySet()) {
            if (entry.getKey() != null) {
                result.add(entry.getValue());
            }
        }
        Collections.sort(result);
        return result;
    }
}