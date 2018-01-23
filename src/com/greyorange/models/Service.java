package com.greyorange.models;

import com.greyorange.serviceregistry.ServiceRegistry;

public class Service implements ServiceContract, Runnable {
	
	private String id;
	private String ip;
	private boolean status;	
	
	public Service(String id, String ip, boolean status) {
		super();
		this.id = id;
		this.ip = ip;
		this.status = status;
		Thread thread = new Thread(this);
		thread.start();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public boolean register() {
		ServiceRegistry registry = ServiceRegistry.getInstance();
		registry.registerService(this);
		return true;
	}
	
	
	@Override
	public boolean deRegister() {
		ServiceRegistry registry = ServiceRegistry.getInstance();
		registry.deregisterService(this);
		return true;
	}
	
	
	@Override
	public Service getServiceInfo(String id) {
		return ServiceRegistry.getInstance().getServiceInfo(id);
	}
	
	@Override
	public void run() {
		try {
		     while(status) {
		    	this.send(); 
		        Thread.sleep(10000);
		     }
		 } catch (InterruptedException e) {
		 }
	}	
	
	private void send() {
		ServiceRegistry.getInstance().serviceAlive(this);
	}
}
