package com.app.beans;

import com.app.entity.db1.User;

public class UserRS extends BasicRS {

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
