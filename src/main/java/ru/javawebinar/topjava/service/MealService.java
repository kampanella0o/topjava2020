package ru.javawebinar.topjava.service;

import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;

import java.util.List;

import static ru.javawebinar.topjava.util.ValidationUtil.checkNotFoundWithId;

@Service
public class MealService {

    private MealRepository repository;

    public MealService(MealRepository repository) {
        this.repository = repository;
    }

    public Meal create(Meal meal, int userID){
        return repository.save(meal, userID);
    }

    public void delete(int id, int userID){
        checkNotFoundWithId(repository.delete(id, userID), id);
    }

    public Meal get(int id, int userID){
        return checkNotFoundWithId(repository.get(id, userID), id);
    }

    public List<Meal> getAll(int userID){
        return repository.getAll(userID);
    }

    public void update(Meal meal, int userID){
        checkNotFoundWithId(checkNotFoundWithId(repository.save(meal, userID), meal.getId()), userID);
    }
}