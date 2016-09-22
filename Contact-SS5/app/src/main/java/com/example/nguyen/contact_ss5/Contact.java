package com.example.nguyen.contact_ss5;

import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Nguyen on 9/21/2016.
 */

/*
"FPT Software", "0473007575", "https://www.fpt-software.com"
"EWay", "+84432595450", "https://eway.vn"
"KMS", "+84838486888", "http://www.kms-technology.com"
"BraveBits", " +84463260066", "http://www.bravebits.vn"
"TechKids", "+841653005670", "http://techkids.vn"
 */

public class Contact {
    private String lvTitle;
    private String lvNumberPhone;
    private String lvWebsite;
    public static List<Contact> contactList;

    public Contact(String lvTitle, String lvNumberPhone, String lvWebsite) {
        this.lvTitle = lvTitle;
        this.lvNumberPhone = lvNumberPhone;
        this.lvWebsite = lvWebsite;
    }

    public static List<Contact> getContactList() {
        if(contactList == null){
            contactList = new ArrayList<>();
            contactList.add(new Contact("FPT Software","0473007575","https://www.fpt-software.com"));
            contactList.add(new Contact("EWay","+84432595450","http://www.kms-technology.com"));
            contactList.add(new Contact("BraveBits","+84463260066","http://www.bravebits.vn"));
            contactList.add(new Contact("TechKids","+841653005670","http://techkids.vn"));
        }
        return contactList;
    }

    public void setLvTitle(String lvTitle) {
        this.lvTitle = lvTitle;
    }

    public void setLvNumberPhone(String lvNumberPhone) {
        this.lvNumberPhone = lvNumberPhone;
    }

    public void setLvWebsite(String lvWebsite) {
        this.lvWebsite = lvWebsite;
    }

    public static void setContactList(List<Contact> contactList) {
        Contact.contactList = contactList;
    }

    public String getLvTitle() {
        return lvTitle;
    }

    public String getLvNumberPhone() {
        return lvNumberPhone;
    }

    public String getLvWebsite() {
        return lvWebsite;
    }

    @Override
    public String toString() {
        return lvTitle.toString();
    }
}
