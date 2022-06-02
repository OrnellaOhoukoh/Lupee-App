package com.ornella.lupee_accounting.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ornella.lupee_accounting.R;
import com.ornella.lupee_accounting.entities.Item;

import java.util.List;

public class ItemsAdapter extends ArrayAdapter {
    int layoutId;
    public ItemsAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        layoutId = resource;
    }

    @NonNull
    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(layoutId, parent,false);
        }
        TextView itemView = convertView.findViewById(R.id.item);
        Item item = (Item) getItem(position);
        itemView.setText("" + item.getName());
        return convertView;
    }

    //@NonNull
   // @Override
    //public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

    //    if(convertView == null){
      //      convertView = LayoutInflater.from(getContext()).inflate(layoutId, parent,false);
        //}
        //TextView itemView = convertView.findViewById(R.id.item);
        //Item item = (Item) getItem(position);
        //itemView.setText("" + item.getName());
        //return convertView;
   // }
}
