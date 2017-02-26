package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.beans.BookCabRQ;
import com.app.beans.BookCabRS;
import com.app.beans.CaptianRS;
import com.app.beans.CaptianStatusRQ;
import com.app.beans.CaptianUpdateRS;
import com.app.beans.ConfirmCabRQ;
import com.app.beans.ConfirmCabRS;
import com.app.beans.StartRideRQ;
import com.app.beans.StartRideRS;
import com.app.entity.db1.Captain;
import com.app.service.CaptianService;

@Controller
public class CaptianController {

	@Autowired
	CaptianService captianService;

	@RequestMapping(value = "/captian", method = RequestMethod.POST)
	public @ResponseBody CaptianRS addCaptian(@RequestBody Captain addCaptianRQ) throws Exception {
		return captianService.addCaptian(addCaptianRQ);
	}

	@RequestMapping(value = "/captian", method = RequestMethod.PUT)
	public @ResponseBody CaptianRS updateCaptian(@RequestBody Captain addCaptianRQ) throws Exception {
		return captianService.updateCaptian(addCaptianRQ);
	}
	
	@RequestMapping(value = "/captian/{captianId}", method = RequestMethod.GET)
	public @ResponseBody CaptianRS getCaptian(@PathVariable("captianId") int captianId) throws Exception {
		return captianService.getCaptian(captianId);
	}

	@RequestMapping(value = "/captian/status", method = RequestMethod.PUT)
	public @ResponseBody CaptianUpdateRS updateCaptianStatus(@RequestBody CaptianStatusRQ captianStatusRQ) throws Exception {
		return captianService.updateCaptianStatus(captianStatusRQ);
	}
	
	@RequestMapping(value = "/captain/confirmRide", method = RequestMethod.POST)
	public @ResponseBody ConfirmCabRS confirmRide(@RequestBody ConfirmCabRQ req) throws Exception {
		return captianService.confirmRide(req);
	}
	
	@RequestMapping(value = "/captain/startARide", method = RequestMethod.POST)
	public @ResponseBody StartRideRS startARide(@RequestBody StartRideRQ req) throws Exception {
		return captianService.startARide(req);
	}
	
}
