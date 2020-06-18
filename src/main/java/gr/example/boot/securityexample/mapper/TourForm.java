package gr.example.boot.securityexample.mapper;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class TourForm {
    @NotEmpty(message="Το πεδίο τοποθεσία δεν μπορεί να είναι κενό")
    private String place;
    @NotEmpty(message="Το πεδίο περιοχή δεν μπορεί να είναι κενό")
    private String region;
    @Min(value=1, message="Ο αριθμός ημερών πρέπει να είναι μεγαλύτερος του 1")
    @Max(value=15, message="Ο αριθμός ημερών δεν μπορεί να υπερβαίνει τις 15 ημέρες")
    private int days;
    @Min(value=50, message="Η τιμή πρέπει να είναι τουλάχιστον 50€ (καπέλο μεσάζωντα)")
    private int price;

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
