public class TovarAndPrice {
    String tovarName;
    double tovarPrice;

    public TovarAndPrice (String tovarName, double tovarPrice){
        this.tovarName = tovarName;
        this.tovarPrice = tovarPrice;
    }
    public String getTovarName(){
        return tovarName;
    }
    public double getTovarPrice(){
        return tovarPrice;
    }
}
