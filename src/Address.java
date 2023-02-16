public class Address {
    private String houseNum;
    private String streetName;
    private String city;
    private String state;
    private int zipCode;

    public Address(String houseNum, String streetName,String city, String state, int zipcode){
        this.houseNum = houseNum;
        this.streetName = streetName;
        this.city = city;
        this.state = state;
        this.zipCode = zipcode;
    }

    public Address(Address a){
        houseNum = a.getHouseNum();
        streetName = a.getStreetName();
        city = a.getCity();
        state = a.getState();
        zipCode = a.getZipCode();
    }

    public Address(String a) {
        houseNum = a.substring(0, a.indexOf(" "));
        a = a.substring(a.indexOf(" ")+1);
        streetName = a.substring(0, a.indexOf(","));
        a = a.substring(a.indexOf(",")+1);
        city = a.substring(1, a.indexOf(","));
        a = a.substring(a.indexOf(",")+2);
        state = a.substring(0, a.indexOf(" "));
        a = a.substring(a.indexOf(" ")+1);
        zipCode = Integer.parseInt(a.substring(0));
    }

    public String getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(String houseNum) {
        this.houseNum = houseNum;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }


    public String toString() {
        return houseNum + " " + streetName + ", " + city + ", " + state + " " + zipCode;
    }
}
