package com.greyorange.models;

public interface ServiceContract {
	
	public boolean register();
	public boolean deRegister();
	public Service getServiceInfo(String id);
}
