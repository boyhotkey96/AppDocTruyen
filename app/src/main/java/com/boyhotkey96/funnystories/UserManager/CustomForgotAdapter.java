package com.boyhotkey96.funnystories.UserManager;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.boyhotkey96.funnystories.R;

import java.util.List;

/**
 * Created by boyhotkey96 on 01/12/2017.
 */

public class CustomForgotAdapter extends ArrayAdapter<User> {

    Activity activity;
    int resource;
    List<User> objects;

    public CustomForgotAdapter(Activity activity, int resource, List<User> objects) {
        super(activity, resource, objects);
        this.activity = activity;
        this.resource = resource;
        this.objects = objects;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.user_custom_one_item_forgot, null, true);

        TextView user = view.findViewById(R.id.tvItemUserName);
        TextView email = view.findViewById(R.id.tvItemEmail);
        TextView password = view.findViewById(R.id.tvItemPassword);

        User index = objects.get(position);
        user.setText(index.getUsername());
        email.setText(index.getEmail());
        password.setText(index.getPassword());

        return view;
    }
}
