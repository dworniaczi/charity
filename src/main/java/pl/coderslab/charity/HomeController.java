package pl.coderslab.charity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.charity.donation.Donation;
import pl.coderslab.charity.donation.DonationRepository;
import pl.coderslab.charity.institution.Institution;
import pl.coderslab.charity.institution.InstitutionRepository;


import java.util.List;


@Controller
public class HomeController {

    private InstitutionRepository institutionRepository;
    private DonationRepository donationRepository;


    @Autowired
    public HomeController(InstitutionRepository institutionRepository, DonationRepository donationRepository) {
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
    }

    @GetMapping("/index")
    public String homeAction(Model model) {
        List<Institution> institutions = institutionRepository.findAll();
        model.addAttribute("countOfInstitutions", institutionRepository.count());
        model.addAttribute("countOfBags", donationRepository.findAll()
                .stream()
                .map(Donation::getQuantity)
                .mapToLong(Long::longValue).sum());
        model.addAttribute("institutions", institutions);
        return "index";
    }

}






