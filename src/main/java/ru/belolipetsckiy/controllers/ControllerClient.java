package ru.belolipetsckiy.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.belolipetsckiy.models.User;
import ru.belolipetsckiy.service.RoleService;
import ru.belolipetsckiy.service.UserService;
@Controller
public class ControllerClient {
    private UserService userService;
    private RoleService roleService;


    public ControllerClient(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/client")
    public String client (@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", user.getRoles());
        return "/client/client";
    }
}
