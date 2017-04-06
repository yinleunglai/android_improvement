package com.lsmore.simplemvpdemo.presenter;

import com.lsmore.simplemvpdemo.bean.Item;
import com.lsmore.simplemvpdemo.model.IItemManager;
import com.lsmore.simplemvpdemo.model.ItemManager;
import com.lsmore.simplemvpdemo.view.IView;

/**
 * Created by Simon_Li1 on 4/5/2017.
 */

public class Presenter {
    IView iView;
    IItemManager itemManager;

    public Presenter(IView view){
        this.iView = view;
        itemManager = new ItemManager();
    }

    public void saveItem(){
        Item item = new Item();
        item.setId(1);
        item.setName(iView.getItemName());
        itemManager.saveItem(item);
    }

    public void showItem(){
        String name = itemManager.getItemById(1);
        iView.showItemName(name);
    }

}
