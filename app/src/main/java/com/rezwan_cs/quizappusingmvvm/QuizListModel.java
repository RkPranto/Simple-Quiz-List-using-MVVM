package com.rezwan_cs.quizappusingmvvm;

import com.google.firebase.firestore.DocumentId;

public class QuizListModel {
    @DocumentId
    String quiz_id;
    String topic;
    String desc;

    public QuizListModel(){}

    public QuizListModel(String quiz_id, String topic, String desc) {
        this.quiz_id = quiz_id;
        this.topic = topic;
        this.desc = desc;
    }

    public String getQuiz_id() {
        return quiz_id;
    }

    public void setQuiz_id(String quiz_id) {
        this.quiz_id = quiz_id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
