package com.example.abhinayas.drawable;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.widget.TextView;


import java.util.ArrayList;

public class MainActivity extends Activity implements View.OnClickListener {

    ListView lv;
    TextView view;
    static final int check=1111;
    DrawShape v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        v= new DrawShape(MainActivity.this);
       // setContentView(v);
        setContentView(R.layout.activity_main);
        //lv=(ListView)findViewById(R.id.speechdisplay);
        view=(TextView)findViewById(R.id.singleresult);
        Button b=(Button)findViewById(R.id.voicebutton);
      //  Canvas square=(Canvas)findViewById(R.id.entire);
       b.setOnClickListener(this);
    }

    public void onClick(View v){
        Intent i=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        i.putExtra(RecognizerIntent.EXTRA_PROMPT,"Say Something");
        startActivityForResult(i,check);
    }
    @Override

    protected void onActivityResult(int requestCode,int resultCode,Intent data){
       if(requestCode==check && resultCode==RESULT_OK)
       {
          ArrayList<String> results=data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
          // lv.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,results));

           view.setText(results.get(0));
         /*  if((results.get(0).matches("square")))
           {
               //setContentView(v);

           }
           else*/ if((results.get(0).matches("up")))
           {
               v.allocXY(0,-10);
               setContentView(v);

           }
           else if((results.get(0).matches("down")))
           {
               v.allocXY(0,10);
               setContentView(v);

           }
           else if((results.get(0).matches("left")))
           {
               v.allocXY(-10,0);
               setContentView(v);

           }
           else if((results.get(0).matches("right")))
           {
               v.allocXY(10,0);
               setContentView(v);

           }
           else
           {
             //  view.append(" So ideally drawable WILL move for this command..So Yaay!!");

               view.append(":  Please say one of Up, Down, Left or Right");
           }
       }

        super.onActivityResult(requestCode,resultCode,data);

    }


}
