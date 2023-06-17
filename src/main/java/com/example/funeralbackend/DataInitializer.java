package com.example.funeralbackend;

import com.example.funeralbackend.user.User;
import com.example.funeralbackend.user.UserRepository;
import com.example.funeralbackend.user.UserType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;

    public DataInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    String[] usernames = {"administrator", "funeralhomeemployee", "funeralmorgueworker" };
    UserType[] roles = {UserType.ADMINISTRATOR, UserType.FUNERAL_HOME_EMPLOYEE, UserType.FUNERAL_MORGUE_WORKER};

    @Override
    public void run(String... args) {

        for (int i = 0; i < usernames.length; i++) {
            User user = new User();
            user.setUsername(usernames[i]);
            user.setPassword("Test123!");
            user.setRole(roles[i]);
            userRepository.save(user);
        }
    }
}
