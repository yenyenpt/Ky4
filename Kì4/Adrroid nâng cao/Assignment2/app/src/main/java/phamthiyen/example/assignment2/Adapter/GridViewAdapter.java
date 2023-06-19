package phamthiyen.example.assignment2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import phamthiyen.example.assignment2.R;

public class GridViewAdapter extends BaseAdapter {
    private final Context context;
    private  final int[] img;
    private final String[] name;

    public GridViewAdapter(Context context, int[] img, String[] name) {
        this.context = context;
        this.img = img;
        this.name = name;
    }

    @Override
    public int getCount() {
        return name.length;
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
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.item_grid_view,null);
        ImageView imgIcon = convertView.findViewById(R.id.img_icon);
        TextView tvName = convertView.findViewById(R.id.tvName);

        imgIcon.setImageResource(img[position]);
        tvName.setText(name[position]);

        return convertView;
    }
}
