package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        User user1 = new User("Lola", "Litaeva", "litaeva@mail.ru");
        User user2 = new User("Vova", "Vitas", "vitas@mail.ru");
        User user3 = new User("Hron", "Teador", "teadorrf@mail.ru");
        User user4 = new User("Vikusya", "Under", "undercover@mail.ru");

        Car car1 = new Car("Mercedes", 200);
        Car car2 = new Car("BMW", 720);
        Car car3 = new Car("Rols", 114);
        Car car4 = new Car("Porshe", 911);

        user1.setCar(car1);
        user2.setCar(car2);
        user3.setCar(car3);
        user4.setCar(car4);
        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        userService.add(user4);
        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println(user);
        }

        System.out.println(userService.getByCar("Rols", 114));
        context.close();
    }
}