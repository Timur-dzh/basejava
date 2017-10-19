package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

public class MapStorage extends  AbstractStorage{
    @Override
    protected void updateIt(Resume r, Object key) {

    }

    @Override
    protected void saveIt(Resume r, Object key) {

    }

    @Override
    protected Resume getIt(Object key) {
        return null;
    }

    @Override
    protected void deleteIt(Object key) {

    }

    @Override
    protected boolean keyFound(Object key) {
        return false;
    }

    @Override
    protected Object findKey(String uuid) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    public int size() {
        return 0;
    }
}
