package com.canyinghao.emptylistvisew;

import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {
    private EmptyListVisew elv;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        elv = new EmptyListVisew(this);
        lv = elv.getListView();
        elv.setProgressView("正在加载中...");
        setContentView(elv);
        post();


    }

    int i = 0;

    void post() {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                if (i == 2) {

                    lv.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, new String[]{"hello", "world"}));


                }

                elv.setEmptyView(R.mipmap.ic_launcher, "加载失败,点击刷新", new View.OnClickListener() {

                    @Override
                    public void onClick(View arg0) {

                        elv.setProgressView("继续加载...");
                        i++;


                        post();

                    }
                });

            }
        }, 2000);

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
