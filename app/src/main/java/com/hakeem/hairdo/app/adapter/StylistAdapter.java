package com.hakeem.hairdo.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hakeem.hairdo.R;
import com.library.hakeem.hairdo.dto.StylistDTO;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by SiphoKobue on 2015/08/04.
 */
public class StylistAdapter extends ArrayAdapter<StylistDTO> {
    StylistListener listener;
    private final int layoutRes;
    private final LayoutInflater inflater;
    private List<StylistDTO> list;
    private Context context;
    private String log = "StylistAdapter";
    SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd, HH:mm");

    public StylistAdapter(Context context, int resource, List<StylistDTO> objects, StylistListener lis) {
        super(context, resource, objects);
        listener = lis;
        list = objects;
        this.context = context;
        layoutRes = resource;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Holder holder;
        if (convertView == null) {
            holder = new Holder();
            convertView = inflater.inflate(layoutRes, null);
            holder.name = (TextView) convertView.findViewById(R.id.stylist_name);
            holder.phone = (TextView) convertView.findViewById(R.id.stylist_phone);
            holder.email = (TextView) convertView.findViewById(R.id.stylist_email);

            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        final StylistDTO dto = list.get(position);
        holder.name.setText(dto.getName());
        holder.phone.setText(dto.getPhone());
        holder.email.setText(dto.getEmail());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(dto);
            }
        });
        return convertView;
    }

    class Holder{
        TextView name, phone, email;
        ImageView image;
    }

    public interface StylistListener {
        public void onClick(StylistDTO dto);
    }
}
