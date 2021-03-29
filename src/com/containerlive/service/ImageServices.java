package com.containerlive.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Image;
import com.github.dockerjava.core.command.PullImageResultCallback;

public class ImageServices {

	DockerClient dockerClient = ConfigurationServices.dockerClient;

	public void pullImage(String pullImage, String tag) throws InterruptedException {
		
		System.out.println(tag+" - "+pullImage);
		
		if(tag=="") {
			tag="latest";	
		}

		dockerClient.pullImageCmd(pullImage)
		.withTag(tag)
		.exec(new PullImageResultCallback())
		.awaitCompletion();


	}

	public List<String> listImages() {

		List<Image> images = dockerClient.listImagesCmd().withShowAll(true).exec();
		
		List<String> newImages = new ArrayList<String>();
		
		/***** Test *****/
		Iterator<Image> itImage = images.iterator();
		

		while (itImage.hasNext()) {
			Image image = itImage.next();
			newImages.add(image.getRepoTags()[0]);
			newImages.add(image.getId().substring(0,19));

		}

		return newImages;

	}

}
