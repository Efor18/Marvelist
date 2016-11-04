
package com.eolalla.marvelist.network.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ComicList {

    @SerializedName("available")
    private int available;
    @SerializedName("collectionURI")
    private String collectionURI;
    @SerializedName("items")
    private List<ComicSummary> items = new ArrayList<ComicSummary>();
    @SerializedName("returned")
    private int returned;

    /**
     * @return The number of total available issues in this list. Will always be greater than or equal to the "returned" value.
     */
    public int getAvailable() {
        return available;
    }

    /**
     * @return The path to the full list of issues in this collection.
     */
    public String getCollectionURI() {
        return collectionURI;
    }

    /**
     * @return The list of returned issues in this collection
     */
    public List<ComicSummary> getComics() {
        return items;
    }

    /**
     * @return The number of issues returned in this collection (up to 20).
     */
    public int getReturned() {
        return returned;
    }
}
