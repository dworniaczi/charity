package pl.coderslab.charity.donation;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.category.Category;
import pl.coderslab.charity.category.CategoryRepository;
import pl.coderslab.charity.institution.Institution;
import pl.coderslab.charity.institution.InstitutionRepository;

import java.util.List;

@Controller
public class DonationController {

    private CategoryRepository categoryRepository;
    private InstitutionRepository institutionRepository;
    private DonationRepository donationRepository;

    @Autowired
    public DonationController (CategoryRepository categoryRepository, InstitutionRepository institutionRepository, DonationRepository donationRepository) {
        this.categoryRepository = categoryRepository;
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
    }

    @GetMapping("/form")
    public String donationAction (Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("institutions", institutionRepository.findAll());
        model.addAttribute("donation", new Donation());
        return "form";
    }

    @PostMapping("/form")
    public String saveDonation (Donation donation) {
        donationRepository.save(donation);
        return "form-confirmation";
    }

}
