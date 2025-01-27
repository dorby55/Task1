package com.example.task1;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomeAdapter extends RecyclerView.Adapter<CustomeAdapter.MyViewHolder>{

    private ArrayList<DataModel> dataSet;

    public CustomeAdapter(ArrayList<DataModel> dataSet) { this.dataSet = dataSet;}
    public class MyViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView textViewName;
        TextView textViewDescription;
        ImageView imageViewPhoto;

        public MyViewHolder(View itemView){
            super(itemView);
            cardView = itemView.findViewById(R.id.cardViewRes);
            textViewName = itemView.findViewById(R.id.characterName);
            textViewDescription = itemView.findViewById(R.id.characterDescription);
            imageViewPhoto = itemView.findViewById(R.id.characterImage);
        }
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_layout, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        TextView textViewName = holder.textViewName;
        TextView textViewDescription = holder.textViewDescription;
        ImageView imageView = holder.imageViewPhoto;

        textViewName.setText(dataSet.get(position).getName());
        textViewDescription.setText(dataSet.get(position).getDescription());
        imageView.setImageResource(dataSet.get(position).getImage());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Clicked: " + dataSet.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() { return dataSet.size(); }

}
