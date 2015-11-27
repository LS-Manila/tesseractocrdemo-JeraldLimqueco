package com.example.jerald.huffpuff;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Maintain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintain);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                if(position == 0)
                {
                    Intent keep = new Intent(getApplicationContext(), Keep.class);
                    startActivity(keep);
                }

                else if(position == 1)
                {
                    Intent urge = new Intent(getApplicationContext(), Urge.class);
                    startActivity(urge);
                }

                else if(position == 2)
                {
                    Intent stay = new Intent(getApplicationContext(), Stay.class);
                    startActivity(stay);
                }

                else if(position == 3)
                {
                    Intent reward = new Intent(getApplicationContext(), Reward.class);
                    startActivity(reward);
                }
                else if(position == 4)
                {
                    Intent lean = new Intent(getApplicationContext(), Lean.class);
                    startActivity(lean);
                }
            }
        };
        ListView listViewE = (ListView) findViewById(R.id.listView);
        listViewE.setOnItemClickListener(itemClickListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_maintain, menu);
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
