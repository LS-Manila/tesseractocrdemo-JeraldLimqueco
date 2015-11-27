package com.example.jerald.huffpuff;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class CigaretteContent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cigarette_content);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                if(position == 0)
                {
                    Intent acetone = new Intent(getApplicationContext(), Acetone.class);
                    startActivity(acetone);
                }

                else if(position == 1)
                {
                    Intent lead = new Intent(getApplicationContext(), Lead.class);
                    startActivity(lead);
                }

                else if(position == 2)
                {
                    Intent formaldehyde = new Intent(getApplicationContext(), Formaldehyde.class);
                    startActivity(formaldehyde);
                }

                else if(position == 3)
                {
                    Intent nicotine = new Intent(getApplicationContext(), Nicotine.class);
                    startActivity(nicotine);
                }
            }
        };
        ListView listViewE = (ListView) findViewById(R.id.listViewContents);
        listViewE.setOnItemClickListener(itemClickListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cigarette_content, menu);
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
