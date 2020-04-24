package com.finalproject.carrentalsv3;

public class CarData {
    int Carimage;
    String CarName,CarPrice,CarYear,CarDescription;

    public int getCarimage() {
        return Carimage;
    }

    public void setCarimage(int carimage) {
        this.Carimage = carimage;
    }

    public String getCarName() {
        return CarName;
    }

    public void setCarName(String carName) {
        CarName = carName;
    }

    public String getCarPrice() {
        return CarPrice;
    }

    public void setCarPrice(String CarPrice) {
        CarName = CarPrice;
    }

    public String getCarYear() {
        return CarYear;
    }

    public void setCarYear(String carYear) {
        CarYear = carYear;
    }

    public String getCarDescription() {
        return CarDescription;
    }

    public void setCarDescription(String carDescription) {
        CarDescription = carDescription;
    }

    public CarData(int carimage, String carName, String carPrice, String carYear, String carDescription) {
        this.Carimage = carimage;
        CarName = carName;
        CarPrice = carPrice;
        CarYear = carYear;
        CarDescription = carDescription;
    }


}

