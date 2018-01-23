package com.greyorange.serviceregistry;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import com.greyorange.models.Service;

public class ServiceRegistry implements Runnable{
	
	private Map<String, Service> servicesList = new HashMap<>();
	private static ServiceRegistry serviceRegistry;
	private HashSet<String> aliveList = new HashSet<>();
	
	private ServiceRegistry(){	
	}
	
	
	/*
	 * register
	 */
	public boolean registerService(Service service){		
		servicesList.put(service.getId(),service);		
		return true;
		
	}
	
	
	/*
	 * De-register
	 */
	public boolean deregisterService(Service service){
		servicesList.remove(service.getId());
		return true;
	}
	
	
	/*
	 * Service info by id
	 */
	public Service getServiceInfo(String id){
		return servicesList.get(id);
	}
	
	
	public Map<String, Service> getServicesList() {
		return servicesList;
	}


	public static ServiceRegistry getInstance(){
		if(serviceRegistry == null){
			serviceRegistry = new ServiceRegistry();
		}		
		return serviceRegistry;
	}


	public void serviceDown(Service service) {	
	}
	
	public void serviceAlive(Service service) {
		aliveList.add(service.getId());
	}

	@Override
	public void run() {
		try {
		     while(true) {
		    	this.check(); 
		        Thread.sleep(10000);
		     }
		 } catch (InterruptedException e) {
		 }		
	}

	private void check() {
		for(String id : aliveList){
			System.out.println(id);
		}
	}
}
