package com.example.willl.w5_dialogs;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.ScrollingTabContainerView;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    Configuration configuration;


    @BindView(R.id.bt1)
    Button bt1;


    @BindView(R.id.textView)
    TextView t1;

    @BindView(R.id.activity_main)
    LinearLayout rootLayout;

    int numofviews=10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        bt1.setOnClickListener( new myLis());

        ScrollView scrollView = new ScrollView(this);
        configuration= getResources().getConfiguration();

        LinearLayout sublayer= new LinearLayout(this);
        
        if(configuration.orientation==Configuration.ORIENTATION_LANDSCAPE)
            sublayer.setOrientation(LinearLayout.HORIZONTAL);
        else
            sublayer.setOrientation(LinearLayout.VERTICAL);

        for (int i=0; i<numofviews; i++)
        {
            Button btn = new Button(this);
            btn.setText("btn" + i);
            btn.setWidth(20);
            btn.setHeight(10);
            sublayer.addView(btn);

        }
         scrollView.addView(sublayer);
         rootLayout.addView(scrollView);




    }

    public void show(View view) {

        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setTitle("the title");
        builder.setMessage("message body go in this area");
        builder.setPositiveButton("agree", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();



    }

   public class myLis implements View.OnClickListener {



        @Override
        public void onClick(View v) {
            final DatePickerDialog datePickerDialog = new DatePickerDialog( MainActivity.this, new DatePickerDialog.OnDateSetListener(){
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    t1.setText(year+ " "+ month+1 + " " + " "+ dayOfMonth); //why the day is different

                }
            },2016,0,0);

            datePickerDialog.show();

        }
    }
}
