package com.assignment.request.handler;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import com.assignment.response.model.PositionDetails;

public class RequestInvokerTest {

    private Invoker invoker;
    private RequestHandler requestHandler;

    @Before
    public void setUp() throws Exception {
        requestHandler = mock(RequestHandler.class);
        invoker = new RequestInvoker(requestHandler);
    }

    @Test
    public void test_WhenInvokeCalledWithValidInput_ThenCallSucceeds() {
        final String[] requestCity = {"Berlin"};
        doNothing().when(requestHandler).preProcess(requestCity);
        List<PositionDetails> positionList = new ArrayList<PositionDetails>();
        when(requestHandler.process(requestCity[0])).thenReturn(positionList);
        doNothing().when(requestHandler).postProcess(positionList);
        assertEquals(positionList, invoker.invoke(requestCity));
    }
}
