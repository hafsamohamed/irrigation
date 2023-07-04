package com.example.irrigation.api.resource;

import com.example.irrigation.api.resource.util.SensorSimulator;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApiTest {

    private String str = """
           {
             "sensorId": 1,
              "time": 
           }
            """ + new Timestamp(System.currentTimeMillis());
    @Autowired
    TestRestTemplate testRestTemplate;

    SensorSimulator sensorSimulatorMock = mock(SensorSimulator.class);
    private static String SPECIFIC_URL = "/api/plot/1";
    private static String IRRIGATE_URL = "/api/plot/irrigate/1";
    private static String ALERT_URL= "/api/alert";


    @Test
    void irrigatePlotSuccessfully() throws JSONException {
        when(sensorSimulatorMock.getNumberOfRequests()).thenReturn(2);
        when(sensorSimulatorMock.isRequestStatus()).thenReturn(true);
        if (sensorSimulatorMock.getNumberOfRequests() < 3 && sensorSimulatorMock.isRequestStatus()){
            ResponseEntity<String> responseEntity = testRestTemplate.getForEntity(IRRIGATE_URL, String.class);
            System.out.println(responseEntity.getStatusCode() + "hereeee");
            assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        }

    }

    @Test
    void irrigatePlotFailed() throws JSONException {
        when(sensorSimulatorMock.getNumberOfRequests()).thenReturn(3);
        when(sensorSimulatorMock.isRequestStatus()).thenReturn(true);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        if (sensorSimulatorMock.getNumberOfRequests() > 3 && sensorSimulatorMock.isRequestStatus()){

            HttpEntity<String> httpEntity = new HttpEntity<>(str, headers);
            ResponseEntity<String> responseEntity = testRestTemplate.exchange(ALERT_URL, HttpMethod.POST,httpEntity, String.class);
            System.out.println(responseEntity.getStatusCode() + "hereeee");

            assertTrue(responseEntity.getStatusCode().is2xxSuccessful());

        }

    }


}