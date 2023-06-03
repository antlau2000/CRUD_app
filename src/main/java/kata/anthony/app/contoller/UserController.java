package kata.anthony.app.contoller;

import kata.anthony.app.model.User;
import kata.anthony.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getAllUsers(ModelMap model) {
        model.addAttribute("users", userService.getAll());
        return "users";
    }

    @GetMapping("/users/new")
    public String newUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "new_user";
    }

    @PostMapping()
    public String submitNewUserForm(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/users";
    }

    @GetMapping("/users/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        User user = userService.get(id);
        model.addAttribute("user", user);
        return "edit_user";
    }

    @PatchMapping("/users/{id}")
    public String update(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/";
    }

    @DeleteMapping("/users/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/";
    }

}
