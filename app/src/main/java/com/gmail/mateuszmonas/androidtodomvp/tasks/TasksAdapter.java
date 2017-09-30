package com.gmail.mateuszmonas.androidtodomvp.tasks;


import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.gmail.mateuszmonas.androidtodomvp.R;
import com.gmail.mateuszmonas.androidtodomvp.data.objects.Task;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.ViewHolder> {

    private final List<Task> tasks;
    private final TasksFragment.TasksListListener listener;

    TasksAdapter(List<Task> tasks, TasksFragment.TasksListListener listener) {
        this.tasks = tasks;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tasks, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Task task = tasks.get(position);
        holder.task = task;
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TaskAdapter", "task was clicked");
            }
        });
    }

    void replaceData(List<Task> tasks, boolean forceUpdate){
        setList(tasks, forceUpdate);
        notifyDataSetChanged();
    }

    private void setList(List<Task> tasks, boolean forceUpdate){
        if(forceUpdate){
            this.tasks.clear();
        }
        this.tasks.addAll(tasks);
    }

    @Override
    public int getItemCount() {
        if(tasks==null) return 0;
        return tasks.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        final View view;
        Task task;
        @BindView(R.id.isDone)
        CheckBox isDone;
        @BindView(R.id.taskDescription)
        TextView taskDescription;
        ViewHolder(View view) {
            super(view);
            this.view=view;
            ButterKnife.bind(this, view);
            taskDescription.setText("asdasd");
        }
    }

}
