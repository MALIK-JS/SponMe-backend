package com.sponme.SponMe.registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
@CrossOrigin( origins = "http://localhost:3000")
public class RegistrationController {

    private RegistrationService registrationService;


    @PostMapping(path = "api/v1/registration")
    public String register(@RequestBody RegistrationRequest request ){
        return registrationService.register(request);
    }


}
