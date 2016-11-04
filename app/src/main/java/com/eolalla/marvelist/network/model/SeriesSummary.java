
package com.eolalla.marvelist.network.model;

import com.google.gson.annotations.SerializedName;

public class SeriesSummary {

    @SerializedName("resourceURI")
    private String resourceURI;
    @SerializedName("name")
    private String name;

    /**
     * @return The path to the individual series resource.
     */
    public String getResourceURI() {
        return resourceURI;
    }

    /**
     * @return The canonical name of the series.
     */
    public String getName() {
        return name;
    }
}
