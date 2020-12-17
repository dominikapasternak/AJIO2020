package com.cenzurabackend.cenzura;

import com.cenzurabackend.cenzura.entity.Curse;
import com.cenzurabackend.cenzura.repository.CensureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Order(1)
public class MyCommandLineRunner implements CommandLineRunner {

    @Autowired
    CensureRepository censureRepository;

    @Override
    public void run(String... args) throws Exception {
        String[] cursesArray = {"chuj","dupa","cipa","cycki","sperma","ruchanie","kurwa","kurwamać","japierdole","suka","kutas","zdzira","Hitler",
        "jebać","jebanie"};
        List<String> curses = Arrays.asList(cursesArray);

        curses.stream()
                .forEach(curse -> {
                    Curse crs = new Curse(curse);
                    censureRepository.save(crs);
                });

    }

}
