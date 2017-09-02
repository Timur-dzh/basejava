//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    public ArrayStorage() {
    }

    void clear() {
        this.storage = new Resume[10000];
    }

    void save(Resume r) {
        for (int i = 0; i < this.storage.length; ++i) {
            if (this.storage[i] == null) {
                this.storage[i] = r;
                break;
            }
        }

    }

    Resume get(String uuid) {
        Resume result = this.storage[0];

        try {
            for (int i = 0; i < this.storage.length; ++i) {
                if (this.storage[i].uuid.equals(uuid)) {
                    result = this.storage[i];
                    break;
                }
            }
        }
        catch (Exception e) {
            System.out.println("No such element!");
        }
        return result;
    }

    void delete(String uuid) {
        for (int i = 0; i < this.storage.length; ++i) {
            if (this.storage[i].uuid.equals(uuid)) {
                this.storage[i] = this.storage[size()-1];
                this.storage[size()-1]=null;
                break;
            }
        }

    }

    Resume[] getAll() {
        if (this.size() == 0)
            return new Resume[0];

        else {
            int position = 0;

            Resume[] result = new Resume[this.size()];

            for (int j = 0; j < result.length; ++j) {
                for (int i = position; i < this.storage.length; ++i) {
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
        int size = 0;

        for (int i = 0; i < this.storage.length; ++i) {
            if (this.storage[i] != null) {
                ++size;
            }
        }

        return size;
    }
}
