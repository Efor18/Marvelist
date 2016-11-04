
package com.eolalla.marvelist.network.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class SeriesList {

    @SerializedName("available")
    private int available;
    @SerializedName("collectionURI")
    private String collectionURI;
    @SerializedName("items")
    private List<SeriesSummary> items = new ArrayList<SeriesSummary>();
    @SerializedName("returned")
    private int returned;

    /**
     * @return The number of total available series in this list. Will always be greater than or equal to the "returned" value.
     */
    public int getAvailable() {
        return available;
    }

    /**
     * @return The path to the full list of series in this collection.
     */
    public String getCollectionURI() {
        return collectionURI;
    }

    /**
     * @return The list of returned series in this collection.
     */
    public List<SeriesSummary> getSeries() {
        return items;
    }

    /**
     * @return The number of series returned in this collection (up to 20).
     */
    public int getReturned() {
        return returned;
    }
}
