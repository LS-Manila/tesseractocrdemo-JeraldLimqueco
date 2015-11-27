package com.example.jerald.huffpuff;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Support extends AppCompatActivity {

    TextToSpeech ttb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                if(position == 0)
                {
                    Intent map = new Intent(getApplicationContext(), MapsActivity.class);
                    startActivity(map);
                }

                else if(position == 1)
                {
                    Intent sharing = new Intent(Intent.ACTION_SEND);
                    sharing.setType("text/plain");
                    sharing.putExtra(Intent.EXTRA_TEXT, "A Friendly reminder: STOP Smoking and STAY HEALTHY!\n\nI'm using Huff 'n Puff to learn more about how to quit smoking. \n\nhttps://github.com/JeraldLimqueco/HuffandPuff");
                    startActivity(Intent.createChooser(sharing, "Share using"));
                }
                else if(position == 2)
                {
                    Intent ocr = new Intent(getApplicationContext(), OCR2.class);
                    startActivity(ocr);
                }

            }
        };
        ListView listViewE = (ListView) findViewById(R.id.listViewshare);
        listViewE.setOnItemClickListener(itemClickListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_support, menu);
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
