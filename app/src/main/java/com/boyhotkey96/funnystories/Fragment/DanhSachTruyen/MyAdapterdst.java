package com.boyhotkey96.funnystories.Fragment.DanhSachTruyen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.boyhotkey96.funnystories.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Tan on 12/2/2017.
 */

public class MyAdapterdst extends BaseAdapter {

    public List<Picture> pictureList;
    Context context;

    public MyAdapterdst(List<Picture> pictureList, Context context) {
        this.pictureList = pictureList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return pictureList.size();
    }

    @Override
    public Object getItem(int i) {
        return pictureList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row = view;
        if (row == null) {
            row = LayoutInflater.from(context).inflate(R.layout.custom_lvdst, null);

            TextView name = (TextView) row.findViewById(R.id.label);
            ImageView image = (ImageView) row.findViewById(R.id.image);

            Picasso.with(context).load(pictureList.get(i).getImageURL()).into(image);
            name.setText(pictureList.get(i).getName());
        }
        return row;
    }

//    int icons[];
//
//    String name[];
//
//
//    public MyAdapterdst(Context context, int icons[],String name[]){
//        this.context = context;
//        this.icons = icons;
//        this.name = name;
//    }
//
//    @Override
//    public int getCount() {
//        return name.length;
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return getItemId(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        View row = convertView;
//        if (row == null){
//            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//
//            row = inflater.inflate(R.layout.custom_lvdst, null);
//
//        }
//
//        ImageView img = (ImageView) row.findViewById(R.id.avatruyen);
//        TextView tv = row.findViewById(R.id.tentruyen);
//
//        img.setImageResource(icons[position]);
//        tv.setText(name[position]);
//
//
//
//        return row;
//    }
}
