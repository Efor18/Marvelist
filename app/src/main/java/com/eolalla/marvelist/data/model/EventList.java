
package com.eolalla.marvelist.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class EventList {

    @SerializedName("available")
    private int available;
    @SerializedName("collectionURI")
    private String collectionURI;
    @SerializedName("items")
    private List<EventSummary> items = new ArrayList<EventSummary>();
    @SerializedName("returned")
    private int returned;

    /**
     * @return The number of total available events in this list. Will always be greater than or equal to the "returned" value.
     */
    public int getAvailable() {
        return available;
    }

    /**
     * @return The path to the full list of events in this collection.
     */
    public String getCollectionURI() {
        return collectionURI;
    }

    /**
     * @return The list of returned events in this collection.
     */
    public List<EventSummary> getEvents() {
        return items;
    }

    /**
     * @return The number of events returned in this collection (up to 20).
     */
    public int getReturned() {
        return returned;
    }
}
