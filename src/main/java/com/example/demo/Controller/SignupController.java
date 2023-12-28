package com.example.demo.Controller;

import com.example.demo.Model.dto.SignUpRequest;
import com.example.demo.Model.dto.UserResult;
import com.example.demo.Service.SignupService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/signup")
@RequiredArgsConstructor
public class SignupController {

    @Autowired
    private SignupService signupService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public UserResult signup(@RequestBody @Valid SignUpRequest request) {
        return UserResult.create(signupService.signup(request));
    }

}
