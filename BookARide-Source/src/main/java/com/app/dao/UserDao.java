package com.app.dao;

import java.util.List;

import com.app.beans.SearchCabRQ;
import com.app.entity.db1.CaptainUpdate;
import com.app.entity.db1.User;

public interface UserDao {

	User addUser(User req);

	User updateUser(User req);

	User getUser(Long userId);

	List<CaptainUpdate> searchCab(SearchCabRQ req);
	
	
}
