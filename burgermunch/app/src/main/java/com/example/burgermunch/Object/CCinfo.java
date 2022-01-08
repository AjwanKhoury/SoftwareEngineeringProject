package com.example.burgermunch.Object;

public class CCinfo implements ICCinfo {

    private String fullName;
    private String phoneNum;
    private String ccNum;
    private String expDate;
    private String cvv;
    private String idNum;

    public CCinfo(){
        fullName = "";
        phoneNum = "";
        ccNum = "";
        expDate = "";
        cvv = "";
        idNum = "";
    }
    public CCinfo(String fn,String phone,String ccnum,String expdate,String cvv,String id){
        this.fullName=fn;
        this.phoneNum=phone;
        this.ccNum=ccnum;
        this.expDate=expdate;
        this.cvv=cvv;
        this.idNum=id;
    }

    @Override
    public String getName() {
        return fullName;
    }

    @Override
    public String getPhoneNum() {
        return phoneNum;
    }

    @Override
    public String getCcNum() {
        return ccNum;
    }

    @Override
    public String getExpDate() {
        return expDate;
    }

    @Override
    public String getCvv() {
        return cvv;
    }

    @Override
    public String getIdNum() {
        return idNum;
    }
}
