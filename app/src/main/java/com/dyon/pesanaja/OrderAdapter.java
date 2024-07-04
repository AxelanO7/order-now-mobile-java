package com.dyon.pesanaja;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class OrderAdapter extends BaseAdapter {
    Activity activity;
    List<Order> items;
    private LayoutInflater inflater;

    public OrderAdapter(Activity activity, List<Order> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) convertView = inflater.inflate(R.layout.listview_layout, null);

        TextView customerName = (TextView) convertView.findViewById(R.id.inNama);
        TextView rice = (TextView) convertView.findViewById(R.id.inRice);
        TextView chicken = (TextView) convertView.findViewById(R.id.inChicken);
        TextView catfish = (TextView) convertView.findViewById(R.id.inCatfish);
        TextView mineral = (TextView) convertView.findViewById(R.id.inMineral);
        TextView tea = (TextView) convertView.findViewById(R.id.inTea);
        TextView orange = (TextView) convertView.findViewById(R.id.inOrange);
        TextView note = (TextView) convertView.findViewById(R.id.inNote);

        Order data = items.get(position);

        rice.setText(data.getRice());
//        chicken.setText(data.getChicken().toString());
//        catfish.setText(data.getCatfish().toString());
//        mineral.setText(data.getMineral().toString());
//        tea.setText(data.getTea().toString());
//        orange.setText(data.getOrange().toString());
//        note.setText(data.getNote());

        return convertView;
    }
}
