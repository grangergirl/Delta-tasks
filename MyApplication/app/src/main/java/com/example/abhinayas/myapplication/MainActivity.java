package com.example.abhinayas.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends Activity {

    public static ArrayAdapter<String> adapter;
    public static String uri = "android.resource://com.example.abhinayas.myapplication/drawable/contact";
    public static ContactInformation[] contacts=new ContactInformation[100];
    public static ContactInformation temp=new ContactInformation("Anik Kumar","8939001212","04424493456","arijit@gmail.com","arijitforever.org","Singer",uri);;
    public static int contactIndex=0;
    public static ArrayList<String> values = new ArrayList<String>(Arrays.asList(temp.contactName));;
    public ContactInformation contact;
    public static int flag=0;
    public String searchText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(flag==0)
        {
            contacts[0]= new ContactInformation(temp);
            flag=1;
        }
         ListView listView = (ListView) findViewById(R.id.listView);


        adapter =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,values);
        listView.setAdapter(adapter);
        Bundle data = getIntent().getExtras();
        if (data != null) {
            String s=(String)data.get("info");
            int posUpdate;

               contact = (ContactInformation) data.getParcelable("contact");
           if(s.matches("updation"))
            {
               posUpdate=(int)data.get("index");
                contacts[posUpdate] = new ContactInformation(contact);
                values.remove(posUpdate);
                values.add(posUpdate,contact.contactName);

            }
            else {
            contactIndex++;
                contacts[contactIndex] = new ContactInformation(contact);
                values.add(contact.contactName);
            }
                adapter.setNotifyOnChange(true);

        }






       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent intent = new Intent(MainActivity.this, ShowContact.class);
                    intent.putExtra("contact",contacts[position]);
                   intent.putExtra("index",position);
                    startActivity(intent);


            }
        });

         CheckBox searchOK=(CheckBox) findViewById(R.id.checkBox);

        searchOK.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                CheckBox searchOK=(CheckBox) findViewById(R.id.checkBox);

                if(searchOK.isChecked()==true)
                {
                    ListView listView = (ListView) findViewById(R.id.listView);
                    EditText search = (EditText) findViewById(R.id.search);
                    int i = 0;
                    while(i<=contactIndex) {
                        adapter.setNotifyOnChange(true);
                        listView.getChildAt(i).setBackgroundColor(Color.WHITE);
                        i++;
                    }
                    searchText = search.getText().toString();
                    Toast.makeText(MainActivity.this, "searching for "+searchText, Toast.LENGTH_SHORT).show();
                    i=0;
                    while(i<=contactIndex) {
                        String string=values.get(i);

                        if (string.toLowerCase().indexOf(searchText.toLowerCase()) != -1) {

                            Toast.makeText(MainActivity.this, "Name match found", Toast.LENGTH_SHORT).show();
                            searchOK.setChecked(false);
                            adapter.setNotifyOnChange(true);
                            listView.getChildAt(i).setBackgroundColor(Color.CYAN);
                            adapter.setNotifyOnChange(true);


                        } i++;

                    }
                    i=0;
                    while(i<=contactIndex) {
                        String string=contacts[i].mobile;

                        if (string.matches(searchText)) {

                            Toast.makeText(MainActivity.this, "Mobile match found", Toast.LENGTH_SHORT).show();
                            searchOK.setChecked(false);
                            adapter.setNotifyOnChange(true);
                            listView.getChildAt(i).setBackgroundColor(Color.CYAN);
                            adapter.setNotifyOnChange(true);


                        } i++;

                    }
                    i=0;
                    while(i<=contactIndex) {
                        String string=contacts[i].landline;

                        if (string.matches(searchText)) {

                            Toast.makeText(MainActivity.this, "Landline match found", Toast.LENGTH_SHORT).show();
                            searchOK.setChecked(false);
                            adapter.setNotifyOnChange(true);
                            listView.getChildAt(i).setBackgroundColor(Color.CYAN);
                            adapter.setNotifyOnChange(true);


                        } i++;

                    }


                }
            }
        });

    }

    public void showNextActivity(View v){
        Intent intent = new Intent(this, NewContactPage.class);
        startActivity(intent);
    }


}