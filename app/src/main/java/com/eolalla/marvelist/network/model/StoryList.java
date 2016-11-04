
package com.eolalla.marvelist.network.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class StoryList {

    @SerializedName("available")
    private int available;
    @SerializedName("collectionURI")
    private String collectionURI;
    @SerializedName("items")
    private List<StorySummary> items = new ArrayList<StorySummary>();
    @SerializedName("returned")
    private int returned;

    /**
     * @return The number of total available stories in this list. Will always be greater than or equal to the "returned" value.
     */
    public int getAvailable() {
        return available;
    }

    /**
     * @return The path to the full list of stories in this collection.
     */
    public String getCollectionURI() {
        return collectionURI;
    }

    /**
     * @return The list of returned stories in this collection.
     */
    public List<StorySummary> getStories() {
        return items;
    }

    /**
     * @return The number of stories returned in this collection (up to 20).
     */
    public int getReturned() {
        return returned;
    }
}
