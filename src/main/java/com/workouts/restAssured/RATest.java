package com.workouts.restAssured;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class RATest {

    String accountUrl = "http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1";

    public static void main(String arg[]) {
        RequestSpecification rs = given();
        rs.baseUri("http://localhost");

        rs.port(8080);

        rs.when().get("/student/");

        rs.then().statusCode(200).log().all();


    }


    @Test
    public void directURL() {
        given().when().get(accountUrl).then().log().all();
    }

    @Test
    public void getAccountDetails() {
        Response res=given().queryParam("CUSTOMER_ID", "68195")
                .queryParam("PASSWORD", "1234!")
                .queryParam("Account_No", "2")
                .when().get("http://demo.guru99.com/V4/sinkministatement.php");

        res.then().log().body();
        System.out.println("Response Code: "+res.getStatusCode());
    }


}
