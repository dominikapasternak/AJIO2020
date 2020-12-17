package com.cenzurabackend.cenzura.service;

import antlr.StringUtils;
import com.cenzurabackend.cenzura.entity.Curse;
import com.cenzurabackend.cenzura.repository.CensureRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CensureService {

    @Autowired
    CensureRepository censureRepository;

    public String censoring(String message)
    {
        List<Curse> curses = censureRepository.findAll();
        String[] messageArray = message.split(" ");
        List<String> changeMessage = new ArrayList<>();
        Arrays.stream(messageArray).forEach(word -> {
            int changeMessageSize = changeMessage.size();
            curses.stream().forEach(curse -> {
                if (word.equals(curse.getCurse())){
                    StringBuilder newWord = new StringBuilder();
                    for (int i =0;i<curse.getCurse().length();i++)
                        newWord.append("*");
                    changeMessage.add(new String(newWord));
                }

            });
         if (changeMessageSize==changeMessage.size()) changeMessage.add(word);
        });
        StringBuilder censorMessage = new StringBuilder("");
        changeMessage.stream().forEach(x-> censorMessage.append(x+" "));
        return new String(censorMessage);
    }
}
