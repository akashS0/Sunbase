package com.sunbase.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Servlet implementation class NewCust
 */
public class NewCust extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ooooooooooooooooooooooooooooooooooooo");

		String rtok = request.getParameter("rtok");
		//System.out.println(rid+rtok);
		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String emai = request.getParameter("email");
		String address = request.getParameter("address");
		String phon = request.getParameter("phone");
		String state = request.getParameter("state");
		System.out.print(fname);
		String body="{\"first_name\": \""+fname+"\",\r\n"
				+ "\"last_name\": \""+lname+"\",\r\n"
				+ "\"street\": \""+street+"\",\r\n"
				+ "\"address\": \""+address+"\",\r\n"
				+ "\"city\": \""+city+"\",\r\n"
				+ "\"state\": \""+state+"\",\r\n"
				+ "\"email\": \""+emai+"\",\r\n"
				+ "\"phone\": \""+phon+"\"}";
		URL url=new URL("https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp?cmd=create");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.addRequestProperty("Authorization", "Bearer "+rtok);
		conn.setDoOutput(true);
		conn.setRequestProperty("Content-Type", "application/json");
		try(DataOutputStream dos = new DataOutputStream(conn.getOutputStream())){
			dos.writeBytes(body);
		}
		
		
		int responseCode = conn.getResponseCode();
		System.out.println(responseCode);
		
		glist g1=new glist(rtok);
		g1.doPost(request, response);
	}

}
