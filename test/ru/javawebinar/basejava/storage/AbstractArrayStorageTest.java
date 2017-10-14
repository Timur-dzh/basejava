package ru.javawebinar.basejava.storage;

import org.junit.*;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

/**
 * Created by timur on 14.10.2017.
 */
public class AbstractArrayStorageTest {


    private Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";

    public AbstractArrayStorageTest(Storage o) {
       storage = o;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    public void size() throws Exception {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void update() throws Exception {
        storage.update(new Resume(UUID_1));
        Assert.assertEquals(UUID_1, storage.get("uuid1").toString());
    }

    @Test
    public void getAll() throws Exception {
        Assert.assertNotEquals(new ArrayStorage(), storage);
    }

    @Test
    public void save() throws Exception {
        storage.save(new Resume("uuid9"));
        Assert.assertEquals("uuid9", storage.get("uuid9").getUuid());
    }


    @Test
    public void get() throws Exception {
        Assert.assertEquals(UUID_2, storage.get(UUID_2).getUuid());
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws Exception {
        storage.delete(UUID_3);
        storage.get(UUID_3);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");

    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        Assert.assertArrayEquals(new ArrayStorage().getAll(), storage.getAll());
    }
}