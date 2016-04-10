package com.assignment.response.model;

import java.io.InputStream;
import java.math.BigInteger;
import org.junit.Assert;
import org.junit.Test;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PositionDetailsJsonTest {

    @Test
    public void test_mappingJson_toPojo() throws Exception {
        final ObjectMapper mapper = new ObjectMapper();
        final InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("sample.json");
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        final PositionDetails[] positionDetails = mapper.readValue(inputStream, PositionDetails[].class);
        Assert.assertEquals(2, positionDetails.length);
        Assert.assertEquals(new BigInteger("377078"), positionDetails[0].getId());
        Assert.assertEquals(new BigInteger("410978"), positionDetails[1].getId());
    }
}
