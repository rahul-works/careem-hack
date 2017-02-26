package com.app.service;

import java.util.List;
import java.util.concurrent.ExecutionException;

import com.app.beans.BookCabRQ;
import com.app.beans.BookCabRS;
import com.app.beans.SearchCabRQ;
import com.app.beans.SearchCabRS;
import com.app.beans.UserRS;
import com.app.entity.db1.User;

public interface UserService {

	UserRS addUser(User req);

	UserRS updateUser(User req);

	UserRS getUser(Long userId);

	List<SearchCabRS> searchCab(SearchCabRQ req) throws ExecutionException;

	BookCabRS bookARide(BookCabRQ req);

}
