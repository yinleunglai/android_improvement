package com.lsmore.simplemvpdemo.model;

import com.lsmore.simplemvpdemo.bean.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Simon_Li1 on 4/5/2017.
 */

public class ItemManager implements IItemManager {
    Item item;
    List<Item> itemList = new ArrayList<>();

    @Override
    public void saveItem(Item item) {
        this.item = item;
        itemList.add(this.item);
    }

    @Override
    public String getItemById(int id) {
        for (Item item:itemList) {
            if (item.getId() == id){
                return item.getName();
            }
        }
        return "no item";
    }
}
