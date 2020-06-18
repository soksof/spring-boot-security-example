package gr.example.boot.securityexample.service;

import gr.example.boot.securityexample.model.Tour;

import java.util.List;

public interface TourService {
    void saveTour(Tour tour);
    List<Tour> getAll();
    void init();
    void updateTour(Tour tour);
    Tour findByTitle(String title);
}
