package ru.javawebinar.basejava.exception;

/**
 * Created by timur on 14.10.2017.
 */

public class ExistStorageException extends StorageException {
    public ExistStorageException(String uuid) {
        super("Resume " + uuid + " already exist", uuid);
    }
}