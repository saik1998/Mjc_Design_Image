package com.firstapp.mjc_design_image;

public class ModelClass {
    String mobilenymber,address,pincode,postelcode;
    String startdate,enddate,content;

    public ModelClass(String mobilenymber, String address,
                      String pincode, String postelcode, String startdate, String enddate, String content) {
        this.mobilenymber = mobilenymber;
        this.address = address;
        this.pincode = pincode;
        this.postelcode = postelcode;
        this.startdate = startdate;
        this.enddate = enddate;
        this.content = content;
    }


    public String getMobilenymber() {
        return mobilenymber;
    }

    public void setMobilenymber(String mobilenymber) {
        this.mobilenymber = mobilenymber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getPostelcode() {
        return postelcode;
    }

    public void setPostelcode(String postelcode) {
        this.postelcode = postelcode;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
