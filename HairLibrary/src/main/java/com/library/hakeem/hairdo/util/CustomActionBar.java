package com.library.hakeem.hairdo.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by admin on 2015/07/08.
 */
import com.library.hakeem.hairdo.R;
public class CustomActionBar {
    public static void setCustomActionBar(Context ctx,
                                          ActionBar actionBar, String subTitle) {
        actionBar.setDisplayShowCustomEnabled(true);
        LayoutInflater inflator = (LayoutInflater)
                ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflator.inflate(R.layout.action_bar, null);
        TextView title = (TextView) v.findViewById(R.id.action_bar_title);
        TextView sub = (TextView) v.findViewById(R.id.action_bar_subtitle);
        title.setText("HairDo");
        sub.setText(subTitle);
        actionBar.setCustomView(v);
        actionBar.setTitle("");
        actionBar.setSubtitle("");
        Drawable dd = ctx.getResources().getDrawable(R.drawable.titlebar);
        actionBar.setBackgroundDrawable(dd);
    }
}
