package com.sunbase.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Servlet implementation class edit
 */
//@WebServlet("/edit")
public class edit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rid = request.getParameter("id");
		String rtok = request.getParameter("tok");
		System.out.print(rtok+"  "+rid);

		System.out.println("okkkkkkkkkkkkk");
		

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try {		
			out.print("<form action = \"EditVal\" method=\"post\">\r\n"
					+ "            <div class=\".form-group\">\r\n"
					+ "                <input type=\"text\" class=\".form-group\" name=\"firstname\" id=\"firstname\" placeholder=\"Firstname\" required>\r\n"
					+ "            </div>\r\n"
					+ "            <div class=\".form-group\">\r\n"
					+ "                <input type=\"text\" name=\"street\" id=\"street\" placeholder=\"street\" required>\r\n"
					+ "            </div>\r\n"
					+ "            <div class=\".form-group\">\r\n"
					+ "                <input type=\"text\" name=\"city\" id=\"city\" placeholder=\"city\" required>\r\n"
					+ "            </div>\r\n"
					+ "            <div class=\".form-group\">\r\n"
					+ "                <input type=\"email\" name=\"email\" id=\"email\" placeholder=\"email\" required>\r\n"
					+ "            </div>\r\n"
					+ "            <div class=\".form-group\">\r\n"
					+ "                <input type=\"text\" name=\"lastname\" id=\"lastname\" placeholder=\"Last Name\" required>\r\n"
					+ "            </div>\r\n"
					+ "            <div class=\".form-group\">\r\n"
					+ "                <input type=\"text\" name=\"address\" id=\"address\" placeholder=\"Address\" required>\r\n"
					+ "            </div>\r\n"
					+ "            <div class=\".form-group\">\r\n"
					+ "                <input type=\"text\" name=\"state\" id=\"state\" placeholder=\"State\" required>\r\n"
					+ "            </div>\r\n"
					+ "            <div class=\".form-group\">\r\n"
					+ "                <input type=\"phone\" name=\"phone\" id=\"phone\" placeholder=\"Phone\" required>\r\n"
					+ "            </div>\r\n"
					
					
					
					
					+ "            <div class=\".form-group\">\r\n"
					+ "                <input type = \"hidden\"name=\"rid\" id=\"rid\" value=\""+rid+"\">\r\n"
					+ "            </div>\r\n"
					
					+ "            <div class=\".form-group\">\r\n"
					+ "                <input type = \"hidden\"name=\"rtok\" id=\"rtok\" value=\""+rtok+"\">\r\n"
					+ "            </div>\r\n"
					
					+ "             <div class=\".form-group\">\r\n"
					+ "                <input type=\"submit\" value=\"EditVal\">\r\n"
					+ "            </div>\r\n"
					+ "        </form>");
		}catch(Exception e) {
			out.print(e);
			
			//EditVal?id="+rid+"&tok="+rtok
		}
		
		

	}

}
