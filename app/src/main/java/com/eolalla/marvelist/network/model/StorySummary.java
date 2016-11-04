
package com.eolalla.marvelist.network.model;

import com.google.gson.annotations.SerializedName;

public class StorySummary {

    @SerializedName("resourceURI")
    private String resourceURI;
    @SerializedName("name")
    private String name;
    @SerializedName("type")
    private String type;

    /**
     * @return The path to the individual story resource.
     */
    public String getResourceURI() {
        return resourceURI;
    }

    /**
     * @return The canonical name of the story.
     */
    public String getName() {
        return name;
    }


    /**
     * @return The type of the story (interior or cover).
     */
    public String getType() {
        return type;
    }
}
