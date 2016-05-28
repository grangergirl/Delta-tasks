package com.example.abhinayas.smartbutton;

import android.content.res.Configuration;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    static public int count=0,f=0;
    static public int bg=Color.GREEN;
    private RelativeLayout bgcolor;
    private TextView clickdisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout bgcolor = new RelativeLayout(this);
        
        setContentView(R.layout.activity_main);

        TextView clickdisplay=(TextView)findViewById(R.id.clickdisplay);
        clickdisplay.setText("Number of clicks now is "+count);
        bgcolor=(RelativeLayout)findViewById(R.id.bgcolor);
        bgcolor.setBackgroundColor(bg);








    Button clickbutton = (Button) findViewById(R.id.clickbutton);

        clickbutton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        TextView clickdisplay=(TextView)findViewById(R.id.clickdisplay);

                            count++;
                            clickdisplay.setText("Number of clicks now is "+count);
                        RelativeLayout bgcolor=(RelativeLayout)findViewById(R.id.bgcolor);
                            if(bg==Color.GREEN) {
                                bgcolor.setBackgroundColor(Color.BLUE);
                                bg = Color.BLUE;
                            }
                            else if(bg==Color.BLUE) {
                                bgcolor.setBackgroundColor(Color.CYAN);
                                bg = Color.CYAN;

                            }
                        else if(bg==Color.CYAN) {
                            bgcolor.setBackgroundColor(Color.YELLOW);
                            bg = Color.YELLOW;

                        }
                        else if(bg==Color.YELLOW) {
                            bgcolor.setBackgroundColor(Color.MAGENTA);
                            bg = Color.MAGENTA;

                        }
                        else if(bg==Color.MAGENTA){
                            bgcolor.setBackgroundColor(Color.DKGRAY);
                            bg = Color.DKGRAY;

                        }
                        else {
                                bgcolor.setBackgroundColor(Color.GREEN);
                                bg = Color.GREEN;

                            }


                    }
                }
        );
        Button resetbutton=(Button) findViewById(R.id.resetbutton);
        resetbutton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        TextView clickdisplay=(TextView)findViewById(R.id.clickdisplay);

                        count=0;
                        clickdisplay.setText("Number of clicks now is "+count);




                    }
                }
        );


    }




}
