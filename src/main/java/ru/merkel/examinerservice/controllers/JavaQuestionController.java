package ru.merkel.examinerservice.controllers;

import org.springframework.web.bind.annotation.*;
import ru.merkel.examinerservice.models.Question;
import ru.merkel.examinerservice.services.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(path = "/add/{question}/{answer}")
    public Question add(@PathVariable String question, @PathVariable String answer) {
        return questionService.add(question,answer);
    }

    @GetMapping(path = "/remove/{question}/{answer}")
    public Question remove(@PathVariable String question, @PathVariable String answer) {
        return questionService.remove(new Question(question, answer));
    }

    @GetMapping(path = "/")
    public Collection<Question> getAll() {
        return questionService.getAll();
    }
}
