package com.boyhotkey96.funnystories.Fragment.RSSTruyen;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.boyhotkey96.funnystories.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    Context context;
    ArrayList<Item> ds = new ArrayList<Item>();

    public MyAdapter(Context c, ArrayList<Item> ds) {
        context = c;
        this.ds = ds;
    }

    public static class View_Mot_O {
        public ImageView imgHinh;
        public TextView textview;
        public TextView tvPubDate;
        public TextView tvDescription;
    }

    @Override
    public int getCount() {
        return ds.size();
    }

    @Override
    public Object getItem(int position) {
        return 0;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View_Mot_O mot_o;
        LayoutInflater layoutInflater = ((Activity) context).getLayoutInflater();

        if (view == null) {
            mot_o = new View_Mot_O();
            view = layoutInflater.inflate(R.layout.rss_one_item_listview, null);
            //mot_o.imgHinh = (ImageView) view.findViewById(R.id.imgHinh);
            mot_o.textview = (TextView) view.findViewById(R.id.textView);
            mot_o.tvPubDate = (TextView) view.findViewById(R.id.tvPubDate);
            mot_o.tvDescription = (TextView) view.findViewById(R.id.tvDescription);
            view.setTag(mot_o);
        } else {
            mot_o = (View_Mot_O) view.getTag();
        }

        mot_o.textview.setText(ds.get(i).title);
        mot_o.tvDescription.setText(ds.get(i).description);

        mot_o.tvPubDate.setText(ds.get(i).pubDate);
        /*String duongdan = ds.get(i).getImgHinh();
        DownLoadHinhAnh downLoadHinhAnh = new DownLoadHinhAnh();
        downLoadHinhAnh.execute(duongdan);
        try {
            mot_o.imgHinh.setImageBitmap(downLoadHinhAnh.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/
        return view;
    }

    class DownLoadHinhAnh extends AsyncTask<String, Void, Bitmap> {
        Bitmap hinhanhdownload;

        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                InputStream inputStream = httpURLConnection.getInputStream();
                hinhanhdownload = BitmapFactory.decodeStream(inputStream);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return hinhanhdownload;
        }
    }
}
