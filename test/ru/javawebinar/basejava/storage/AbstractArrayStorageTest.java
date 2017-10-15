package ru.javawebinar.basejava.storage;

import org.junit.*;
import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

/**
 * Created by timur on 14.10.2017.
 */
public abstract class AbstractArrayStorageTest {


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
        Resume[] allRes = storage.getAll();
        Assert.assertEquals(new Resume(UUID_1), allRes[0]);
        Assert.assertEquals(new Resume(UUID_2), allRes[1]);
        Assert.assertEquals(new Resume(UUID_3), allRes[2]);
    }

    @Test
    public void save() throws Exception {
        storage.save(new Resume("uuid9"));
        Assert.assertEquals(new Resume("uuid9"), storage.get("uuid9"));
    }


    @Test
    public void get() throws Exception {
        Assert.assertEquals(new Resume("uuid2"), storage.get(UUID_2));
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

    @Test(expected = StorageException.class)
    public void overflow() throws Exception {
        for (int i = 4; i < AbstractArrayStorage.STORAGE_LIMIT + 10; i++) {
            storage.save(new Resume());
        }
    }

    @Test(expected = ExistStorageException.class)
    public void existStorageException() throws Exception {
        storage.save(new Resume(UUID_2));
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }
}