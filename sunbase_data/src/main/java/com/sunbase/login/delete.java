package com.sunbase.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Servlet implementation class del
 */
@WebServlet("/delete")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String rid = request.getParameter("id");
		String rtok = request.getParameter("tok");
		System.out.print(rtok+"  "+rid);
		URL url=new URL("https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp?cmd=delete&uuid="+rid);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		//conn.setRequestProperty("Content-Type", "application/json");
		conn.addRequestProperty("Authorization", "Bearer "+rtok);
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		int responseCode = conn.getResponseCode();
		
		System.out.println(responseCode);
		System.out.println("okkkkkkkkkkkkk");
		
		glist g1=new glist(rtok);
		g1.doPost(request, response);
	}


}
