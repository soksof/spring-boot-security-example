package gr.example.boot.securityexample.service;

import gr.example.boot.securityexample.model.Tour;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TourServiceImpl implements TourService{
    protected List<Tour> tours;

    @Override
    public void saveTour(Tour tour) {
        tours.add(tour);
    }

    @Override
    public List<Tour> getAll() {
        return this.tours;
    }

    @Override
    public void init() {
        if(this.tours==null){
            this.tours = new ArrayList<>();
            this.saveTour(new Tour("Athina", "Attiki", 6, 200, 600, "athens"));
            this.saveTour(new Tour("Thessaloniki", "Makedonia", 5, 140, 600, "thessaloniki"));
            this.saveTour(new Tour("Ioannina", "Hpeiros", 7, 60, 150, "ioannina"));
            this.saveTour(new Tour("Chania", "Kriti", 4, 80, 900, "chania"));
        }
    }

    @Override
    public void updateTour(Tour tour) {
        int index = this.getTourIndex(tour.getTitle());
        Tour oldTour = tours.get(index);
        tour.setImage(oldTour.getImage());
        tour.setReviews(oldTour.getReviews());
        this.tours.set(index, tour);
    }

    private int getTourIndex(String title){
        for(int i=0; i< this.tours.size(); i++){
            if(this.tours.get(i).getTitle().compareTo(title) == 0)
                return i;
        }
        return -1;
    }

    @Override
    public Tour findByTitle(String title) {
        for(Tour tour: this.tours){
            if(tour.getTitle().compareTo(title) == 0)
                return tour;
        }
        return null;
    }
}
