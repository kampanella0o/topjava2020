package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealsService;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {
    private static final Logger log = getLogger(UserServlet.class);
    private MealsService mealsService = new MealsService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("creating MealTo list and forwarding it to meals.jsp");

        if (request.getParameter("action") != null){
            if (request.getParameter("action").equals("delete")){
                log.debug("deleting a meal with id " + request.getParameter("id"));
                mealsService.delete(Integer.parseInt(request.getParameter("id")));
            }
        }

        request.setAttribute("mealsList", MealsUtil.filteredByStreams(new CopyOnWriteArrayList<>(mealsService.getAll().values()), LocalTime.MIN, LocalTime.MAX, 2000));
        request.getRequestDispatcher("/meals.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("into doPost");
        Meal mealToCreateOrUpdate = new Meal(LocalDateTime.parse(req.getParameter("dateTime")), req.getParameter("description"), Integer.parseInt(req.getParameter("calories")));
        if (req.getParameter("id").equals("")) {
            log.debug("adding a meal");
            mealsService.create(mealToCreateOrUpdate);
        } else {
            log.debug("updating a meal with id " + req.getParameter("id"));
            mealToCreateOrUpdate.setId(Integer.parseInt(req.getParameter("id")));
            mealsService.update(mealToCreateOrUpdate);
        }
        resp.sendRedirect(req.getContextPath() + "/meals");
    }
}
