package pos.machine;

public class convertedItem {
    String Barcode;
    String Name;
    int Price;
    int Quantity = 0;
    public convertedItem (String Barcode, String Name, int Price, int Quantity){
        this.Barcode = Barcode;
        this.Name = Name;
        this.Price = Price;
        this.Quantity = Quantity;
    }

    public String getBarcode(){
        return Barcode;
    }
    public String getName(){
        return Name;
    }

    public int getPrice() {
        return Price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setBarcode(String barcode) {
        Barcode = barcode;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }
}
