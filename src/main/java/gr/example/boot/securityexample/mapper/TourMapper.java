package gr.example.boot.securityexample.mapper;

import gr.example.boot.securityexample.model.Tour;
import org.springframework.stereotype.Component;

@Component
public class TourMapper {

    public Tour map(TourForm tourForm){
        Tour tour = new Tour();
        tour.setDays(tourForm.getDays());
        tour.setTitle(tourForm.getPlace());
        tour.setSubtitle(tourForm.getRegion());
        tour.setPrice(tourForm.getPrice());
        return tour;
    }
}
