package com.sunbase.login;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

import org.eclipse.jdt.internal.compiler.batch.Main;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.io.*;
/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static HttpURLConnection connection;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OK");
		BufferedReader reader;
		String line;
		StringBuffer responseContent = new StringBuffer();
		
		// TODO Auto-generated method stub
		String uemail = request.getParameter("username");
		String upwd = request.getParameter("password");

		String body = "{\"login_id\" :\""+ uemail+"\",\"password\" :\""+upwd+"\"}";
		URL url=new URL("https://qa2.sunbasedata.com/sunbase/portal/api/assignment_auth.jsp");
		//loginGdata g1 = new loginGdata(uemail, upwd);
		//mapper.writeValueAsString(g1);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		conn.setRequestProperty("Content-Type", "application/json");
		
		try(DataOutputStream dos = new DataOutputStream(conn.getOutputStream())){
			dos.writeBytes(body);
		}
		
		try (BufferedReader bf = new BufferedReader(new InputStreamReader(conn.getInputStream()))){
			String line1;
			String line2=null;
			while((line1 = bf.readLine())!= null) {
				System.out.println(line1);
				line2 =line2+ line1 ;
				
			}
			String[] token1 = line2.split("\"");
			String token = token1[3];
			values v1= new values();
			v1.setToken(token);
			System.out.print(token);
			RequestDispatcher dispatcher;
			if(token!=null) {
				System.out.print("op");
				dispatcher = request.getRequestDispatcher("Customer_list.jsp");
				glist g1=new glist(token);
				g1.doPost(request, response);
				//response.sendRedirect("Customer_list.jsp");
			}
			else {
				System.out.print("noop");
				dispatcher = request.getRequestDispatcher("login.jsp");
			}
			//dispatcher.forward(request, response);
		}
	}
}
