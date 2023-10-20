package com.sunbase.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;


@WebServlet("/glis")
public class glist extends HttpServlet {
	String token;
	glist(String tok){
		token= tok;
	}
	private static final long serialVersionUID = 1L;
	public static HttpURLConnection connection;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hello");
		BufferedReader reader;
		String line;
		StringBuffer responseContent = new StringBuffer();
		URL url=new URL("https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp?cmd=get_customer_list");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		System.out.println(token);
		conn.addRequestProperty("Authorization", "Bearer "+token);
		
		int responseCode = conn.getResponseCode();
		System.out.println(responseCode);
		/*try (BufferedReader bf = new BufferedReader(new InputStreamReader(conn.getInputStream()))){
			String line1;
			//String line2=null;
			while((line1 = bf.readLine())!= null) {
				//System.out.println(line1);
				//System.out.print("<caption>Student Result : </caption>");
			}
		}*/
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try {
			out.print("<a href=\"addCust?tok="+token+"\">Add Customer</a>");
			out.print("<form action=\"glis\" method=\"post\" name=\"glis\">\r\n"
					+ "	 <table>\r\n"
					+ "            <tr>\r\n"
					+ "                <td>\r\n"
					+ "                    <table class=\"list\" id=\"employeeList\">\r\n"
					+ "                        <thead>\r\n"
					+ "                            <tr>\r\n"
					+ "                                <th>First name&nbsp;</th>\r\n"
					+ "                                <th>Last Name</th>\r\n"
					+ "                                <th>Street</th>\r\n"
					+ "                                <th>City</th>\r\n"
					+ "                                <th>Email</th>\r\n"
					+ "                                <th>Address</th>\r\n"
					+ "                                <th>State</th>\r\n"
					+ "                                <th>Phone</th>\r\n"
					+ "                                <th>delete</th>\r\n"
					+ "                                <th>edit</th>\r\n"
					+ "                                <th></th>\r\n"
					+ "                            </tr>\r\n"
					+ "                        </thead>\r\n");
			
			try (BufferedReader bf = new BufferedReader(new InputStreamReader(conn.getInputStream()))){
				String line1;
				String line2= null;
				while((line1 = bf.readLine())!= null) {
					//System.out.println(line1+"okkk");
					line2 = line1;
				}
				System.out.println(line2);
				String []temp1 = line2.split("}");
				System.out.println(temp1[1]);
				/*while((line1 = bf.readLine())!= null) {
					//System.out.println(line1);
					String [] temp = line1.split("\"");*/
					for(int i=0; i<temp1.length; i++) {
						String[] temp = temp1[i].split("\"");
						if(temp.length<7) {
							continue;
						}
						out.print("<tr>");
						out.print("<td>"+temp[7]+"</td>");
						out.print("<td>"+temp[11]+"</td>");
						out.print("<td>"+temp[15]+"</td>");
						out.print("<td>"+temp[19]+"</td>");
						out.print("<td>"+temp[23]+"</td>");
						out.print("<td>"+temp[27]+"</td>");
						out.print("<td>"+temp[31]+"</td>");
						//System.out.println(temp[4]+"fds"+temp[3]+"icje"+temp[5]);
						try{
							out.print("<td>"+temp[35]+"</td>");
						}catch(Exception e){
							out.print("<td>"+null+"</td>");
						}
						/*if((temp[33]==":"||temp[32]==":")||temp[34]==":") {
						out.print("<td>"+temp[35]+"</td>");
						}
						else
							out.print("<td>"+"null"+"<td>");*/
						out.print("<td><a href=\"delete?id="+temp[3]+"&tok="+token+"\">"+" delete </a></td>");
						out.print("<td><a href=\"edit?id="+temp[3]+"&tok="+token+"\">"+" edit </a></td>");
						out.print("</tr>");
					}
				//	out.print("<tr>");
				//	out.println("<td>"+temp[0]+"</td>");
				//	out.println("<td>"+temp[10]+"</td>");
				//	out.println("<td>"+temp[12]+"</td>");
				//	out.println("<td>"+temp[14]+"</td>");
				//	out.println("<td>"+temp[16]+"</td>");
					out.print("</tr>");
					//System.out.print("<caption>Student Result : </caption>");
			}
			out.print("                    </table>\r\n"
					+ "                </td>\r\n"
					+ "            </tr>\r\n"
					+ "        </table> </form>");
			
			
		}catch(Exception e) {
			out.print(e);
		}
		
		
		/*conn.setRequestMethod("GET");
		values v2= new values();
		String val= v2.getToken();
		conn.addRequestProperty("Authorization", val);
		conn.setDoOutput(true);
		conn.setRequestProperty("Content-Type", "application/json");
		try(DataOutputStream dos = new DataOutputStream(conn.getOutputStream())){
			dos.writeBytes("");
		}
		try (BufferedReader bf = new BufferedReader(new InputStreamReader(conn.getInputStream()))){
			String line1;
			String line2=null;
			while((line1 = bf.readLine())!= null) {
				System.out.println(line1);
				
			}
		}*/
	}

}
