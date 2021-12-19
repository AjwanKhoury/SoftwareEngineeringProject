package com.example.burgermunch.Object;
import com.example.burgermunch.Interface.ICustomer;

import java.util.HashMap;
import java.util.regex.Pattern;

public class Customer implements ICustomer {
    private String email;
    private String password;
    private String full_name;
    private String phone_number;
    private String address;

    public Customer() {
        full_name = "";
        address = "";
        phone_number = "";
        this.email = "";
        this.password= "";
    }

    public Customer(String em, String pass) {
        full_name = "";
        address = "";
        phone_number = "";
        this.email = em;
        this.password = pass;
    }

    public Customer(String fn, String add, String pn, String em,String pass) {
        this.full_name = fn;
        this.address = add;
        this.phone_number = pn;
        this.email = em;
        this.password = pass;
    }

    @Override
    public String getFullName() {
        return full_name;
    }
    public void setFullName(String fn){
        this.full_name=fn;
    }


    @Override
    public String getAddress() {
        return address;
    }
    public void setAddress(String a){
        this.address=a;
    }

    @Override
    public String getPhoneNumber() {
        return this.phone_number;
    }
    public void setPhoneNumber(String pn) {
        this.phone_number = pn;
    }

    @Override
    public String getEmail() {
        return email;
    }
    public void setEmail (String e) {
        this.email = e;
    }

    @Override
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String p) {
        this.password = p;
    }

    public HashMap<String,Object> toMap () {
        HashMap<String, Object> Customer = new HashMap<>();
        Customer.put("full_name", this.full_name);
        Customer.put("address",this.address);
        Customer.put("phone_number", this.phone_number);
        Customer.put("email", this.email);
        Customer.put("password", this.password);
        return Customer;
    }

    static public Customer toObject (HashMap<String,Object> hash){
        String fn = hash.get("full_name").toString();
        String ad = hash.get("address").toString();
        String pn = hash.get("phone_number").toString();
        String em = hash.get("email").toString();
        String p = hash.get("password").toString();
        return new Customer(fn, ad, pn, em,p);
    }

    @Override
    public int isValid() {
        if(this == null)
            return 0;
        if(getFullName().length() < 2 || !onlyAlphabetic(getFullName()))
            return 1;
        if(getPhoneNumber().length() != 10)
            return 2;
        if(!isEmail(getEmail()))
            return 3;
        if (getPassword().length() < 6)
            return 4;
        if(getAddress()==null)
            return 5;
        return -1;
    }

    //Full Name
    private static boolean onlyAlphabetic(String s) {
        char[] chars = s.toCharArray();
        for(char c : chars){
            if(Character.isDigit(c))
                return false;
        }
        return true;
    }

    private static boolean isEmail(String s) {
        String email = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        Pattern pat = Pattern.compile(email);
        if (s == null)
            return false;
        return pat.matcher(s).matches();
    }
}