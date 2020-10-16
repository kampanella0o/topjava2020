package ru.javawebinar.topjava.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.to.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;

import java.util.List;

import static ru.javawebinar.topjava.util.ValidationUtil.checkNotFoundWithId;

@Service
public class MealService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private MealRepository repository;

    public MealService(MealRepository repository) {
        this.repository = repository;
    }

    public Meal create(Meal meal, int userID){
        log.info("create {} for {}", meal, userID);
        return repository.save(meal, userID);
    }

    public void delete(int id, int userID){
        log.info("delete {} for {}", id, userID);
        checkNotFoundWithId(repository.delete(id, userID), id);
    }

    public Meal get(int id, int userID){
        log.info("get {} for {}", id, userID);
        return checkNotFoundWithId(repository.get(id, userID), id);
    }

    public List<MealTo> getAll(int userID){
        log.info("get all for {}", userID);
        return MealsUtil.getTos(repository.getAll(userID), MealsUtil.DEFAULT_CALORIES_PER_DAY);
    }

    public void update(Meal meal, int userID){
        log.info("update {} for {}", meal, userID);
        checkNotFoundWithId(checkNotFoundWithId(repository.save(meal, userID), meal.getId()), userID);
    }
}