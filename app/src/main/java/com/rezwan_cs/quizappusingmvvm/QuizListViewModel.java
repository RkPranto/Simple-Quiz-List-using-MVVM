package com.rezwan_cs.quizappusingmvvm;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class QuizListViewModel extends ViewModel implements FirebaseRepository.OnFirestoreRepository {

    private FirebaseRepository firebaseRepository = new FirebaseRepository(this);

    private MutableLiveData<List<QuizListModel>> quizListLiveData = new MutableLiveData<>();

    public MutableLiveData<List<QuizListModel>> getQuizListLiveData() {
        return quizListLiveData;
    }

    public QuizListViewModel() {
        this.firebaseRepository.getQuizdata();
    }

    @Override
    public void quizListDataAdded(List<QuizListModel> quizListModelList) {
        quizListLiveData.setValue(quizListModelList);
    }

    @Override
    public void onError(Exception e) {

    }
}
