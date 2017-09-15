//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.sql.Array;
import java.util.Arrays;

public class ArrayStorage {
    private static final int ARRAY_LIMIT = 10000;

    Resume[] storage = new Resume[ARRAY_LIMIT];
    private int msize = 0;

    public ArrayStorage() {
    }

    void clear() {
        Arrays.fill(storage, 0, ARRAY_LIMIT, null);
    }

    public void update(Resume r) {
        //  check for presence
        if (this.get(r.uuid) != null) {
            for (int i = 0; i < msize; i++)
            {
                if (storage[i].uuid.equals(r.uuid))
                {
                    storage[i]= r;
                    break;
                }
            }
        }
    }

    public void save(Resume r) {
        //check for absence
        if (this.get(r.uuid) == null) {
            msize++;
            this.storage[msize - 1] = r;
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < msize; i++) {
            if (uuid.equals(storage[i].uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < msize; ++i) {
            if (this.storage[i].uuid.equals(uuid)) {
                this.storage[i] = storage[msize - 1];
                this.storage[msize - 1] = null;
                msize--;
                break;
            }
        }

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
