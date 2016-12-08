package bkoruznjak.from.hr.funtimes.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by bkoruznjak on 06/12/2016.
 */

public class Headline {

    @SerializedName("main")
    @Expose
    private String main;
    @SerializedName("kicker")
    @Expose
    private String kicker;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("print_headline")
    @Expose
    private String printHeadline;

    /**
     * @return The main
     */
    public String getMain() {
        return main;
    }

    /**
     * @param main The main
     */
    public void setMain(String main) {
        this.main = main;
    }

    /**
     * @return The kicker
     */
    public String getKicker() {
        return kicker;
    }

    /**
     * @param kicker The kicker
     */
    public void setKicker(String kicker) {
        this.kicker = kicker;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrintHeadline() {
        return printHeadline;
    }

    public void setPrintHeadline(String printHeadline) {
        this.printHeadline = printHeadline;
    }
}
