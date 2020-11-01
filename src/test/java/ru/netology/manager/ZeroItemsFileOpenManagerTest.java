package ru.netology.manager;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ZeroItemsFileOpenManagerTest {
    HashMap<String, String> entity = new HashMap<>();
    FileOpenManager manager = new FileOpenManager(entity);

    @Test
    public void shouldAdd() {
       HashMap<String, String> temp = new HashMap<>();
       temp.put("html".toLowerCase(), "Google Chrome".toLowerCase());

       manager.add("html", "Google Chrome");

       Set expected = temp.entrySet();
       Set actual = entity.entrySet();
       assertEquals(expected, actual);
    }

    @Test
    public void shouldNotGetApp() {
        String expected = null;
        String actual = manager.getApp("html");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveBinding() {
        HashMap<String, String> temp = new HashMap<>();

        manager.removeBinding("html");

        Set expected = temp.entrySet();
        Set actual = entity.entrySet();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotGetRegisteredExtensions() {
        List<String> expected = List.of();
        List<String> actual = manager.getRegisteredExtensions();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotGetBindedApps() {
        List<String> expected = List.of();
        List<String> actual = manager.getBindedApps();
        assertEquals(expected, actual);
    }
}