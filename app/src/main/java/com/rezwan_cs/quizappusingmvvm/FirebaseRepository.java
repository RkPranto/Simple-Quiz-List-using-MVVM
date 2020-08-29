package com.rezwan_cs.quizappusingmvvm;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class FirebaseRepository {

    private FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    private CollectionReference quizListRef = firebaseFirestore.collection("QuizList");
    private OnFirestoreRepository listener;

    public FirebaseRepository(OnFirestoreRepository listener){
        this.listener = listener;
    }

    public void getQuizdata(){
        quizListRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    Log.d("FirebaseRepo: ", task.getResult().toObjects(QuizListModel.class).toString());
                    listener.quizListDataAdded(task.getResult().toObjects(QuizListModel.class));
                }
                else{
                    listener.onError(task.getException());
                    Log.d("FirebaseRepo: ", task.getException().getMessage());
                }
            }
        });
    }


    public interface OnFirestoreRepository{
        void quizListDataAdded(List<QuizListModel> quizListModelList);
        void onError(Exception e);
    }
}
