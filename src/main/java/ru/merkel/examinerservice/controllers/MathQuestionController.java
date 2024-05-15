package ru.merkel.examinerservice.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.merkel.examinerservice.models.Question;
import ru.merkel.examinerservice.services.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/math")
public class MathQuestionController {
    private final QuestionService questionService;

    public MathQuestionController(@Qualifier("mathQuestionService") QuestionService questionService) {
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
