//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.lang.reflect.Array;

public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int msize = 0;

    public ArrayStorage() {
    }

    void clear() {
        for (int i = 0; i < msize; i++) {
            storage[i] = null;
        }
        msize = 0;
    }

    void save(Resume r) {
        msize++;
        this.storage[msize-1] = r;
    }

    Resume get(String uuid) {
        Resume result = null;

        for (int i = 0; i < msize; ++i) {
            if (this.storage[i].uuid.equals(uuid)) {
                result = this.storage[i];
                break;
            }
        }
        return result;
    }

    void delete(String uuid) {
        for (int i = 0; i < msize; ++i) {
            if (this.storage[i].uuid.equals(uuid)) {
                this.storage[i] = storage[msize - 1];
                this.storage[msize - 1] = null;
                break;
            }
        }
        msize--;
    }

    Resume[] getAll() {
        if (msize <= 0)
            return new Resume[0];

        else {
            Resume[] result = new Resume[msize];
            for (int i = 0; i < msize; ++i) {
                result[i] = this.storage[i];
            }
            return result;
        }
    }

    int size() {
        return msize;
    }
}
