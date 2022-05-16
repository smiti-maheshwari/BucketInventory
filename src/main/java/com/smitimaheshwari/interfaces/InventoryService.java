package com.smitimaheshwari.interfaces;

import com.smitimaheshwari.exceptions.InventoryBucketDoesNotExist;
import com.smitimaheshwari.impl.InventoryServiceImpl;
import com.smitimaheshwari.models.Inventory;

import static com.smitimaheshwari.constants.Constants.BUCKET_DOES_NOT_EXIST;

public class InventoryService implements InventoryServiceImpl {

    private Inventory inventory;

    public InventoryService(final Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public void addSupply(int bucket, float delta) {
        if(bucket < 0 || bucket >= inventory.getMaxSize()) {
            throw new InventoryBucketDoesNotExist(BUCKET_DOES_NOT_EXIST);
        }
        update(bucket + 1, delta);
    }

    @Override
    public void addDemand(int bucket, float delta) {
        if(bucket < 0 || bucket >= inventory.getMaxSize()) {
            throw new InventoryBucketDoesNotExist(BUCKET_DOES_NOT_EXIST);
        }
        update(bucket + 1, -delta);
    }

    @Override
    public float getInventory(int bucket) {
        if(bucket < 0 || bucket >= inventory.getMaxSize()) {
            throw new InventoryBucketDoesNotExist(BUCKET_DOES_NOT_EXIST);
        }
        return sum(bucket + 1);
    }

    private void update(int index, float value){
        for(; index < inventory.getMaxSize(); index += (index&-index)){
            inventory.getBinaryIndexedTree().set(index, inventory.getBinaryIndexedTree().get(index) + value) ;
        }
    }

    private float sum(int index){
        float value = 0;
        for(; index > 0; index -= (index&-index)) {
            value += inventory.getBinaryIndexedTree().get(index);
        }
        return value;
    }
}

