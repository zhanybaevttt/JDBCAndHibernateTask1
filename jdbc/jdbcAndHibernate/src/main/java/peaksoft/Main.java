package peaksoft;

import peaksoft.model.User;
import peaksoft.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        User user1 = new User("Atabek", "Dosbaev", (byte) 20);
        userService.saveUser(user1.getName(), user1.getLastName(), user1.getAge());

        User user2 = new User("Talant", "Zhanybaev", (byte) 24);
        userService.saveUser(user2.getName(), user2.getLastName(), user2.getAge());

        User user3 = new User("Ryskeldi", "Osmonov", (byte) 25);
        userService.saveUser(user3.getName(), user3.getLastName(), user3.getAge());

        List<User> userList = userService.getAllUsers();
        for (User user : userList) {
            System.out.println(user);
        }

           userService.cleanUsersTable();
          userService.dropUsersTable();


    }
    }

