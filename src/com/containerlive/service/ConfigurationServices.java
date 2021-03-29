package com.containerlive.service;
import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;


public class ConfigurationServices {

	public static DockerClient dockerClient;
	

	public static boolean configureClient(String ipAddress, String portNumber, boolean tlsFlag ) {
		
    	DefaultDockerClientConfig clientConfig = DefaultDockerClientConfig.createDefaultConfigBuilder()
    			.withDockerHost("tcp://"+ipAddress+":"+portNumber)
    			.withDockerTlsVerify(false)
    			.build();
		
    	 	dockerClient = DockerClientBuilder.getInstance(clientConfig).build();
    	 	
    	 	System.out.println(clientConfig);
    	
		return true;
	}
	
	

}
