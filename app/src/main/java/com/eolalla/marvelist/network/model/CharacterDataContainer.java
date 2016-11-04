
package com.eolalla.marvelist.network.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CharacterDataContainer {

    @SerializedName("offset")
    private int offset;
    @SerializedName("limit")
    private int limit;
    @SerializedName("total")
    private int total;
    @SerializedName("count")
    private int count;
    @SerializedName("results")
    private List<Character> characters = new ArrayList<Character>();

    /**
     * @return The requested offset (number of skipped results) of the call.
     */
    public int getOffset() {
        return offset;
    }

    /**
     * @return The requested result limit.
     */
    public int getLimit() {
        return limit;
    }

    /**
     * @return The total number of resources available given the current filter set.
     */
    public int getTotal() {
        return total;
    }

    /**
     * @return The total number of results returned by this call.
     */
    public int getCount() {
        return count;
    }

    /**
     * @return The list of characters returned by the call
     */
    public List<Character> getCharacters() {
        return characters;
    }
}
