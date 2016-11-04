
package com.eolalla.marvelist.network.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Character {

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("modified")
    private String modified;
    @SerializedName("thumbnail")
    private Image thumbnail;
    @SerializedName("resourceURI")
    private String resourceURI;
    @SerializedName("comics")
    private ComicList comics;
    @SerializedName("series")
    private SeriesList series;
    @SerializedName("stories")
    private StoryList stories;
    @SerializedName("events")
    private EventList events;
    @SerializedName("urls")
    private List<Url> urls = new ArrayList<Url>();

    /**
     * @return The unique ID of the character resource.
     */
    public int getId() {
        return id;
    }

    /**
     * @return The name of the character.
     */
    public String getName() {
        return name;
    }

    /**
     * @return A short bio or description of the character.
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return The date the resource was most recently modified.
     */
    public String getModified() {
        return modified;
    }

    /**
     * @return The representative image for this character.
     */
    public Image getThumbnail() {
        return thumbnail;
    }

    /**
     * @return The canonical URL identifier for this resource.
     */
    public String getResourceURI() {
        return resourceURI;
    }

    /**
     * @return A resource list containing comics which feature this character.
     */
    public ComicList getComicList() {
        return comics;
    }

    /**
     * @return A resource list of series in which this character appears.
     */
    public SeriesList getSeriesList() {
        return series;
    }

    /**
     * @return A resource list of stories in which this character appears.
     */
    public StoryList getStoryList() {
        return stories;
    }

    /**
     * @return A resource list of events in which this character appears.
     */
    public EventList getEventList() {
        return events;
    }

    /**
     * @return A set of public web site URLs for the resource.
     */
    public List<Url> getUrls() {
        return urls;
    }

}
