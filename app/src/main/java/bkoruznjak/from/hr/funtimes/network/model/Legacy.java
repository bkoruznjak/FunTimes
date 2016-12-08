package bkoruznjak.from.hr.funtimes.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by bkoruznjak on 06/12/2016.
 */

public class Legacy {

    @SerializedName("wide")
    @Expose
    private String wide;
    @SerializedName("wideheight")
    @Expose
    private String wideheight;
    @SerializedName("widewidth")
    @Expose
    private String widewidth;
    @SerializedName("xlargewidth")
    @Expose
    private String xlargewidth;
    @SerializedName("xlarge")
    @Expose
    private String xlarge;
    @SerializedName("xlargeheight")
    @Expose
    private String xlargeheight;
    @SerializedName("thumbnailheight")
    @Expose
    private String thumbnailheight;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("thumbnailwidth")
    @Expose
    private String thumbnailwidth;

    /**
     * @return The wide
     */
    public String getWide() {
        return wide;
    }

    /**
     * @param wide The wide
     */
    public void setWide(String wide) {
        this.wide = wide;
    }

    /**
     * @return The wideheight
     */
    public String getWideheight() {
        return wideheight;
    }

    /**
     * @param wideheight The wideheight
     */
    public void setWideheight(String wideheight) {
        this.wideheight = wideheight;
    }

    /**
     * @return The widewidth
     */
    public String getWidewidth() {
        return widewidth;
    }

    /**
     * @param widewidth The widewidth
     */
    public void setWidewidth(String widewidth) {
        this.widewidth = widewidth;
    }

    /**
     * @return The xlargewidth
     */
    public String getXlargewidth() {
        return xlargewidth;
    }

    /**
     * @param xlargewidth The xlargewidth
     */
    public void setXlargewidth(String xlargewidth) {
        this.xlargewidth = xlargewidth;
    }

    /**
     * @return The xlarge
     */
    public String getXlarge() {
        return xlarge;
    }

    /**
     * @param xlarge The xlarge
     */
    public void setXlarge(String xlarge) {
        this.xlarge = xlarge;
    }

    /**
     * @return The xlargeheight
     */
    public String getXlargeheight() {
        return xlargeheight;
    }

    /**
     * @param xlargeheight The xlargeheight
     */
    public void setXlargeheight(String xlargeheight) {
        this.xlargeheight = xlargeheight;
    }

    /**
     * @return The thumbnailheight
     */
    public String getThumbnailheight() {
        return thumbnailheight;
    }

    /**
     * @param thumbnailheight The thumbnailheight
     */
    public void setThumbnailheight(String thumbnailheight) {
        this.thumbnailheight = thumbnailheight;
    }

    /**
     * @return The thumbnail
     */
    public String getThumbnail() {
        return thumbnail;
    }

    /**
     * @param thumbnail The thumbnail
     */
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    /**
     * @return The thumbnailwidth
     */
    public String getThumbnailwidth() {
        return thumbnailwidth;
    }

    /**
     * @param thumbnailwidth The thumbnailwidth
     */
    public void setThumbnailwidth(String thumbnailwidth) {
        this.thumbnailwidth = thumbnailwidth;
    }

}
