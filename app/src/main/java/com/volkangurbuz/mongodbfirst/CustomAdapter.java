package com.volkangurbuz.mongodbfirst;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.volkangurbuz.mongodbfirst.Class.User;

import java.util.List;

/**
 * Created by VolkanGurbuz on 2/22/2018.
 */

public class CustomAdapter extends BaseAdapter{

    private Context mContext;
    private List<User> lstUser;

    public CustomAdapter(Context mContext, List<User> lstUser) {
        this.mContext = mContext;
        this.lstUser = lstUser;
    }

    @Override
    public int getCount() {
        return lstUser.size();
    }

    @Override
    public Object getItem(int position) {
        return lstUser.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.row, null);

        TextView user = view.findViewById(R.id.txtView);
        user.setText(lstUser.get(position).getUser());
     return view;
    }
}
