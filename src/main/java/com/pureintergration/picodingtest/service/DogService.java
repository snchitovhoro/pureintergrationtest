package com.pureintergration.picodingtest.service;

import com.pureintergration.picodingtest.model.Dog;
import com.pureintergration.picodingtest.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogService implements IDogService{

    @Autowired
    DogRepository dogRepository;
    @Override
    public List<Dog> getall() {
        return dogRepository.findAll();
    }

    @Override
    public void save(Dog dog) {
        dogRepository.save(dog);
    }
}
