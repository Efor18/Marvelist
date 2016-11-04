
package com.eolalla.marvelist.network.model;

import com.google.gson.annotations.SerializedName;

public class EventSummary {

    @SerializedName("resourceURI")
    private String resourceURI;
    @SerializedName("name")
    private String name;

    /**
     * @return The path to the individual event resource.
     */
    public String getResourceURI() {
        return resourceURI;
    }

    /**
     * @return The name of the event.
     */
    public String getName() {
        return name;
    }
}
