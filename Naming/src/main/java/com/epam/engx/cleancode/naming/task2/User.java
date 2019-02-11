package com.epam.engx.cleancode.naming.task2;

import java.util.Arrays;
import java.util.Date;

public class User {

	private Date birthday;

	private String name;

	private boolean admin;

	private User[] subordinates;

	private int rating;

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public User[] getSubordinates() {
		return subordinates;
	}

	public void setSubordinates(User[] subordinates) {
		this.subordinates = subordinates;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "User [birthday=" + birthday + ", name=" + name + ", admin=" + admin + ", subordinates="
				+ Arrays.toString(subordinates) + ", Rating=" + rating + "]";
	}

}
