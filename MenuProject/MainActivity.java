package com.example.hp.menuproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


@SuppressWarnings("ALL")
public class MainActivity extends ActionBarActivity {
    private static Button newActivityButton, smsBtn,phoneBtn, webBtn,mapBtn,shareBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        smsbtnClick();
        phonebtnClick();
        webbntClick();
        mapbtnClick();
        clickMe();
        sharebtnClick();
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
        if (id == R.id.action_about) {
            Intent about = new Intent(this, HelpActivity.class);
            startActivity(about);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void clickMe() {
        newActivityButton = (Button) findViewById(R.id.newactivitybtn);
        newActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.hp.menuproject.NewActivity");
                startActivity(intent);
            }
        });
    }

    public void webbntClick() {
        webBtn = (Button) findViewById(R.id.webbnt);
        webBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(browser);
            }
        });
    }

    public void smsbtnClick() {
        smsBtn = (Button) findViewById(R.id.smsbtn);
        smsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sms = new Intent(Intent.ACTION_SENDTO);
                sms.setData(Uri.parse("smsto:" + Uri.encode("7572867523")));
                sms.putExtra("sms_body", "Trong Le");
                startActivity(sms);
            }
        });
    }

    public void phonebtnClick() {
        phoneBtn = (Button) findViewById(R.id.phonebtn);
        phoneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phone = new Intent(Intent.ACTION_DIAL);
                phone.setData(Uri.parse("tel:7572867523"));
                startActivity(phone);
            }
        });
    }

    public void mapbtnClick() {
        mapBtn = (Button) findViewById(R.id.mapbtn);
        mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent map = new Intent(Intent.ACTION_VIEW);
                map.setData(Uri.parse("geo:41.8337329,-87.7321555"));
                Intent chooser = Intent.createChooser(map,"Launch Maps");
                startActivity(chooser);
            }
        });
    }

    public void sharebtnClick() {
        shareBtn = (Button) findViewById(R.id.sharebtn);
        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareme = new Intent(Intent.ACTION_VIEW);
                Intent chooser = Intent.createChooser(shareme,"Share the love");
                startActivity(chooser);

            }
        });
    }
}
