package com.jenish9599.android.eleganceapp;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

/**
 * Created by jenishpatel on 06/12/17.
 */

public class PageViewerAdeptor extends PagerAdapter {


    List<blogs> data = Collections.emptyList();

    private Context context;
    private LayoutInflater layoutInflater;

    public PageViewerAdeptor(List<blogs> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (LinearLayout) object);
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = layoutInflater.inflate(R.layout.custom_raw, container, false);
        blogs current = data.get(position);


        TextView title = itemView.findViewById(R.id.title);
        ImageView img = itemView.findViewById(R.id.imgid);
        TextView description = itemView.findViewById(R.id.des);


        String imgUri = current.getImgsrc();
        Picasso.with(context).load(imgUri).into(img);
        title.setText(current.getTitle());
        description.setText(current.getDescription());


        container.addView(itemView);
        return itemView;


    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
