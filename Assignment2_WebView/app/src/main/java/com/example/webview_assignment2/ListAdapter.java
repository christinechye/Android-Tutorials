package com.example.webview_assignment2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import org.jetbrains.annotations.Nullable;
import java.util.ArrayList;


public class ListAdapter extends BaseAdapter {

    Context context;
    private final String [] values;
    private final int [] images;

    public ListAdapter(Context context, String [] values, int [] images){
        //super(context, R.layout.single_list_app_item, utilsArrayList);
        this.context = context;
        this.values = values;
        this.images = images;
    }

    @Override
    public int getCount() {
        return values.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        final View result;
        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.activity_list_row, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.text);
            viewHolder.icon = (ImageView) convertView.findViewById(R.id.img);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        viewHolder.txtName.setText(values[position]);
        viewHolder.icon.setImageResource(images[position]);

        return convertView;
    }

    private static class ViewHolder {
        TextView txtName;
        ImageView icon;

    }

}