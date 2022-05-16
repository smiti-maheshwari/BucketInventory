package com.smitimaheshwari.models;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class Inventory {

    private int maxSize;
    private ArrayList<Float> binaryIndexedTree;

    public Inventory(final int maxSize) {
        this.maxSize = maxSize + 1;
        binaryIndexedTree = new ArrayList<>();
        for(int i=0; i<=maxSize; i++) {
            binaryIndexedTree.add((float) 0);
        }
    }

}
