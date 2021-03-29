package com.containerlive.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.containerlive.service.ConfigurationServices;
import com.containerlive.service.ContainerServices;
import com.containerlive.service.ImageServices;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.api.model.Image;

@WebServlet("/configuration")
public class configuration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				HttpSession session = request.getSession();
				String ipAddress = request.getParameter("dockerHost");
				String portNumber = request.getParameter("dockerPort");
				boolean tlsFlag = Boolean.valueOf(String.valueOf(request.getAttribute("tlsFlag")));
				
				try{
				
				ConfigurationServices.configureClient(ipAddress, portNumber, tlsFlag);	
				ContainerServices containerService = new ContainerServices();

				ImageServices imageService = new ImageServices();
				List<String> images = imageService.listImages();
				List<Container> containers = containerService.listContainers();
				session.setAttribute("containers", containers);
				session.setAttribute("images", images);
				session.setAttribute("message", "Configuration has succeeded.");
				response.sendRedirect("/containerlive");
				
				} catch(Exception e) {
					
					session.setAttribute("messageFail", "Configuration has failed. Please enter correct details.");
					response.sendRedirect("/containerlive");
					
				}
	}

}
