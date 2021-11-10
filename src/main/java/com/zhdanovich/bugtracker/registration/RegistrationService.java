package com.zhdanovich.bugtracker.registration;

import com.zhdanovich.bugtracker.appuser.AppUser;
import com.zhdanovich.bugtracker.appuser.AppUserService;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final AppUserService appUserService;

    public RegistrationService(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    public void register(RegistrationRequest request){
        AppUser user = new AppUser(request.getFirstName(), request.getLastName(), request.getEmail(), request.getPassword());
        appUserService.signIn(user);
    }

}
