package com.assignment.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.assignment.exception.InvalidDataException;
import com.assignment.request.handler.Invoker;
import com.assignment.response.model.PositionDetails;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:com.assignment.position.suggestor.xml"})
public class IntegrationTest {

    @Autowired
    private Invoker invoker;

    @Test
    public void test_WhenInvokerInvokesWithExistingInput_ThenMethodReturnsValuesSuccessfully() {
        String[] userInput = new String[] {"Berlin"};
        List<PositionDetails> positionDetailsList = invoker.invoke(userInput);
        assertEquals(8, positionDetailsList.size());
        positionDetailsList.stream().forEach(positionDetails -> {
            assertNotNull(positionDetails.getGeoPosition().getLatitude());
            assertNotNull(positionDetails.getGeoPosition().getLongitude());
            assertNotNull(positionDetails.getId());
            assertNotNull(positionDetails.getName());
            assertNotNull(positionDetails.getType());
            assertTrue(positionDetails.getName().contains(userInput[0]));
        });
    }

    @Test
    public void test_WhenInvokerInvokesWithNonExistingInput_ThenMethodReturnsSuccessfullyWithEmptyValue() {
        String[] userInput = new String[] {"Berlin11"};
        List<PositionDetails> positionDetailsList = invoker.invoke(userInput);
        assertEquals(0, positionDetailsList.size());
    }

    @Test(expected = InvalidDataException.class)
    public void test_WhenInvokerInvokesWithEmptyInput_ThenMethodThrowsException() {
        String[] userInput = new String[] {};
        invoker.invoke(userInput);
    }

    @Test(expected = InvalidDataException.class)
    public void test_WhenInvokerInvokesWithNullInput_ThenMethodThrowsException() {
        String[] userInput = null;
        invoker.invoke(userInput);
    }
}
