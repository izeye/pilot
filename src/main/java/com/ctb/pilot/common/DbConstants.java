package com.ctb.pilot.common;

public interface DbConstants {

	String SERVER = "127.0.0.1";
	String USERNAME = "ctbrg";
	String PASSWORD = "ctbrgctbrg2";
	String DATABSE = "ctbrg";
	String CONNECTION_URL = "jdbc:mysql://" + SERVER + "/" + DATABSE + "?user="
			+ USERNAME + "&password=" + PASSWORD
			+ "&useUnicode=yes&characterEncoding=UTF-8";

}
