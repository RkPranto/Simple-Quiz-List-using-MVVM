package com.rezwan_cs.quizappusingmvvm.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rezwan_cs.quizappusingmvvm.QuizListAdapter;
import com.rezwan_cs.quizappusingmvvm.QuizListModel;
import com.rezwan_cs.quizappusingmvvm.QuizListViewModel;
import com.rezwan_cs.quizappusingmvvm.R;

import java.util.List;

public class ListFragment extends Fragment {
    RecyclerView mQuizListRecycler;
    private QuizListViewModel quizListViewModel;
    private QuizListAdapter adapter ;

    public ListFragment() {
        // Required empty public constructor
    }


    public static ListFragment newInstance(String param1, String param2) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_list, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mQuizListRecycler = view.findViewById(R.id.recycler_quiz_list);

        adapter = new QuizListAdapter();
        mQuizListRecycler.setAdapter(adapter);
        mQuizListRecycler.setHasFixedSize(true);
        mQuizListRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        quizListViewModel = new ViewModelProvider(getActivity()).get(QuizListViewModel.class);

        quizListViewModel.getQuizListLiveData().observe(getViewLifecycleOwner(), new Observer<List<QuizListModel>>() {
            @Override
            public void onChanged(List<QuizListModel> quizListModelList) {
                adapter.setArrayList(quizListModelList);
                adapter.notifyDataSetChanged();
            }
        });
    }
}