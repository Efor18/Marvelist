
package com.eolalla.marvelist.data.model;

import com.google.gson.annotations.SerializedName;

public class Url {

    @SerializedName("type")
    private String type;
    @SerializedName("url")
    private String url;

    /**
     * @return A text identifier for the URL.
     */
    public String getType() {
        return type;
    }

    /**
     * @return A full URL (including scheme, domain, and path).
     */
    public String getUrl() {
        return url;
    }
}
