package ru.merkel.examinerservice.services.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.merkel.examinerservice.exceptions.QuestionNotFoundException;
import ru.merkel.examinerservice.models.Question;
import ru.merkel.examinerservice.services.ExaminerService;
import ru.merkel.examinerservice.services.QuestionService;

import java.util.Collection;
import java.util.HashSet;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;

    public ExaminerServiceImpl(@Qualifier("javaQuestionService") JavaQuestionService javaQuestionService,
                               @Qualifier("mathQuestionService") MathQuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Collection<Question> questions = new HashSet<>();
        while (amount != questions.size()) {
            questions.add(javaQuestionService.getRandomQuestion());
            if (amount != questions.size()) {
                questions.add(mathQuestionService.getRandomQuestion());
            }
        }
        return questions;
    }
}
