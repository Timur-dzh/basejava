package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {


    protected abstract void updateIt(Resume r, Object key);

    protected abstract void saveIt(Resume r, Object key);

    protected abstract Resume getIt(Object key);

    protected abstract void deleteIt(Object key);

    @Override
    public void update(Resume r) {
        Object key = findExistingKey(r.getUuid());
        updateIt(r, key);
    }

    @Override
    public void save(Resume r) {
        Object key = findEmptyKey(r.getUuid());
        saveIt(r, key);
    }

    @Override
    public Resume get(String uuid) {
        Object key = findExistingKey(uuid);
        return getIt(key);
    }

    @Override
    public void delete(String uuid) {
        Object key = findExistingKey(uuid);
        deleteIt(key);
    }

    protected Object findEmptyKey(String uuid) {
        Object key = findKey(uuid);
        if (keyFound(key)) {
            throw new ExistStorageException(uuid);
        }
        return key;
    }

    protected  Object findExistingKey(String uuid){
        Object key = findKey(uuid);
        if (!keyFound(key)) {
            throw new NotExistStorageException(uuid);
        }
        return key;
    }

    protected abstract boolean keyFound(Object key);

    protected abstract Object findKey(String uuid);



}