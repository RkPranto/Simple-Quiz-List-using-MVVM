package com.rezwan_cs.quizappusingmvvm;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class QuizListAdapter extends RecyclerView.Adapter<QuizListAdapter.QuizListViewHolder> {
    List<QuizListModel> arrayList ;

    public void setArrayList(List<QuizListModel> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public QuizListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.each_quiz_list_item, parent, false);
        return new QuizListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuizListViewHolder holder, int position) {
        Log.d("Adapter : ", position+1+"");
        holder.mTopic.setText(arrayList.get(position).getTopic());
        holder.mDesc.setText(arrayList.get(position).getDesc());
    }

    @Override
    public int getItemCount() {
        return arrayList == null?0:arrayList.size();
    }

    public class QuizListViewHolder extends RecyclerView.ViewHolder{
        TextView mTopic, mDesc;
        public QuizListViewHolder(@NonNull View itemView) {
            super(itemView);

            mTopic = itemView.findViewById(R.id.tv_topic);
            mDesc = itemView.findViewById(R.id.tv_desc);
        }
    }
}
