package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;

public class ListStorage extends AbstractStorage {

    ArrayList<Resume> storage = new ArrayList();


    @Override
    protected void updateIt(Resume r, Object key) {
        storage.set((Integer) key, r);
    }

    @Override
    protected void saveIt(Resume r, Object key) {
        storage.add(r);
    }

    @Override
    protected Resume getIt(Object key) {
        return storage.get((Integer) key);
    }

    @Override
    protected void deleteIt(Object key) {
     storage.remove(((Integer)key).intValue() );
    }

    @Override
    protected boolean keyFound(Object key) {
        return  key!= null ;

    }

    @Override
    protected Object findKey(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getUuid().equals(uuid)) return  i;
        }
        return null;
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public Resume[] getAll() {
        return (Resume[]) storage.toArray();
    }

    @Override
    public int size() {
      return   storage.size();
    }
}
