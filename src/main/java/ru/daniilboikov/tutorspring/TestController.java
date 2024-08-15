package ru.daniilboikov.tutorspring;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.daniilboikov.tutorspring.dto.PersonDTO;
import ru.daniilboikov.tutorspring.service.TestService;

@RestController("/test")
@RequiredArgsConstructor
public class TestController {


    private final TestService testService;

    @GetMapping("/test")
    public void test(){
        System.out.println("sadfsddfdsf");
    }


    @GetMapping("/test-print/{text}")
    public String testPrint(@PathVariable("text")String text){
        return text;
    }

    @Operation(summary = "Метод изменяет фамилию и имя местами")
    @PutMapping("/person-update/{id}")
    public PersonDTO personTransform(@PathVariable("id") Integer id, @RequestBody PersonDTO personDTO){
        return testService.transformationPerson(personDTO);
    }
}
