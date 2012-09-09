package com.ctb.pilot.common;

public interface DbConstants {

	String SERVER = "127.0.0.1";
	String USERNAME = "ctb";
	String PASSWORD = "cTb0409";
	String DATABSE = "db_ctb";
	String CONNECTION_URL = "jdbc:mysql://" + SERVER + "/" + DATABSE + "?user="
			+ USERNAME + "&password=" + PASSWORD
			+ "&useUnicode=yes&characterEncoding=UTF-8";

}
