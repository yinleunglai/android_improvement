package com.lsmore.simplemvpdemo.model;

import com.lsmore.simplemvpdemo.bean.Item;

/**
 * Created by Simon_Li1 on 4/5/2017.
 */

public interface IItemManager {
    public void saveItem(Item item);
    public String getItemById(int id);
}
