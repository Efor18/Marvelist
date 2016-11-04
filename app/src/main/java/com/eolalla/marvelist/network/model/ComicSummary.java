
package com.eolalla.marvelist.network.model;

import com.google.gson.annotations.SerializedName;

public class ComicSummary {

    @SerializedName("resourceURI")
    private String resourceURI;
    @SerializedName("name")
    private String name;

    /**
     * @return The path to the individual comic resource.
     */
    public String getResourceURI() {
        return resourceURI;
    }

    /**
     * @return The canonical name of the comic.
     */
    public String getName() {
        return name;
    }
}
