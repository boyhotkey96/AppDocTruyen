package com.boyhotkey96.funnystories.Fragment.RSSTruyen;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MyTask extends AsyncTask<Void, Void, Void> {

    Context c;
    ListView lv;
    ProgressDialog dialog;
    String mangLink;
    URL url;

    ArrayList<Item> ds = new ArrayList<>();

    public MyTask(Context c, ListView lv) {
        this.c = c;
        this.lv = lv;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog = new ProgressDialog(c);
        dialog.setMessage("Loading...");
        dialog.setCancelable(false);
        dialog.show();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            //URL url = new URL("http://www.24h.com.vn/upload/rss/congnghethongtin.rss");
            //URL url = new URL("https://truyenclub.com/rss/the-loai/ngon-tinh");
            //String[] mang = new String[] {"https://truyenclub.com/rss/the-loai/lich-su", "https://truyenclub.com/rss/the-loai/lich-su"};
            ArrayList<String> link = new ArrayList<String>();
            link.add("https://truyenclub.com/rss/the-loai/lich-su");
            link.add("https://truyenclub.com/rss/the-loai/ngon-tinh");
            //link.add("http://www.24h.com.vn/upload/rss/euro2016.rss");
            //link.add("http://www.24h.com.vn/upload/rss/canhacmtv.rss");
            //link.add("http://vietnamnet.vn/rss/phap-luat.rss");

            //link.add("https://truyenclub.com/rss/the-loai/lich-su");

            for (int i = 0; i < link.size(); i++) {
                mangLink = link.get(i).toString();
                url = new URL(mangLink);

                HttpURLConnection connect = (HttpURLConnection) url.openConnection();

                //URL url = new URL("https://truyenclub.com/rss/the-loai/ngon-tinh");
                /*URLConnection connection = url.openConnection();
                InputStream in = connection.getInputStream();

                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                StringBuilder total = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    total.append(line).append('\n');
                }

                Log.d("dulieu", total.toString());*/

                MySaxParser parser = new MySaxParser();
                ds = parser.xmlParser(connect.getInputStream());

                Log.d("dulieu", "soluong: " + ds.size());
                Log.d("dulieu", ds.get(0).title);
                Log.d("dulieu", ds.get(1).link);
                Log.d("dulieu", ds.get(2).imgHinh);
                Log.d("dulieu", ds.get(3).description);
                Log.d("dulieu", ds.get(4).pubDate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        dialog.dismiss();
        //tv.setText(ds.get(0).link);
        MyAdapter adapter = new MyAdapter(c, ds);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(c, LuotActivity.class);
                intent.putExtra("link", ds.get(i).link);
                c.startActivity(intent);
            }
        });
    }
}
