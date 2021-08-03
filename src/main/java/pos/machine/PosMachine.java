package pos.machine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PosMachine {
    public String printReceipt(List<String> barcodes) {
        List<Object> Yes = convertBarcodes(barcodes);
        return null;
    }

    public List<Object> convertBarcodes(List<String> barcodes){
        int Length = 0;
        ItemDataLoader IDL = new ItemDataLoader();
        List<ItemInfo> Items = IDL.loadAllItemInfos();
        List<Object> convertedBarcodes = new ArrayList<>();
        for(ItemInfo Item : Items){
            ItemInfo item1Info = new ItemInfo("ITEM000000", "Coca-Cola", 3);
            Object Converted = {"Barcode" : Item.getBarcode(), "Name" : Item.getName(), "Price" : Item.getPrice(), "Quantity" : 0};
            convertedBarcodes.add(Converted);
        }


        return convertedBarcodes;
    }


}
