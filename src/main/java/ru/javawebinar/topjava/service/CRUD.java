package ru.javawebinar.topjava.service;

import java.util.Map;

public interface CRUD<T> {
    T get(int id);
    void create(T t);
    void update(T t);
    void delete(int id);
    Map<Integer, T> getAll();
}
