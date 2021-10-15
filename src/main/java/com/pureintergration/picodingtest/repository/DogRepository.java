package com.pureintergration.picodingtest.repository;

import com.pureintergration.picodingtest.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface DogRepository extends JpaRepository<Dog, Long> {

}
