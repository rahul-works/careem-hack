package com.app.util;

import static com.jayway.restassured.RestAssured.given;

import java.util.Map;
import java.util.concurrent.Future;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

@Service("restServiceUtil")
public class RestServiceUtil {

	Logger logger = Logger.getLogger(this.getClass());

	public JSONObject getAPIResponse_GET(String requestURI, Map<String, Object> jsonAsMap) {
		Response response = null;
		if (jsonAsMap == null) {
			response = given().when().get(requestURI);
		} else {
			response = given().contentType(ContentType.JSON).parameters(jsonAsMap).when().get(requestURI);
		}
		String JsOnString = response.asString();

		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject(JsOnString);
		} catch (JSONException e) {
			logger.error("Exception occured in getAPIResponse : " + JsOnString + " : " + e);
			e.printStackTrace();
		}

		return jsonObject;
	}

	public JSONObject getAPIResponse_POST(String requestURI, Map<String, Object> jsonAsMap) {
		Response response = given().contentType(ContentType.JSON).body(jsonAsMap).when().post(requestURI);
		String JsOnString = response.asString();

		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject(JsOnString);
		} catch (JSONException e) {
			logger.error("Exception occured in getAPIResponse : " + JsOnString + " : " + e);
			e.printStackTrace();
		}

		return jsonObject;
	}

	public JSONObject getAPIResponse_BasicAuth_POST(String requestURI, Map<String, Object> jsonAsMap, String username,
			String password) {

		Response response = given().auth().preemptive().basic(username, password).contentType(ContentType.JSON)
				.body(jsonAsMap).when().post(requestURI);
		String JsOnString = response.asString();

		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject(JsOnString);
		} catch (JSONException e) {
			logger.error("Exception occured in getAPIResponse_BasicAuth_POST : " + JsOnString + " : " + e);
			e.printStackTrace();
		}
		if (response.getStatusCode() == 201) // Ticket Created, ZenDesk
												// ResponseCode for POST +
												// ticket Created
			return jsonObject;
		return null;
	}

	@Async
	public Future<String> getAsyncAPIResponse_GET(String requestURI, Map<String, Object> jsonAsMap)
			throws InterruptedException {
		logger.info("Looking up " + requestURI);
		System.out.println(System.currentTimeMillis());

		Response response = null;
		if (jsonAsMap == null) {
			response = given().when().get(requestURI);
		} else {
			response = given().contentType(ContentType.JSON).parameters(jsonAsMap).when().get(requestURI);
		}
		String JsOnString = response.asString();

		/*JSONObject jsonObject = null;

		try {
			jsonObject = new JSONObject(JsOnString);
		} catch (JSONException e) {
			logger.error("Exception occured in getAsyncAPIResponse_GET : " + JsOnString + " : " + e);
			e.printStackTrace();
		}*/
		return new AsyncResult<>(JsOnString);
	}

	public JSONArray getAPIResponse_GET_JSONArray(String requestURI, Map<String, Object> jsonAsMap) {
		Response response = null;
		if (jsonAsMap == null) {
			response = given().when().get(requestURI);
		} else {
			response = given().contentType(ContentType.JSON).parameters(jsonAsMap).when().get(requestURI);
		}
		String JsOnString = response.asString();

		JSONArray jsonArray = null;
		try {
			jsonArray = new JSONArray(JsOnString);
		} catch (JSONException e) {
			logger.error("Exception occured in getAPIResponse : " + JsOnString + " : " + e);
			e.printStackTrace();
		}

		return jsonArray;
	}

}