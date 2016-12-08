package bkoruznjak.from.hr.funtimes.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by bkoruznjak on 06/12/2016.
 */

public class Meta {

    @SerializedName("hits")
    @Expose
    private Integer hits;
    @SerializedName("time")
    @Expose
    private Integer time;
    @SerializedName("offset")
    @Expose
    private Integer offset;

    /**
     * @return The hits
     */
    public Integer getHits() {
        return hits;
    }

    /**
     * @param hits The hits
     */
    public void setHits(Integer hits) {
        this.hits = hits;
    }

    /**
     * @return The time
     */
    public Integer getTime() {
        return time;
    }

    /**
     * @param time The time
     */
    public void setTime(Integer time) {
        this.time = time;
    }

    /**
     * @return The offset
     */
    public Integer getOffset() {
        return offset;
    }

    /**
     * @param offset The offset
     */
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

}