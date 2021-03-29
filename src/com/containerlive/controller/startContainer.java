package com.containerlive.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.containerlive.service.ContainerServices;
import com.github.dockerjava.api.model.Container;

@WebServlet("/startContainer")
public class startContainer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		HttpSession session = request.getSession();
		String containerId = request.getParameter("containerId");
		ContainerServices containerService = new ContainerServices();
		
		try {
			containerService.startContainer(containerId);
			List<Container> containers = containerService.listContainers();
			
			session.setAttribute("message", "Container has been started successully.");
			session.setAttribute("containers", containers);
			response.sendRedirect("/containerlive");
			
		} catch(Exception e) {
				session.setAttribute("messageFail", "Failed to start the container. Enter a valid Container Id. ");
				response.sendRedirect("/containerlive");
				
			}	
		}	
	}

