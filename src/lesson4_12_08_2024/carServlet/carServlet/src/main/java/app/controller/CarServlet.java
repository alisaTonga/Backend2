package app.controller;

import app.repository.CarRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

public class CarServlet extends HttpServlet {
    //AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("app");
    //CarRepository repository = context.getBean(CarRepository.class);
    CarRepository repository = new CarRepository();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        String[] brands = parameterMap.get("brand");


        resp.getWriter().write(repository.findByBrand(brands[0]).toString());

    }
}
