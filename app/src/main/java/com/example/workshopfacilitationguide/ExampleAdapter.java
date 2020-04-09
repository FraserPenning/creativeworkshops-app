package com.example.workshopfacilitationguide;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    private ArrayList<ExampleItem> mExampleList;
    private OnItemListener mOnItemListener;

    ExampleAdapter(ArrayList<ExampleItem> exampleList, OnItemListener onItemListener) {
        this.mExampleList = exampleList;
        this.mOnItemListener = onItemListener;
    }

    static class ExampleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView mImageView;
        TextView mTextView1;
        TextView mTextView2;
        TextView mTextView3;
        OnItemListener onItemListener;


        ExampleViewHolder(View itemView, OnItemListener onItemListener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mTextView1 = itemView.findViewById(R.id.textView1);
            mTextView2 = itemView.findViewById(R.id.textView2);
            mTextView3 = itemView.findViewById(R.id.textView3);
            this.onItemListener = onItemListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            onItemListener.onItemClick(getAdapterPosition());

        }
    }


    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item, parent, false);
        return new ExampleViewHolder(view, mOnItemListener);
    }
    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        ExampleItem currentItem = mExampleList.get(position);
        holder.mImageView.setImageResource(currentItem.getImageResource());
        holder.mTextView1.setText(currentItem.getText1());
        holder.mTextView2.setText(currentItem.getText2());
        holder.mTextView3.setText(currentItem.getText3());
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

    public void filterList(ArrayList<ExampleItem> filteredList) {
        mExampleList = filteredList;
        notifyDataSetChanged();
    }

    public interface OnItemListener{
        void onItemClick(int position);
    }
}
