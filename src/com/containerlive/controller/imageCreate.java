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

@WebServlet("/imageCreate")
public class imageCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		HttpSession session = request.getSession();
		String imageName= request.getParameter("imageName");
		String tag = request.getParameter("tag");
		
		ImageServices imageService = new ImageServices();

		try {

			imageService.pullImage(imageName, tag);
			session.setAttribute("message", "Image has been pulled successully.");
			List<String> images = imageService.listImages();
			session.setAttribute("images", images);
			response.sendRedirect("/containerlive");
			
		} catch (Exception e) {
			
			session.setAttribute("messageFail", "Image not found.");
			response.sendRedirect("/containerlive");
			e.printStackTrace();
		}
	}

}
