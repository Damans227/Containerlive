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

/**
 * Servlet implementation class stopContainer
 */
@WebServlet("/stopContainer")
public class stopContainer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String containerId = request.getParameter("containerId");
		ContainerServices containerService = new ContainerServices();
		
		try {
			containerService.stopContainer(containerId);
			List<Container> containers = containerService.listContainers();
			session.setAttribute("message", "Container has been stopped successully.");
			session.setAttribute("containers", containers);
			response.sendRedirect("/containerlive");
			
		} catch(Exception e) {
			session.setAttribute("messageFail", "Container failed to stop. Please enter a valid Container Id.");
			response.sendRedirect("/containerlive");
			
		}
		
	}

}
