package com.example.abhinayas.myapplication;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class ShowContact extends AppCompatActivity {
    String defaultUri="android.resource://com.example.abhinayas.myapplication/drawable/contact";
    public ContactInformation contact;
    public int pos;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_details);
        ImageView img=(ImageView)findViewById(R.id.imageView);
        Intent intent=this.getIntent();
        Bundle data = intent.getExtras();
        pos=(int)data.get("index");
        contact = data.getParcelable("contact");
        TextView name=(TextView)findViewById(R.id.name);
        TextView mobile=(TextView)findViewById(R.id.mobile);
        TextView land=(TextView)findViewById(R.id.land);
        TextView email=(TextView)findViewById(R.id.email);
        TextView website=(TextView)findViewById(R.id.website);
        TextView misc=(TextView)findViewById(R.id.misc);
        name.setText(contact.contactName);
        mobile.setText(contact.mobile);
        land.setText(contact.landline);
        email.setText(contact.email);
        website.setText(contact.website);
        misc.setText(contact.comments);
        img.setImageURI(Uri.parse(defaultUri));
        defaultUri=contact.uri;
        img.setImageURI(null);
       img.setImageURI(Uri.parse(defaultUri));




        Button button=(Button)findViewById(R.id.button);

            button.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    Intent intent = new Intent(ShowContact.this, NewContactPage.class);
                    intent.putExtra("contact", new ContactInformation(contact.contactName,contact.mobile,contact.landline,contact.email,contact.website,contact.comments,contact.uri));
                    intent.putExtra("index",pos);
                   intent.putExtra("info","updation");
                   startActivity(intent);
                }
            });




    }
}
