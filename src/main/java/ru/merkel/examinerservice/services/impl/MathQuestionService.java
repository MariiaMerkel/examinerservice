package ru.merkel.examinerservice.services.impl;

import org.springframework.stereotype.Service;
import ru.merkel.examinerservice.exceptions.QuestionAlreadyAddedException;
import ru.merkel.examinerservice.exceptions.QuestionNotFoundException;
import ru.merkel.examinerservice.models.Question;
import ru.merkel.examinerservice.services.QuestionService;

import java.util.*;

@Service
public class MathQuestionService implements QuestionService {
    private final Random random = new Random();
    private final Set<Question> questions = new HashSet<>();

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

    @Override
    public Question getRandomQuestion() {
        if (!questions.isEmpty()) {
            List<Question> questionList = new ArrayList<>(questions);
            return questionList.get(random.nextInt(questions.size()));
        }
        throw new QuestionNotFoundException("В списке нет ни одного вопроса");
    }
}
