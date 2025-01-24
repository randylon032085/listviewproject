package com.example.watersportsrentalapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.zip.Inflater;

public class CustomAdapter extends BaseAdapter {

    public Context context;
    public String[] itemNames;
    TextView textView;
    public CustomAdapter (Context context, String[] itemNames ){
        this.context = context;
        this.itemNames = itemNames;
    }
    @Override
    public int getCount() {
        return itemNames.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){

           convertView = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);

           textView = convertView.findViewById(R.id.tView);
           textView.setText(itemNames[position]);

        }
        return convertView;
    }
}
