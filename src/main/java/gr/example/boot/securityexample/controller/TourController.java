package gr.example.boot.securityexample.controller;

import gr.example.boot.securityexample.mapper.TourForm;
import gr.example.boot.securityexample.mapper.TourMapper;
import gr.example.boot.securityexample.model.Tour;
import gr.example.boot.securityexample.service.TourService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class TourController {
    TourService tourService;
    TourMapper tourMapper;

    public TourController(TourService tourService, TourMapper tourMapper){
        this.tourMapper = tourMapper;
        this.tourService = tourService;
    }

    @GetMapping("/tour/new")
    public String newTour(Model model){
        TourForm newTour = new TourForm();
        model.addAttribute("newTour", newTour);
        return "fragments/tour/new";
    }

    @PostMapping("/tour/new")
    public String saveNewTour(@ModelAttribute("newTour") @Valid TourForm tourForm, BindingResult result, Model model){
        for(ObjectError error: result.getAllErrors()){
            System.out.println(error.getDefaultMessage());
        }
        if(result.hasErrors()){
            model.addAttribute("newTour", tourForm);
            return "fragments/tour/new";
        }
        Tour tour = tourMapper.map(tourForm);
        System.out.println("I am sending you the new tour with the title: "+tour.getTitle());
        tourService.saveTour(tour);
        return "redirect:/index";
    }

    @GetMapping("/tour/update/{title}")
    public String updateTour(@PathVariable String title, Model model){
        Tour newTour = tourService.findByTitle(title);
        model.addAttribute("newTour", newTour);
        return "fragments/tour/update";
    }

    @PostMapping("/tour/update")
    public String updateTour(@ModelAttribute("newTour") Tour tour, BindingResult result, Model model){
        System.out.println("I am sending you the updated tour with the title: "+tour.getTitle());
        tourService.updateTour(tour);
        return "redirect:/index";
    }
}
