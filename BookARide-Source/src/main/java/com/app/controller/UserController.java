package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.beans.BookCabRQ;
import com.app.beans.BookCabRS;
import com.app.beans.SearchCabRQ;
import com.app.beans.SearchCabRS;
import com.app.beans.UserRS;
import com.app.entity.db1.User;
import com.app.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public @ResponseBody UserRS addUser(@RequestBody User req) throws Exception {
		return userService.addUser(req);
	}

	@RequestMapping(value = "/user", method = RequestMethod.PUT)
	public @ResponseBody UserRS updateUser(@RequestBody User req) throws Exception {
		return userService.updateUser(req);
	}
	
	
	@RequestMapping(value = "/user/{captianId}", method = RequestMethod.GET)
	public @ResponseBody UserRS getUser(@PathVariable("userId") Long userId) throws Exception {
		return userService.getUser(userId);
	}
	
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public @ResponseBody List<SearchCabRS> searchCab(@RequestBody SearchCabRQ req) throws Exception {
		return userService.searchCab(req);
	}

	
	@RequestMapping(value = "/bookARide", method = RequestMethod.POST)
	public @ResponseBody BookCabRS bookARide(@RequestBody BookCabRQ req) throws Exception {
		return userService.bookARide(req);
	}

}
