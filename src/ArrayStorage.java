//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import java.util.Arrays;

public class ArrayStorage {
    private static final int ARRAY_LIMIT = 10000;

    Resume[] storage = new Resume[ARRAY_LIMIT];
    private int msize = 0;

    public ArrayStorage() {
    }

    void clear() {
        Arrays.fill(storage, null);
        msize = 0;
    }

    public void update(Resume r) {
        int index = getIndex(r.uuid);
        if (index == -1) System.out.println("Resume uuid =" + r.uuid + "does not exist");

        else storage[index] = r;
        }



    public void save(Resume r) {

        if (getIndex(r.uuid) != -1) System.out.println("Error: Resume uuid = " + r.uuid + " already exists");

        else if (msize >= ARRAY_LIMIT) {
            System.out.println("Storage overflow");
        } else {
            storage[msize] = r;
            msize++;
        }


    }

    Resume get(String uuid) {

        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Resume " + uuid + " not exist");
            return null;
        }
        return storage[index];

    }

    void delete(String uuid) {
        int index = getIndex(uuid);

        if (index == -1) System.out.println("Resume with uuid=" + uuid + " not found");

        else {
            storage[index] = storage[msize - 1];
            storage[msize - 1] = null;
            msize--;
        }
    }

    Resume[] getAll() {
        if (msize <= 0)
            return new Resume[0];

        else {
            Resume[] result = new Resume[msize];
            System.arraycopy(this.storage, 0, result, 0, msize);
            return result;
        }
    }

    int size() {
        return msize;
    }

    int getIndex(String uuid) {

        if (msize == 0) return -1;

        for (int i = 0; i < msize; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
