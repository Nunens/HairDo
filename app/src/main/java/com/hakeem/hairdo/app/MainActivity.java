package com.hakeem.hairdo.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.hakeem.hairdo.R;
import com.library.hakeem.hairdo.util.CustomActionBar;
import com.library.hakeem.hairdo.util.ToastUtil;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        CustomActionBar.setCustomActionBar(getApplicationContext(), getSupportActionBar(), sp.getString("username", ""));
        Thread timer = new Thread() {
            @Override
            public void run() {
                try {
                    synchronized (this) {
                        wait(3000);
                    }
                } catch (InterruptedException e) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ToastUtil.toast(getApplicationContext(),
                                    "Unable to start the timer");
                        }
                    });
                } finally {
                    finish();
                    startActivity(new Intent(getApplicationContext(),
                            DashboardActivity.class));
                }
            }
        };
        timer.start();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
