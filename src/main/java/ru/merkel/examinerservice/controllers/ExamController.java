package ru.merkel.examinerservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.merkel.examinerservice.models.Question;
import ru.merkel.examinerservice.services.ExaminerService;
import ru.merkel.examinerservice.services.impl.ExaminerServiceImpl;

import java.util.Collection;

@RestController
public class ExamController {

    ExaminerService examinerService;

    public ExamController(ExaminerServiceImpl examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/exam/{amount}")
    public Collection<Question> getQuestion(@PathVariable int amount) {
        return examinerService.getQuestions(amount);
    }
}
