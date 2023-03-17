package kata.anthony.app;

import kata.anthony.app.config.JavaConfig;
import kata.anthony.app.model.User;
import kata.anthony.app.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        UserService userService = context.getBean(UserService.class);
        userService.add(new User("Anthony", "Cool", 20));
        userService.add(new User("some", "body", 30));
        userService.add(new User("name", "surname", 40));
        User user = userService.get(1);
        System.out.println(user);
        user.setAge(99);
        userService.update(user);
        System.out.println(userService.get(1));
        userService.delete(1);
        userService.getAll().forEach(System.out::println);
    }
}