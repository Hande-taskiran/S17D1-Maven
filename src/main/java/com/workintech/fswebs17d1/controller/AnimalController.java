package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AnimalController {
    private Map<Integer, Animal> animals = new HashMap<>();

    @Value("${course.name}")
    private String courseName;

    @GetMapping("/workintech/animal")
    public List<Animal> getAllAnimals(){
        return new ArrayList<>(animals.values());
    }

    @GetMapping("/workintech/animal/{id}")
    public Animal getAnimalId(@PathVariable int id){
        return animals.get(id);
    }

    @PostMapping("/workintech/animal")
    public Animal addAnimal(@RequestBody Animal animal){
        animals.put(animal.getId(), animal);
        return animal;
    }

    @PutMapping("/workintech/animal/{id}")
    public Animal updateAnimal(@PathVariable int id, @RequestBody Animal animal){
       animals.put(id, animal);
        return animal;
    }

    @DeleteMapping("/workintech/animal/{id}")
    public Animal deleteAnimal(@PathVariable int id){
        animals.remove(id);
        return animals.get(id);
    }

    @GetMapping("/workintech/course")
    public String getCourseName(){
        return courseName;
    }
}
