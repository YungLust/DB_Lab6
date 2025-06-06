package com.example.DB_Lab6.config;

import com.example.DB_Lab6.entity.User;
import com.example.DB_Lab6.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements CommandLineRunner {
    private final UserRepository userRepository;

    public DataInit(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        if (!userRepository.existsByLogin("pipe")){
            User denis = new User();
            denis.setFirstName("Denis");
            denis.setPassword("zxc321");
            denis.setLastName("Medvedev");
            denis.setEmail("pipe@gmail.com");
            denis.setLogin("pipe");
            userRepository.save(denis);
        }
        if (!userRepository.existsByLogin("m.artyr")){
            User artur = new User();
            artur.setFirstName("Artur");
            artur.setPassword("1q2w3e4r");
            artur.setLastName("Yanchuk");
            artur.setEmail("m.artyr@gmail.com");
            artur.setLogin("m.artyr");
            userRepository.save(artur);
        }
    }
}
