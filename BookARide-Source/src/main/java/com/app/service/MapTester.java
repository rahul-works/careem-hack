package com.app.service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.json.JSONObject;
import org.springframework.scheduling.annotation.EnableAsync;

import com.app.util.RestServiceUtil;

@EnableAsync
public class MapTester {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		long start = System.currentTimeMillis();
		String URL = "https://maps.googleapis.com/maps/api/distancematrix/json";

		// Top 10 Cabs Results
		Map<String, Object> jsonAsMap = new LinkedHashMap<>();
		jsonAsMap.put("origins", "12.926779,77.616478");
		jsonAsMap.put("destinations", "12.932363,77.612455");
		jsonAsMap.put("mode", "car");
		jsonAsMap.put("language", "fr-FR");
		jsonAsMap.put("key", "AIzaSyC6wTdayVoub213ybE41BsJ1oU6Spb2DQE");
		RestServiceUtil restServiceUtil = new RestServiceUtil();
		Future<String> cab = restServiceUtil.getAsyncAPIResponse_GET(URL, jsonAsMap);
		
		System.out.println("--> " + cab.isDone());
		Future<String> cab1 = restServiceUtil.getAsyncAPIResponse_GET(URL, jsonAsMap);
		System.out.println("--> " + cab1.isDone());
		System.out.println("one");
		Future<String> cab2 = restServiceUtil.getAsyncAPIResponse_GET(URL, jsonAsMap);
		System.out.println("--> " + cab2.isDone());
		System.out.println("two");
		Future<String> cab3 = restServiceUtil.getAsyncAPIResponse_GET(URL, jsonAsMap);
		
		System.out.println("--> " + cab3.isDone());
		System.out.println("three");
		Future<String> cab4 = restServiceUtil.getAsyncAPIResponse_GET(URL, jsonAsMap);
		System.out.println("--> " + cab4.isDone());
		System.out.println("Running....");
		/*while (!(cab.isDone() && cab1.isDone() && cab2.isDone() && cab3.isDone() && cab4.isDone())) {
			Thread.sleep(10); // 10-millisecond pause between each check
		}*/

		System.out.println("Elapsed time: " + (System.currentTimeMillis() - start));
		try {
			System.out.println("--> " + cab.get());
			System.out.println("--> " + cab1.get());
			System.out.println("--> " + cab2.get());
			System.out.println("--> " + cab3.get());
			System.out.println("--> " + cab4.get());
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

}
