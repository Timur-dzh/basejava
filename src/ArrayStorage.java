//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int msize = 0;
    public ArrayStorage() {
    }

    void clear() {
        for (int i=0; i < msize; i++)
        {
            storage[i]= null;
        }
        msize = 0;
    }

    void save(Resume r) {
        for (int i = 0; i < msize; ++i) {
            if (this.storage[i] == null) {
                this.storage[i] = r;
                msize++;
                break;
            }
        }
    }

    Resume get(String uuid) {
        Resume result =null;

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
                this.storage[i] = storage[msize-1];
                this.storage[size()-1]=null;
                break;
            }
        }
      msize--;
    }

    Resume[] getAll() {
        if (msize== 0)
            return new Resume[0];

        else {
            int position = 0;

            Resume[] result = new Resume[msize];

            for (int j = 0; j < result.length; ++j) {
                for (int i = position; i < msize; ++i) {
                    if (this.storage[i] != null) {
                        result[j] = this.storage[i];
                        position = i;
                        break;
                    }
                }
            }
            return result;
        }
    }

    int size() {

        return msize;
    }
}
