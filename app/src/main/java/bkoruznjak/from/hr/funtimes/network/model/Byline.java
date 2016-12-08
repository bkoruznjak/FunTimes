package bkoruznjak.from.hr.funtimes.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by bkoruznjak on 06/12/2016.
 */

public class Byline {

    @SerializedName("organization")
    @Expose
    private String organization;
    @SerializedName("original")
    @Expose
    private String original;
    @SerializedName("person")
    @Expose
    private List<String> person = null;

    /**
     * @return The organization
     */
    public String getOrganization() {
        return organization;
    }

    /**
     * @param organization The organization
     */
    public void setOrganization(String organization) {
        this.organization = organization;
    }

    /**
     * @return The original
     */
    public String getOriginal() {
        return original;
    }

    /**
     * @param original The original
     */
    public void setOriginal(String original) {
        this.original = original;
    }

    /**
     * @return The person
     */
    public List<String> getPerson() {
        return person;
    }

    /**
     * @param person The person
     */
    public void setPerson(List<String> person) {
        this.person = person;
    }

}
