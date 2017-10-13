package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.Resume;

import java.lang.reflect.Field;

/**
 * Created by timur on 14.10.2017.
 */
public class MainReflection {

    public static void main(String[] args) throws IllegalAccessException {
        Resume r = new Resume();
        Field field = r.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println(field.getName());
        System.out.println(field.get(r));
        field.set(r, "new_uuid");
        // TODO : invoke r.toString via reflection
        System.out.println(r);
    }
}