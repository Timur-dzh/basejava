package ru.javawebinar.basejava.exception;

/**
 * Created by timur on 14.10.2017.
 */

public class NotExistStorageException extends StorageException {
    public NotExistStorageException(String uuid) {
        super("Resume " + uuid + " not exist", uuid);
    }
}