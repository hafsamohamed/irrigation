package com.example.irrigation.api.resource;

import com.example.irrigation.api.resource.util.SensorSimulator;
import com.example.irrigation.service.impl.SensorServiceImpl;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApiTest {

    private String str = """
           {
             "sensorId": 3,
              "time": "2023-07-04T12:26:12.298+00:00"
           }
            """;
    @Autowired
    TestRestTemplate testRestTemplate;

    SensorSimulator sensorSimulatorMock = mock(SensorSimulator.class);
    private static String SPECIFIC_URL = "/api/plot/1";
    private static String IRRIGATE_URL = "/api/plot/irrigate/1";
    private static String ALERT_URL= "/api/alert";
    private static String SENSOR_URL= "/api/sensor/1/status";
    private static String RESUME_SENSOR_URL= "/api/sensor/1/resume";


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
    void sensorStateTrack() throws JSONException {
        testRestTemplate.getForEntity(SENSOR_URL, String.class);
        testRestTemplate.getForEntity(SENSOR_URL, String.class);
        testRestTemplate.getForEntity(RESUME_SENSOR_URL, String.class);

        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity(SENSOR_URL, String.class);

        assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        assertEquals(0, SensorServiceImpl.singleton.getFetchCount());

    }
    @Test
    void irrigatePlotFailed() throws JSONException {
        testRestTemplate.getForEntity(SENSOR_URL, String.class);
        testRestTemplate.getForEntity(SENSOR_URL, String.class);
        testRestTemplate.getForEntity(SENSOR_URL, String.class);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        if (SensorServiceImpl.singleton.getFetchCount() >= 3){

            HttpEntity<String> httpEntity = new HttpEntity<>(str, headers);
            ResponseEntity<String> responseEntity = testRestTemplate.exchange(ALERT_URL, HttpMethod.POST,httpEntity, String.class);
            System.out.println(responseEntity.getStatusCode() + "hereeee");

            assertTrue(responseEntity.getStatusCode().is2xxSuccessful());

        }

    }


}