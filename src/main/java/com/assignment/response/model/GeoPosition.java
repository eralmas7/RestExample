package com.assignment.response.model;

import java.math.BigDecimal;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.assignment.utils.Constants;

/**
 * Latitude and Longitude representation.
 */
public class GeoPosition {

    public BigDecimal latitude;
    public BigDecimal longitude;

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(final BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(final BigDecimal latitude) {
        this.latitude = latitude;
    }

    public String getCsvString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(latitude);
        stringBuilder.append(Constants.FIELD_SEPERATOR);
        stringBuilder.append(longitude);
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
    }
}
