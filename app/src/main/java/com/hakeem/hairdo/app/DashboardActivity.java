package com.hakeem.hairdo.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.hakeem.hairdo.R;
import com.hakeem.hairdo.app.adapter.StylistAdapter;
import com.library.hakeem.hairdo.dto.RequestDTO;
import com.library.hakeem.hairdo.dto.ResponseDTO;
import com.library.hakeem.hairdo.dto.StylistDTO;
import com.library.hakeem.hairdo.util.CustomActionBar;
import com.library.hakeem.hairdo.util.ToastUtil;
import com.library.hakeem.hairdo.util.WebSocketUtil;

import java.util.ArrayList;
import java.util.List;


public class DashboardActivity extends ActionBarActivity {
    SharedPreferences sp;
    List<StylistDTO> list;
    StylistAdapter adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        CustomActionBar.setCustomActionBar(getApplicationContext(), getSupportActionBar(), sp.getString("username", ""));
        setFields();
    }

    void setFields() {
        listView = (ListView) findViewById(R.id.stylists);
        RequestDTO req = new RequestDTO();
        req.setRequestType(RequestDTO.getStylists);
        WebSocketUtil.sendRequest(getApplicationContext(), req, "socket", new WebSocketUtil.WebSocketListener() {
            @Override
            public void onMessage(ResponseDTO response) {
                list = new ArrayList<StylistDTO>();
                list = response.getStylists();
                adapter = new StylistAdapter(getApplicationContext(), R.layout.stylist_list_item, list, new StylistAdapter.StylistListener() {
                    @Override
                    public void onClick(final StylistDTO dto) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                ToastUtil.toast(getApplication(), dto.getName());
                                startActivity(new Intent(getApplicationContext(), MenuActivity.class));
                            }
                        });
                    }
                });
                listView.setAdapter(adapter);
            }

            @Override
            public void onClose() {

            }

            @Override
            public void onError(String message) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dashboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
