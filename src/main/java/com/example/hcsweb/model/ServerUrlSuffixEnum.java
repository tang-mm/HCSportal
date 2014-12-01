package com.example.hcsweb.model;

public enum ServerUrlSuffixEnum {
	//-----------Shared------------
	CCDM(0, "portal"),
//	CUCDM()
	PCA(0, "emsam"),
	
	//-----------Customer Side------------
	FINESSE_DESKTOP(0, "desktop"),
//	EIM_WIM_SUPERVISOR()
//	INTERNET_SCRIPT_EDITOR()
	CUIC_USER(8444, "cuic"),
	MEDIASENSE_SEARCH_PLAY(8440, "mediasense"), 
	
	//-----------Administration Tools for Experts------------
	CUIC_ADMIN(0, "oamp"),
	FINESS_ADMIN(0, "cfadmin"),
	MEDIASENSE_ADMIN(0, "oraadmin");
	
	//TODO retrieve values from DB
	private final int port;
//	private final int ipSuffix;
	private final String urlSuffix; 

	private ServerUrlSuffixEnum(int port, String urlSuffix) {
		this.port = port;
//		this.ipSuffix = ipSuffix;
		this.urlSuffix = urlSuffix;
	}

	public int getPort() {
		return port;
	}

	public String getSuffix() {
		return urlSuffix;
	} 
}
