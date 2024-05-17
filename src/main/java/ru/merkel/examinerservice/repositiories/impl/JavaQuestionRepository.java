package ru.merkel.examinerservice.repositiories.impl;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;

import ru.merkel.examinerservice.exceptions.QuestionAlreadyAddedException;
import ru.merkel.examinerservice.exceptions.QuestionNotFoundException;
import ru.merkel.examinerservice.models.Question;
import ru.merkel.examinerservice.repositiories.QuestionRepository;

import static ru.merkel.examinerservice.constants.JavaQuestionsConstants.*;

@Repository
public class JavaQuestionRepository implements QuestionRepository {

    private final Set<Question> questions;

    public JavaQuestionRepository() {
        this.questions = new HashSet<>();
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
        System.out.println("Вызван метод JavaQuestionRepository.removeAll(). Список вопросов про Java пуст");
        getQuestions().clear();
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }

    @PostConstruct
    public void init() {
        questions.add(JAVA_OBJECT_QUESTION_1);
        questions.add(JAVA_OBJECT_QUESTION_2);
        questions.add(JAVA_OBJECT_QUESTION_3);
        questions.add(JAVA_OBJECT_QUESTION_4);
        questions.add(JAVA_OBJECT_QUESTION_5);
        questions.add(JAVA_OBJECT_QUESTION_6);
        questions.add(JAVA_OBJECT_QUESTION_7);
        questions.add(JAVA_OBJECT_QUESTION_8);
    }

    public Set<Question> getQuestions() {
        return questions;
    }
}
