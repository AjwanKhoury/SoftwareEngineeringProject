package com.example.burgermunch.Domain;

public interface IFoodDomain {
    public int getNumberInCart();

    public void setNumberInCart(int numberInCart);

    public String getTitle();

    public void setTitle(String title);

    public String getPic();

    public void setPic(String pic);

    public String getDescription();

    public void setDescription(String description);

    public int getFee();

    public void setFee(int fee);

    public double getStar();

    public void setStar(int star);

    public int getTime();

    public void setTime(int time);

    public int getCalories();

    public void setCalories(int calories);
}
