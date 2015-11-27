package com.example.jerald.huffpuff;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Effects extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_effects);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                if(position == 0)
                {
                    Intent respiratory = new Intent(getApplicationContext(), Respiratory.class);
                    startActivity(respiratory);
                }

                else if(position == 1)
                {
                    Intent cardio = new Intent(getApplicationContext(), Cardio.class);
                    startActivity(cardio);
                }

                else if(position == 2)
                {
                    Intent central = new Intent(getApplicationContext(), Central.class);
                    startActivity(central);
                }

                else if(position == 3)
                {
                    Intent inte = new Intent(getApplicationContext(), Integumentary.class);
                    startActivity(inte);
                }
                else if(position == 4)
                {
                    Intent digest = new Intent(getApplicationContext(), Digestive.class);
                    startActivity(digest);
                }
                else if(position == 5)
                {
                    Intent repro = new Intent(getApplicationContext(), Reproductive.class);
                    startActivity(repro);
                }
                else if(position == 6)
                {
                    Intent baby = new Intent(getApplicationContext(), Baby.class);
                    startActivity(baby);
                }
                else if(position == 7)
                {
                    Intent im = new Intent(getApplicationContext(), Image.class);
                    startActivity(im);
                }
            }
        };
        ListView listViewE = (ListView) findViewById(R.id.listViewEffects);
        listViewE.setOnItemClickListener(itemClickListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_effects, menu);
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
