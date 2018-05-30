package com.example.marija.blogtask.events;

import java.util.List;

/**
 * Created by Marija on 30/5/2018.
 */

public class ItemsEvents {
    private List<ItemEvents> itemsEvents;

    public ItemsEvents(List<ItemEvents> itemsEvents) {
        this.itemsEvents = itemsEvents;
    }

    public List<ItemEvents> getItemsEvents() {
        return itemsEvents;
    }

    public void setItemsEvents(List<ItemEvents> itemsEvents) {
        this.itemsEvents = itemsEvents;
    }
}
