package pos.machine;

import java.util.ArrayList;
import java.util.List;

import static pos.machine.convertedItem.*;

public class PosMachine {
    public String printReceipt(List<String> barcodes) {
        List<Object> convertedBC = convertBarcodes(barcodes);
        countItems(barcodes,convertedBC);
        String receipt = "";
        System.out.print(receipt);
        return receipt;
    }
    public List<Object> convertBarcodes(List<String> barcodes) {
        int Length = 0;
        ItemDataLoader IDL = new ItemDataLoader();
        List<ItemInfo> Items = IDL.loadAllItemInfos();
        List<Object> convertedBarcodes = new ArrayList<>();
        for (ItemInfo Item : Items) {
            convertedItem Converted = new convertedItem(Item.getBarcode(), Item.getName(), Item.getPrice(), 0);
            convertedBarcodes.add(Converted);
        }
        return convertedBarcodes;
    }
    public void countItems(List<String> barcodes, List<Object> convertedItems) {
        for (String BC : barcodes) {
            for (Object CBarC : convertedItems) {
                convertedItem Temp = (convertedItem) CBarC;
                //String Temp = CBarC.getBarcode();
                if (BC == Temp.getBarcode()) {
                    int NewQ = Temp.getQuantity() + 1;
                    Temp.setQuantity(NewQ);
                }
            }
        }
    }

    public int calculateSubtotal(convertedItem Item) {
        return Item.getPrice() * Item.getQuantity();
    }

    public int calculateTotal(List<Object> convertedItems) {
        int Total = 0;
        for (Object CBarC : convertedItems) {
            convertedItem Temp = (convertedItem) CBarC;
            Total += calculateSubtotal((convertedItem) CBarC);
        }
        return Total;
    }

    public String generateReceipt(List<Object> convertedItems) {
        String receipt = "***<store earning no money>Receipt***\n";
        for (Object CBarC : convertedItems) {
            convertedItem Temp = (convertedItem) CBarC;
            receipt += "Name: " + Temp.getName() + ", Quantity: " + Temp.getQuantity() + ", Unit price: " + Temp.getPrice() + " (yuan), Subtotal: " + calculateSubtotal(Temp) + " (yuan)\n";
        }
        receipt += "----------------------\n" + "Total: " + calculateTotal(convertedItems) + " (yuan)\n**********************";
        return receipt;
    }



}
