package bkoruznjak.from.hr.funtimes.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by bkoruznjak on 06/12/2016.
 */

public class Keywords {

    @SerializedName("rank")
    @Expose
    private String rank;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("value")
    @Expose
    private String value;

    /**
     * @return The rank
     */
    public String getRank() {
        return rank;
    }

    /**
     * @param rank The rank
     */
    public void setRank(String rank) {
        this.rank = rank;
    }

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value The value
     */
    public void setValue(String value) {
        this.value = value;
    }

}
