package com.greyorange.app;

import java.util.Map;

import com.greyorange.models.Service;
import com.greyorange.serviceregistry.ServiceRegistry;

public class Application {
	
	public static void main(String[] args) {
		Service s1 = new Service("1", "xyz", true);
		s1.register();
		
		Service s2 = new Service("2", "abc", true);
		s2.register();
		
		ServiceRegistry serviceRegistry = ServiceRegistry.getInstance();
		Map<String, Service> services = serviceRegistry.getServicesList();
		System.out.println(services.size());
		
		System.out.println(s1.getServiceInfo("2").getIp());
	}

}
