
package com.eolalla.marvelist.network.model;

import com.google.gson.annotations.SerializedName;

public class Image {

    public static final String LANDSCAPE_INCREDIBLE = "/landscape_incredible.jpg";

    @SerializedName("path")
    private String path;
    @SerializedName("extension")
    private String extension;

    /**
     * @return The directory path of to the image.
     */
    public String getPath() {
        return path;
    }

    /**
     * @return The file extension for the image.
     */
    public String getExtension() {
        return extension;
    }
}
