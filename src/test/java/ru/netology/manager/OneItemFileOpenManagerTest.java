package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class OneItemFileOpenManagerTest {
    HashMap<String, String> entity = new HashMap<>();
    FileOpenManager manager = new FileOpenManager(entity);

    @BeforeEach
    public void setUp() {
        manager.add("html", "Google Chrome");
    }

    @Test
    public void shouldAdd() {
        HashMap<String, String> temp = new HashMap<>();
        temp.put("html".toLowerCase(), "Google Chrome".toLowerCase());
        temp.put("docx".toLowerCase(), "Microsoft Word".toLowerCase());

        manager.add("docx", "Microsoft Word");

        Set expected = temp.entrySet();
        Set actual = entity.entrySet();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetApp() {
        String expected = "Google Chrome".toLowerCase();
        String actual = manager.getApp("html");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveBinding() {
        HashMap<String, String> temp = new HashMap<>();

        manager.removeBinding("html");

        Set expected = temp.entrySet();
        Set actual = entity.entrySet();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetRegisteredExtensions() {
        List<String> expected = List.of("html".toLowerCase());
        List<String> actual = manager.getRegisteredExtensions();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetBindedApps() {
        List<String> expected = List.of("Google Chrome".toLowerCase());
        List<String> actual = manager.getBindedApps();
        assertEquals(expected, actual);
    }
}