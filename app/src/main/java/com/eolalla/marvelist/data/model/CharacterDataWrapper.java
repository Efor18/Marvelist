
package com.eolalla.marvelist.data.model;

import com.google.gson.annotations.SerializedName;

public class CharacterDataWrapper {

    @SerializedName("code")
    private int code;
    @SerializedName("status")
    private String status;
    @SerializedName("copyright")
    private String copyright;
    @SerializedName("attributionText")
    private String attributionText;
    @SerializedName("attributionHTML")
    private String attributionHTML;
    @SerializedName("etag")
    private String etag;
    @SerializedName("data")
    private CharacterDataContainer characterDataContainer;

    /**
     * @return The HTTP status code of the returned result.
     */
    public int getCode() {
        return code;
    }

    /**
     * @return A string description of the call status.
     */
    public String getStatus() {
        return status;
    }

    /**
     * @return The copyright notice for the returned result.
     */
    public String getCopyright() {
        return copyright;
    }

    /**
     * @return The attribution notice for this result.
     */
    public String getAttributionText() {
        return attributionText;
    }

    /**
     * @return An HTML representation of the attribution notice for this result.
     */
    public String getAttributionHTML() {
        return attributionHTML;
    }

    /**
     * @return A digest value of the content returned by the call.
     */
    public String getEtag() {
        return etag;
    }

    /**
     * @return The results returned by the call.
     */
    public CharacterDataContainer getData() {
        return characterDataContainer;
    }
}
