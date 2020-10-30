package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SeveralItemsFileOpenManagerTest {
    HashMap<String, String> entity = new HashMap<>();
    FileOpenManager manager = new FileOpenManager(entity);

    @BeforeEach
    public void setUp() {
        manager.add("html", "Google Chrome");
        manager.add("docx", "Microsoft Word");
        manager.add("psd", "Adobe Photoshop");
    }

    @Test
    public void shouldGetApp() {
        String expected = "Microsoft Word".toLowerCase();
        String actual = manager.getApp("docx");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetAppIgnoringExtensionCase() {
        String expected = "Microsoft Word".toLowerCase();
        String actual = manager.getApp("DOCX");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveBinding() {
        HashMap<String, String> temp = new HashMap<>();
        temp.put("html".toLowerCase(), "Google Chrome".toLowerCase());
        temp.put("docx".toLowerCase(), "Microsoft Word".toLowerCase());
        temp.put("psd".toLowerCase(), null);

        manager.removeBinding("psd");

        Set expected = temp.entrySet();
        Set actual = entity.entrySet();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveBindingIfNotExist() {
        HashMap<String, String> temp = new HashMap<>();
        temp.put("html".toLowerCase(), "Google Chrome".toLowerCase());
        temp.put("docx".toLowerCase(), "Microsoft Word".toLowerCase());
        temp.put("psd".toLowerCase(), "Adobe Photoshop".toLowerCase());

        manager.removeBinding("jpg");

        Set expected = temp.entrySet();
        Set actual = entity.entrySet();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetRegisteredExtensions() {
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("docx".toLowerCase(), "html".toLowerCase(), "psd".toLowerCase()));
        Collections.sort(expected);
        ArrayList<String> actual = manager.getRegisteredExtensions();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetBindedApps() {
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("Adobe Photoshop".toLowerCase(), "Google Chrome".toLowerCase(), "Microsoft Word".toLowerCase()));
        Collections.sort(expected);
        ArrayList<String> actual = manager.getBindedApps();
        assertEquals(expected, actual);
    }
}