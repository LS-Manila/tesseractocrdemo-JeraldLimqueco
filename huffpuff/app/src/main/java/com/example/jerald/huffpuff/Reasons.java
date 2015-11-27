package com.example.jerald.huffpuff;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Reasons extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reasons);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                if(position == 0)
                {
                    Intent health = new Intent(getApplicationContext(), Health.class);
                    startActivity(health);
                }

                else if(position == 1)
                {
                    Intent family = new Intent(getApplicationContext(), Family.class);
                    startActivity(family);
                }

                else if(position == 2)
                {
                    Intent money = new Intent(getApplicationContext(), Wallet.class);
                    startActivity(money);
                }
                else if(position == 3)
                {
                    Intent conve = new Intent(getApplicationContext(), Convenience.class);
                    startActivity(conve);
                }
            }
        };
        ListView listViewE = (ListView) findViewById(R.id.listViewr);
        listViewE.setOnItemClickListener(itemClickListener);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_reasons, menu);
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
