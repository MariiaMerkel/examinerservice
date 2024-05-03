package ru.merkel.examinerservice.services.impl;

import org.springframework.stereotype.Service;
import ru.merkel.examinerservice.exceptions.QuestionAlreadyAddedException;
import ru.merkel.examinerservice.exceptions.QuestionNotFoundException;
import ru.merkel.examinerservice.models.Question;
import ru.merkel.examinerservice.services.QuestionService;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private Set<Question> questions = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        Question q = new Question(question, answer);
        boolean added = questions.add(q);
        if (!added) {
            throw new QuestionAlreadyAddedException("Такой вопрос уже есть в списке");
        }
        return q;
    }

    @Override
    public Question add(Question question) {
        boolean added = questions.add(question);
        if (!added) {
            throw new QuestionAlreadyAddedException("Такой вопрос уже есть в списке");
        }
        return question;
    }

    @Override
    public Question remove(Question question) {
        Iterator<Question> i = questions.iterator();
        while (i.hasNext()) {
            if (i.next().getQuestion().equals(question.getQuestion())) {
                i.remove();
                return question;
            }
        }
        throw new QuestionNotFoundException("Такой сотрудник не найден");
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int count = random.nextInt(questions.size() + 1);
        for (; count > 0; count--) {
            if (count == 1) {
                return questions.iterator().next();
            }
        }
        throw new RuntimeException("Что-то пошло не иак");
    }
}
