package com.cydeo.utilities;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import java.util.List;
import java.util.Map;


public class BookItUtils {

    public static Object getInfo(String endPath, String responsePath){

        String path = ConfigurationReader.getProperty("apiUrl")+"/api" + endPath;
        return RestAssured.given().accept(ContentType.JSON)
                .and()
                .header("Authorization", Token.getToken())
                .when()
                .get(path).path(responsePath);
    }

    public static List<Map<String ,String >> getExcelData(){
        ExcelUtil bookitFile = new ExcelUtil("src/test/resources/BookItQa3.xlsx","QA3");
        return bookitFile.getDataList();
    }
}
