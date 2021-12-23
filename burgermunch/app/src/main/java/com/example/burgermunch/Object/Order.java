package com.example.burgermunch.Object;

public class Order implements IOrder{
    private String Date;
    private String Status;
    private String CusPhone;
    private String OrderID;

    public Order(){
        Date ="";
        Status ="";
        CusPhone ="";
        OrderID ="";
    }

    public Order(String Da,String St, String Cus, String Or){
        this.Date= Da;
        this.Status= St;
        this.CusPhone= Cus;
        this.OrderID= Or;
    }

    @Override
    public String getDate() {
        return Date;
    }
    public void setDate(String Sd){
        this.Date=Sd;
    }

    @Override
    public String getStatus() {
        return Status;
    }
    public void setStatus(String status) {
        this.Status = status;
    }

    @Override
    public String getOrderID() {
        return OrderID;
    }
    public void setOrderID(String orderID) {
        this.OrderID = orderID;
    }

    @Override
    public String getCusPhone() {
        return CusPhone;
    }
    public void setCusPhone(String cusPhone) {
        this.CusPhone = cusPhone;
    }

}
