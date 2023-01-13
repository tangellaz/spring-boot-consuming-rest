package restproject;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.TreeSet;

public class EHR2014DTO {
    private String region;
    @JsonProperty("pct_hospitals_mu")
    private Float pctMU;

    public EHR2014DTO(float pctMU, String region) {
        this.pctMU = pctMU;
        this.region = region;
    }

    public Float getPctMU() {
        return this.pctMU;
    }
    public String getRegion() { return this.region; }


    public void setPctMU(Float pctMU) {
        this.pctMU = pctMU;
    }
    public void setRegion(String region) {
        this.region = region;
    }


    @Override
    public String toString() {
        return  "state=" + region +
                ", value=" + pctMU +
                "\n";
    }
}