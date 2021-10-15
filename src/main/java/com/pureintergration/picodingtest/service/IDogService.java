package com.pureintergration.picodingtest.service;

import com.pureintergration.picodingtest.model.Dog;

import java.util.List;

public interface IDogService {
    List<Dog> getall();
    void save(Dog dog);
}
