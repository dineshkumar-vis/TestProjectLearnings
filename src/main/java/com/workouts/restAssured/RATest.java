package com.workouts.restAssured;


import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

public class RATest {


    public static void main(String arg[]){
        RequestSpecification rs= RestAssured.given();
        rs.baseUri("http://localhost");

        rs.port(8080);

        rs.when()
                .get("/student/")
                .then()
                .statusCode(200)
                .log().all();
    }


    @Test
    public void  testM(){

    }




}
