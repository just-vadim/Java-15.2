package ru.netology.manager;

import java.util.*;

public class FileOpenManager {
    private Map<String, String> entity;

    public FileOpenManager(Map<String, String> entity) {
        this.entity = entity;
    }

    public void add(String extension, String app) {
        entity.put(extension.toLowerCase(), app.toLowerCase());
    }

    public String getApp(String extension) {
        return entity.get(extension.toLowerCase());
    }

    public void removeBinding(String extension) {
        entity.remove(extension);
    }

    public List<String> getRegisteredExtensions() {
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, String> entry : entity.entrySet()) {
            if (entry.getValue() != null) {
                result.add(entry.getKey().toLowerCase());
            }
        }
        Collections.sort(result);
        return result;
    }

    public List<String> getBindedApps() {
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, String> entry : entity.entrySet()) {
            if (entry.getKey() != null) {
                result.add(entry.getValue().toLowerCase());
            }
        }
        Collections.sort(result);
        return result;
    }
}