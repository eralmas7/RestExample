package com.assignment.response.model;

import java.math.BigInteger;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.assignment.utils.Constants;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Position to suggest.
 */
public class PositionDetails {

    @JsonProperty("_id")
    private BigInteger id;
    private String name;
    private String type;
    @JsonProperty("geo_position")
    private GeoPosition geoPosition;

    public BigInteger getId() {
        return id;
    }

    public void setId(final BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public GeoPosition getGeoPosition() {
        return geoPosition;
    }

    public void setGeoPosition(final GeoPosition geoPosition) {
        this.geoPosition = geoPosition;
    }

    public String getCsvString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(id);
        stringBuilder.append(Constants.FIELD_SEPERATOR);
        stringBuilder.append(name);
        stringBuilder.append(Constants.FIELD_SEPERATOR);
        stringBuilder.append(type);
        stringBuilder.append(Constants.FIELD_SEPERATOR);
        stringBuilder.append(geoPosition.getCsvString());
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
    }
}
