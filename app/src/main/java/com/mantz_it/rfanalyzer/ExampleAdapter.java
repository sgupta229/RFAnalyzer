package com.mantz_it.rfanalyzer;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {

    private List<ExampleItem> exampleList;

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public TextView freq;

        public ExampleViewHolder(View itemView) {
            super(itemView);
            freq = itemView.findViewById(R.id.textView);
        }
    }

    public ExampleAdapter(List<ExampleItem> exampleList) {
        this.exampleList = exampleList;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        ExampleItem currentItem = exampleList.get(position);

        holder.freq.setText(currentItem.getFreq());
    }

    @Override
    public int getItemCount() {
        return exampleList.size();
    }
}
