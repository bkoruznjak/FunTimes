package bkoruznjak.from.hr.funtimes.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by bkoruznjak on 06/12/2016.
 */

public class Response {

    @SerializedName("docs")
    @Expose
    private List<Doc> docs = null;
    @SerializedName("meta")
    @Expose
    private Meta meta;

    /**
     * @return The docs
     */
    public List<Doc> getDocs() {
        return docs;
    }

    /**
     * @param docs The docs
     */
    public void setDocs(List<Doc> docs) {
        this.docs = docs;
    }

    /**
     * @return The meta
     */
    public Meta getMeta() {
        return meta;
    }

    /**
     * @param meta The meta
     */
    public void setMeta(Meta meta) {
        this.meta = meta;
    }

}
