package com.smitimaheshwari;

import com.smitimaheshwari.interfaces.InventoryService;
import com.smitimaheshwari.models.Inventory;

public class ManageInventory {

    public static void main(String[] args) {
        final Inventory inventory = new Inventory(10);
        final InventoryService inventoryService = new InventoryService(inventory);
        inventoryService.addSupply(2, 50);
        for(int i=0; i<10; i++) {
            System.out.println(i + " " + inventoryService.getInventory(i));
        }
        inventoryService.addDemand(3, 25);
        for(int i=0; i<10; i++) {
            System.out.println(i + " " + inventoryService.getInventory(i));
        }
        inventoryService.addDemand(2, 30);
        for(int i=0; i<10; i++) {
            System.out.println(i + " " + inventoryService.getInventory(i));
        }
        inventoryService.addDemand(11, 30);
    }
}
