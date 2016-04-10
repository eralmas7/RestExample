package com.assignment.response.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import org.junit.Assert;
import org.junit.Test;

public class PositionDetailsCsvTest {

    private final PositionDetails positionDetails = new PositionDetails();

    @Test
    public void test_WhenGetCsvStringCalledWithValidInput_ThenCallSucceeds() {
        positionDetails.setId(BigInteger.ONE);
        positionDetails.setName("Dummy");
        positionDetails.setType("MyDummyType");
        final GeoPosition geoPosition = new GeoPosition();
        geoPosition.setLatitude(BigDecimal.TEN);
        geoPosition.setLongitude(BigDecimal.ZERO);
        positionDetails.setGeoPosition(geoPosition);
        final String expectedCsv = "1,Dummy,MyDummyType,10,0";
        Assert.assertEquals(expectedCsv, positionDetails.getCsvString());
    }
}
