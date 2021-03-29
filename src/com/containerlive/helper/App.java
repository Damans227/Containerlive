package com.containerlive.helper;

import java.util.Scanner;

import com.containerlive.service.ConfigurationServices;
import com.containerlive.service.ContainerServices;
import com.containerlive.service.ImageServices;


public class App {

	public static void main(String[] args) throws InterruptedException {
		
		Scanner in = new Scanner(System.in);
		
		ConfigurationServices.configureClient("127.0.0.1", "2375", false);
		ImageServices imageService = new ImageServices();
		imageService.pullImage("busybox", "latest");
		imageService.listImages();
		ContainerServices container = new ContainerServices();
		
		container.createContainer("busybox");
		//container.listContainers();
		
		System.out.println("Enter the image Id");
		String imageId = in.nextLine();
		container.startContainer(imageId);
		
		while(true) {
    		
	    	System.out.println("\nEnter 'Y' to stop the container:");
	    	String ans = in.nextLine();
	    	
	    	if(ans.equals("Y")) {
	    		
	    		container.stopContainer(imageId);
	    		break;
	    	}
	    	
	    	}
	    	System.out.println("Container stopped!");
	    	
		
	}

}
