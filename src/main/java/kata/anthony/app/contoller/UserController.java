package kata.anthony.app.contoller;

import kata.anthony.app.model.User;
import kata.anthony.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public String printUsers(ModelMap model) {
        model.addAttribute("users", userService.getAll());
        return "users";
    }

    @GetMapping("/new")
    public String newUserForm(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        return "new_user";
    }

    @PostMapping("/new")
    public String submitNewUserForm(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String editUserFrom(ModelMap model, @RequestParam(value = "id") long id) {
        User user = userService.get(id);
        model.addAttribute("user", user);
        return "edit_user";
    }

    @PostMapping("/edit")
    public String submitEditUserForm(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/users";
    }

    @RequestMapping("/delete")
    public String deleteUser(@RequestParam("id") long id) {
        userService.delete(id);
        return "redirect:/users";
    }

}
