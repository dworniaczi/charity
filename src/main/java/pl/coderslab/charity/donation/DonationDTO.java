package pl.coderslab.charity.donation;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.coderslab.charity.category.Category;
import pl.coderslab.charity.institution.Institution;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor

public class DonationDTO {


    private Long id;
    private Long quantity;

    private List<Category> categories;

    private Institution institution;

    private String street;

    private String city;
    private Long zipCode;

    private Long phoneNumber;

    private String pickUpComment;

    public DonationDTO(Long id, Long quantity, List<Category> categories, Institution institution, String street, String city, Long zipCode, Long phoneNumber, String pickUpComment) {
        this.id = id;
        this.quantity = quantity;
        this.categories = categories;
        this.institution = institution;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.pickUpComment = pickUpComment;
    }
}
