package ru.daniilboikov.tutorspring.service;

import org.springframework.stereotype.Service;
import ru.daniilboikov.tutorspring.dto.PersonDTO;

@Service
public class TestService{
    public PersonDTO transformationPerson(PersonDTO dto){
        String temp = dto.getName();
        dto.setName(dto.getSurname());
        dto.setSurname(temp);
        return dto;
    }
}
