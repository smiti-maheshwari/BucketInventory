package com.smitimaheshwari.exceptions;

public class InventoryBucketDoesNotExist extends RuntimeException {

    public InventoryBucketDoesNotExist(final String message) {
        super(message);
    }
}
