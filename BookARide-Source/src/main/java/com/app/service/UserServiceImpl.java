package com.app.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.beans.BookCabRQ;
import com.app.beans.BookCabRS;
import com.app.beans.CaptianStatusRQ;
import com.app.beans.CaptianUpdateRS;
import com.app.beans.GoogleMatrixDistanceRS;
import com.app.beans.SearchCabRQ;
import com.app.beans.SearchCabRS;
import com.app.beans.UserRS;
import com.app.dao.CaptainRidesDao;
import com.app.dao.UserDao;
import com.app.entity.db1.CaptainRides;
import com.app.entity.db1.CaptainUpdate;
import com.app.entity.db1.User;
import com.app.util.RestServiceUtil;
import com.google.gson.Gson;

@Service
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW, readOnly = false, value = "db1SessionFactory")
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Autowired
	RestServiceUtil restServiceUtil;
	
	@Autowired
	CaptainRidesDao captainRidesDao;
	

	@Override
	public UserRS addUser(User req) {
		User resp = userDao.addUser(req);
		UserRS response = new UserRS();
		response.setUser(resp);
		response.setStatusCode(200);
		return response;
	}

	@Override
	public UserRS updateUser(User req) {
		User resp = userDao.updateUser(req);
		UserRS response = new UserRS();
		response.setUser(resp);
		response.setStatusCode(200);
		return response;
	}

	@Override
	public UserRS getUser(Long userId) {
		User resp = userDao.getUser(userId);
		UserRS response = new UserRS();
		response.setUser(resp);
		response.setStatusCode(200);
		return response;
	}

	@Override
	public List<SearchCabRS> searchCab(SearchCabRQ req) throws ExecutionException {
		 List<CaptainUpdate> listOfCaptainsLocations = userDao.searchCab(req);
		 
		 //Get an update from nearest Cab Drivers
		 
		 String URL = "https://maps.googleapis.com/maps/api/distancematrix/json";
		 
		 //Top 10 Cabs Results
		 	int ctr=0;
			 Map<String, Object> jsonAsMap = new LinkedHashMap<>();
			 jsonAsMap.put("origins", req.getLat()+","+req.getLng());
			 //jsonAsMap.put("origins", "12.926779,77.616478");
			 CaptainUpdate captianUpdate = listOfCaptainsLocations.get(ctr++);
			 jsonAsMap.put("destinations", captianUpdate.getLat() + "," + captianUpdate.getLng());
			 //jsonAsMap.put("destinations", "12.932363,77.612455");
			 jsonAsMap.put("mode", "car");
			 jsonAsMap.put("language", "fr-FR");
			 jsonAsMap.put("key", "AIzaSyC6wTdayVoub213ybE41BsJ1oU6Spb2DQE");
			List<SearchCabRS> listResp = new ArrayList<>();
			try {
				//URL, params
				Future<String> cab1 =restServiceUtil.getAsyncAPIResponse_GET(URL, jsonAsMap);
				captianUpdate = listOfCaptainsLocations.get(ctr++);
				jsonAsMap.put("destinations", captianUpdate.getLat() + "," + captianUpdate.getLng());
				Future<String> cab2 =restServiceUtil.getAsyncAPIResponse_GET(URL, jsonAsMap);
				captianUpdate = listOfCaptainsLocations.get(ctr++);
				jsonAsMap.put("destinations", captianUpdate.getLat() + "," + captianUpdate.getLng());

				Future<String> cab3 =restServiceUtil.getAsyncAPIResponse_GET(URL, jsonAsMap);
				captianUpdate = listOfCaptainsLocations.get(ctr++);
				jsonAsMap.put("destinations", captianUpdate.getLat() + "," + captianUpdate.getLng());
				Future<String> cab4 =restServiceUtil.getAsyncAPIResponse_GET(URL, jsonAsMap);
				captianUpdate = listOfCaptainsLocations.get(ctr++);
				jsonAsMap.put("destinations", captianUpdate.getLat() + "," + captianUpdate.getLng());
				Future<String> cab5 =restServiceUtil.getAsyncAPIResponse_GET(URL, jsonAsMap);

				int count =0;
				for(int i=0; i< listOfCaptainsLocations.size() && i<5 ; i++) {
					SearchCabRS response = new SearchCabRS();
					response.setCaptian(listOfCaptainsLocations.get(i));
					if (count==0)
						response.setObject(cab1.get());
					else if (count==1)
						response.setObject(cab2.get());
					else if (count==2)
						response.setObject(cab3.get());
					else if (count==3)
						response.setObject(cab4.get());
					else if (count==4)
						response.setObject(cab5.get());
					else;
					try {
					String jsonInString =response.getObject();
					Gson gson = new Gson();
					GoogleMatrixDistanceRS googleMatrixDistanceRS = gson.fromJson(jsonInString, GoogleMatrixDistanceRS.class);
					response.setGoogleMatrixDistanceRS(googleMatrixDistanceRS);
					}
					catch(Exception e) {
						System.out.println(e);
					}
					listResp.add(response);
					count++;
				}



			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		return listResp;
	}

	@Override
	public BookCabRS bookARide(BookCabRQ req) {
		
		CaptainRides captainRides = new CaptainRides();
		captainRides.setCaptainId(req.getCaptainId());
		captainRides.setSrcLat(req.getLat());
		captainRides.setSrcLng(req.getLng());
		captainRides.setUserId(req.getUserId());
		captainRides.setStatus(false);
		 
		captainRidesDao.bookARide(captainRides);
		
		BookCabRS resp = new BookCabRS();
		resp.setBookACab(captainRides);
		resp.setStatusCode(200);
		return resp;
	}

}
