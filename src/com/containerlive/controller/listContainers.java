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
import com.containerlive.service.ImageServices;
import com.github.dockerjava.api.model.Container;

@WebServlet("/listContainers")
public class listContainers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ContainerServices containerService = new ContainerServices();
		List<Container> containers = containerService.listContainers();
		session.setAttribute("containers", containers);
		response.sendRedirect("/containerlive");
	}

}
