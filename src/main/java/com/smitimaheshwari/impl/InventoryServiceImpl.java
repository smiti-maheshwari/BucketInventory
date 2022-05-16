package com.smitimaheshwari.impl;

public interface InventoryServiceImpl {

    void addSupply(int bucket, float delta);

    void addDemand(int bucket, float delta);

    float getInventory(int bucket);
}
