package com.containerlive.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.containerlive.service.ImageServices;
import com.github.dockerjava.api.model.Image;

@WebServlet("/listImages")
public class listImages extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
			HttpSession session = request.getSession();
			ImageServices imageService = new ImageServices();
			List<String> images = imageService.listImages();
			session.setAttribute("images", images);
			response.sendRedirect("/containerlive");
			
	}

}
