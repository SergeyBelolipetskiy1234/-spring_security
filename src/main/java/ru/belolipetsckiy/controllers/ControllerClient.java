package ru.belolipetsckiy.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.belolipetsckiy.models.User;
import ru.belolipetsckiy.service.UserService;
@Controller
public class ControllerClient {
    private UserService userService;


    public ControllerClient(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/client")
    public String client (@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        return "/client/client";
    }
}
