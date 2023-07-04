package com.example.irrigation.api.resource.plot;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PlotControllerTest {

//    private String str = """
//[{"id":7,"space":10.0,"amountOfWater":2.5,"status":false,"sensorStatus":false},{"id":8,"space":20.0,"amountOfWater":5.0,"status":false,"sensorStatus":false},{"id":9,"space":30.0,"amountOfWater":10.0,"status":false,"sensorStatus":false},{"id":10,"space":30.34,"amountOfWater":42.8,"status":false,"sensorStatus":false},{"id":11,"space":30.34,"amountOfWater":42.8,"status":false,"sensorStatus":false},{"id":12,"space":4.56,"amountOfWater":42.8,"status":true,"sensorStatus":false},{"id":13,"space":3000.34,"amountOfWater":42.8,"status":false,"sensorStatus":false},{"id":14,"space":3000.34,"amountOfWater":42.8,"status":false,"sensorStatus":false},{"id":15,"space":3000.34,"amountOfWater":42.8,"status":false,"sensorStatus":false},{"id":16,"space":3000.34,"amountOfWater":42.8,"status":false,"sensorStatus":false},{"id":17,"space":4.56,"amountOfWater":42.8,"status":true,"sensorStatus":false},{"id":18,"space":4.56,"amountOfWater":42.8,"status":true,"sensorStatus":false}],[Content-Type:"application/json", Transfer-Encoding:"chunked", Date:"Sat, 01 Jul 2023 08:54:03 GMT", Keep-Alive:"timeout=60", Connection:"keep-alive"]
//""";
    private String str = """
            {"id":2,
            "space":4.56,"amountOfWater":42.8,
            "status":true,
            "sensorStatus":false}
            """;
    @Autowired
    TestRestTemplate testRestTemplate;

    private static String SPECIFIC_URL = "/api/plot/12";
    private static String URL= "/api/plot";

    @Test
    void addPlot() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        HttpEntity<String> httpEntity = new HttpEntity<>(str, headers);
        ResponseEntity<String> responseEntity = testRestTemplate.exchange(URL, HttpMethod.POST,httpEntity, String.class);

        assertTrue(responseEntity.getStatusCode().is2xxSuccessful());

    }

    @Test
    void getPlot() throws JSONException {
        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity(SPECIFIC_URL, String.class);
        JSONAssert.assertEquals(str, responseEntity.getBody(), true);
    }

    @Test
    void editPlot() {
    }
}