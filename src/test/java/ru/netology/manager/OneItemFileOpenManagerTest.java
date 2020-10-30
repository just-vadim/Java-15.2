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
        temp.put("html".toLowerCase(), null);

        manager.removeBinding("html");

        Set expected = temp.entrySet();
        Set actual = entity.entrySet();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetRegisteredExtensions() {
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("html".toLowerCase()));
        ArrayList<String> actual = manager.getRegisteredExtensions();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetBindedApps() {
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("Google Chrome".toLowerCase()));
        ArrayList<String> actual = manager.getBindedApps();
        assertEquals(expected, actual);
    }
}