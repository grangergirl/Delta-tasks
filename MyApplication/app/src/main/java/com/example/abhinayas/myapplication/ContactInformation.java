package com.example.abhinayas.myapplication;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ABHINAYA  S on 29-06-2016.
 */

public class ContactInformation implements Parcelable {
    public String contactName;
    public String mobile;
    public String landline;
    public String email;
    public String website;
    public String comments;
   public String uri;

    // Constructor

    public ContactInformation(String contactName, String mobile, String landline, String email, String website, String comments,String uri) {
        this.contactName = contactName;
        this.mobile = mobile;
        this.landline = landline;
        this.email = email;
        this.website = website;
        this.comments = comments;
       this.uri=uri;
    }
    public ContactInformation(ContactInformation c) {
        this.contactName =c.contactName;
        this.mobile = c.mobile;
        this.landline = c.landline;
        this.email = c.email;
        this.website = c.website;
        this.comments = c.comments;
       this.uri=c.uri;
    }
    // Getter and setter methods


    // Parcelling part
    public ContactInformation(Parcel in) {
        String[] data = new String[7];
        in.readStringArray(data);

        this.contactName = data[0];
        this.mobile = data[1];
        this.landline = data[2];
        this.email = data[3];
        this.website = data[4];
        this.comments = data[5];
        this.uri=data[6];

    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[] {this.contactName,this.mobile,this.landline,this.email,
                this.website,
                this.comments,
        this.uri});
    }
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public ContactInformation createFromParcel(Parcel in) {
            return new ContactInformation(in);
        }

        public ContactInformation[] newArray(int size) {
            return new ContactInformation[size];
        }
    };
}