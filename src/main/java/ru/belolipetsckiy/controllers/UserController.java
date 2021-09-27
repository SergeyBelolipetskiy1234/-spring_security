package ru.belolipetsckiy.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.belolipetsckiy.models.Role;
import ru.belolipetsckiy.models.User;
import ru.belolipetsckiy.service.RoleService;
import ru.belolipetsckiy.service.UserService;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/user")
public class UserController {
    
    private UserService userService;
    private RoleService roleService;

    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }



    @GetMapping()
    public String index (@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", userService.index());
        model.addAttribute("roles", user.getRoles());
        return "user/index";
    }

   @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, @AuthenticationPrincipal User user, Model model){
        model.addAttribute("user", userService.show(id));
        model.addAttribute("roles", user.getRoles());
        return "user/show";

    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleService.getRoles());
        return "user/new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, @RequestParam(value = "roles") String[] roles) {
      /*  if(bindingResult.hasErrors())
            return "user/new"; */
        Set<Role> setRole = new HashSet<>();
        for (String role : roles) {
            setRole.add(roleService.getRoleByName(role));
        }
        user.setRoles(setRole);
        userService.save(user);
        return "redirect:/user";

    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.show(id));
        model.addAttribute("roles", roleService.getRoles());
        return "user/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, @PathVariable("id") int id, @RequestParam(value = "roles") String[] roles) {
       /*if(bindingResult.hasErrors())
            return "user/edit"; */
        Set<Role> setRole = new HashSet<>();
        for (String role : roles) {
            setRole.add(roleService.getRoleByName(role));
        }
        user.setRoles(setRole);
        userService.update(id, user);
        return "redirect:/user";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/user";

    }
}
