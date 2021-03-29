package com.containerlive.service;

import java.util.Iterator;
import java.util.List;
import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.model.Container;



public class ContainerServices {
	
	DockerClient dockerClient = ConfigurationServices.dockerClient;
	public static CreateContainerResponse newContainer;
	
	public boolean createContainer(String imageName) {
		
		newContainer = dockerClient.createContainerCmd(imageName)
        //.withCmd("cat", "-e")
        .withTty(false)
        .withStdinOpen(true)
        .exec();
		
		return true;
	}
	
	public boolean startContainer(String containerId) {
		
		dockerClient.startContainerCmd(containerId).exec();
		return true;
	}
	
	public boolean stopContainer(String containerId) {
		
		dockerClient.stopContainerCmd(containerId).exec();
		return true;
	}

	public List<Container> listContainers() {

		List<Container> containers = dockerClient.listContainersCmd().withShowAll(true).exec();
		/****Test****/
		Iterator<Container> it = containers.iterator();
		while (it.hasNext()) {

			Container container = it.next();
			System.out.println(container.getImage() + "  " + container.getStatus());

		}
		return containers;
	}
	
	

	

}
