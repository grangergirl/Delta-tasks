package com.example.abhinayas.myapplication;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;


public class NewContactPage extends AppCompatActivity {
  public String uri="android.resource://com.example.abhinayas.myapplication/drawable/contact";

    public ContactInformation updateContact;
    public int pos;
    public Bundle data;
    public String s="what";
    public ImageView upload;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_contact);
        upload=(ImageView)findViewById(R.id.imageView);
        Button create=(Button)findViewById(R.id.create);

       upload.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent pickPhoto = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(pickPhoto , 1);//one can be replaced with any action code
            }
        });
       data = getIntent().getExtras();
        if (data != null) {
            EditText name=(EditText) findViewById(R.id.editText);
            EditText mobile=(EditText) findViewById(R.id.editText2);
            EditText land=(EditText) findViewById(R.id.editText3);
            EditText email=(EditText) findViewById(R.id.editText4);
            EditText website=(EditText) findViewById(R.id.editText5);
            EditText misc=(EditText) findViewById(R.id.editText6);
        updateContact=data.getParcelable("contact");
            name.setText(updateContact.contactName);
            mobile.setText(updateContact.mobile);
            land.setText(updateContact.landline);
            email.setText(updateContact.email);
            website.setText(updateContact.website);
            misc.setText(updateContact.comments);
            String defaultUri="android.resource://com.example.abhinayas.myapplication/drawable/contact";

            upload.setImageURI(Uri.parse(defaultUri));
            defaultUri=updateContact.uri;
            upload.setImageURI(null);
            upload.setImageURI(Uri.parse(defaultUri));

            pos=(int)data.get("index");
           s=(String)data.get("info");
       }



            create.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    EditText name=(EditText) findViewById(R.id.editText);
                     EditText mobile=(EditText) findViewById(R.id.editText2);
                   EditText land=(EditText) findViewById(R.id.editText3);
                    EditText email=(EditText) findViewById(R.id.editText4);
                     EditText website=(EditText) findViewById(R.id.editText5);
                     EditText misc=(EditText) findViewById(R.id.editText6);
                    String tName,tMob,tLand,tEmail,tWeb,tMisc;

                    tName = name.getText().toString();

                    tMob = mobile.getText().toString();
                    tLand = land.getText().toString();
                    tEmail = email.getText().toString();
                    tWeb = website.getText().toString();
                    tMisc = misc.getText().toString();
                    Bundle bundle = new Bundle();
                    Intent intent = new Intent(NewContactPage.this, MainActivity.class);
                    intent.putExtra("contact", new ContactInformation(tName, tMob, tLand, tEmail, tWeb, tMisc, uri));
                    if(s.matches("updation"))
                    {
                        Toast.makeText(NewContactPage.this,"Updating",Toast.LENGTH_SHORT).show();
                        intent.putExtra("index",pos);
                        intent.putExtra("info","updation");

                    }
                    else
                    {
                        Toast.makeText(NewContactPage.this,"Adding new",Toast.LENGTH_SHORT).show();
                        intent.putExtra("info","adding");


                    }
                    startActivity(intent);
                }
            });


    }
  protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        upload=(ImageView)findViewById(R.id.imageView);

        switch(requestCode) {
            case 0:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();
                    upload.setImageURI(selectedImage);
                    uri=selectedImage.toString();

                }

                break;
            case 1:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();
                    upload.setImageURI(selectedImage);
                   uri=selectedImage.toString();


                }
                break;
        }
    }

}

