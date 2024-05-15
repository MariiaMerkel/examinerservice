package ru.merkel.examinerservice.repositiories.impl;

import org.springframework.stereotype.Repository;
import ru.merkel.examinerservice.exceptions.QuestionAlreadyAddedException;
import ru.merkel.examinerservice.exceptions.QuestionNotFoundException;
import ru.merkel.examinerservice.models.Question;
import ru.merkel.examinerservice.repositiories.QuestionRepository;

import java.util.*;

@Repository
public class MathQuestionRepository implements QuestionRepository {

    private final Set<Question> questions = new HashSet<>();

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
        Question next;
        while (i.hasNext()) {
            next = i.next();
            if (next.getQuestion().equals(question.getQuestion()) && next.getAnswer().equals(question.getAnswer())) {
                i.remove();
                return question;
            }
        }
        throw new QuestionNotFoundException("Такой вопрос не найден");
    }

    @Override
    public void removeAll() {
        questions.clear();
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }
}
