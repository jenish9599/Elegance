package com.jenish9599.android.eleganceapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

/**
 * Created by jenishpatel on 06/12/17.
 */

public class MyAdeptor extends RecyclerView.Adapter<MyAdeptor.ViewHolder> {



    private LayoutInflater layoutInflater;
    List<blogs> data = Collections.emptyList();

    public MyAdeptor(LayoutInflater layoutInflater, List<blogs> data) {
        this.layoutInflater = layoutInflater;
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= layoutInflater.inflate(R.layout.custom_raw,parent,false);

        ViewHolder v = new ViewHolder(view);
        return v;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        blogs current = data.get(position);

        holder.title.setText(current.getTitle());
        holder.description.setText(current.getDescription());
        String imgUri = current.getImgsrc();
        Picasso.with(holder.context).load(imgUri).into(holder.img);


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {



        TextView title;
        ImageView img;
        TextView description;
        Context context;


        public ViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.title);
            img = (ImageView) itemView.findViewById(R.id.imgid);
            description = (TextView) itemView.findViewById(R.id.des);
            context = (Context) itemView.getContext();
        }
    }
}
