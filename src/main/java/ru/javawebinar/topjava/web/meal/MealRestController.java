package ru.javawebinar.topjava.web.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.to.MealTo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static ru.javawebinar.topjava.util.ValidationUtil.assureIdConsistent;
import static ru.javawebinar.topjava.web.SecurityUtil.getAuthUserId;

@Controller
public class MealRestController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MealService service;

    public List<MealTo> getAll(){
        log.info("get all for {}", getAuthUserId());
        return service.getAll(getAuthUserId());
    }

    public List<MealTo> getFiltered(LocalTime startTime, LocalTime endTime, LocalDate startDate, LocalDate endDate){
        log.info("get filtered for {}", getAuthUserId());
        return service.getFiltered(getAuthUserId(), startTime, endTime, startDate, endDate);
    }

    public Meal get(int id){
        log.info("get {} for {}", id, getAuthUserId());
        return service.get(id, getAuthUserId());
    }

    public Meal create (Meal meal){
        log.info("create {} for {}", meal, getAuthUserId());
        return service.create(meal, getAuthUserId());
    }

    public void delete (int id){
        log.info("delete {} for {}", id, getAuthUserId());
        service.delete(id, getAuthUserId());
    }

    public void update (Meal meal, int id){
        log.info("update {} with id={}", meal, id);
        assureIdConsistent(meal, id);
        service.update(meal, getAuthUserId());
    }

}