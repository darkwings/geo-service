package com.wefox.lab.geoservice;

import com.wefox.lab.response.Response;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class GeoResourceTest {

    @Test
    void testCountriesEndpoint() {
        var r = given()
                .when().get("/geo/countries?lang=it")
                .then()
                .statusCode(200)
                .extract().as(Response.class);

        // TODO Better, use Country instead of Map
        var list = (List<Map>) r.data();
        System.out.println(list);
        Assertions.assertEquals(2, list.size());
        Assertions.assertEquals("it", list.get(0).get("country_id"));
        Assertions.assertEquals("de", list.get(1).get("country_id"));
    }
}
