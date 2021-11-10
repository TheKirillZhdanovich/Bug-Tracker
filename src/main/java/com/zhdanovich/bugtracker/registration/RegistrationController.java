package com.zhdanovich.bugtracker.registration;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping()
    public String createUser(Model model) {
        RegistrationRequest request = new RegistrationRequest();
        model.addAttribute("request", request);
        return "registration/registration_form";
    }

    @PostMapping()
    public String signInUser(@ModelAttribute RegistrationRequest request) {
        registrationService.register(request);
        return "redirect:/login";
    }

}
