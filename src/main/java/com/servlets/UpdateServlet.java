package com.servlets;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.models.Ville;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("code")==null) {
			response.sendRedirect("/ESEO_TP_CLIENT_I3/VillesServlet");
		}
		else {
			URL url = new URL("http://localhost:8181/ville?code_commune_insee="+request.getParameter("code"));
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json");
			int status = con.getResponseCode();
			BufferedReader in = new BufferedReader(
					  new InputStreamReader(con.getInputStream()));
					String inputLine;
					StringBuffer content = new StringBuffer();
					while ((inputLine = in.readLine()) != null) {
					    content.append(inputLine);
					}
					in.close();
			System.out.println(status);
			String jsonedContent = content.toString().replace("]", "");
			jsonedContent = jsonedContent.replace("[","");
			JSONObject ob = new JSONObject(jsonedContent);
			Ville ville = new Ville(ob);
			request.setAttribute("city", ville);
			request.getRequestDispatcher("update.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String data = "{\r\n"
				+ "    \"codeCommune\" : \""+request.getParameter("codeCommune")+"\",\r\n"
				+ "    \"nomCommune\" : \""+request.getParameter("nomCommune")+"\",\r\n"
				+ "    \"codePostal\" : \""+request.getParameter("codePostal")+"\",\r\n"
				+ "    \"libelleAcheminement\" : \""+request.getParameter("libelleAcheminement")+"\",\r\n"
				+ "    \"ligne\" : \""+request.getParameter("ligne")+"\",\r\n"
				+ "    \"latitude\" : \""+request.getParameter("latitude")+"\",\r\n"
				+ "    \"longitude\" : \""+request.getParameter("longitude")+"\"\r\n"
				+ "}";
		URL url = new URL("http://localhost:8181/ville");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("PUT");
		con.setRequestProperty("Content-Type", "application/json");
		con.setDoOutput(true);
		try(OutputStream os = con.getOutputStream()) {
		    byte[] input = data.getBytes("utf-8");
		    os.write(input, 0, input.length);			
		}
		try(BufferedReader br = new BufferedReader(
				  new InputStreamReader(con.getInputStream(), "utf-8"))) {
				    StringBuilder resp = new StringBuilder();
				    String responseLine = null;
				    while ((responseLine = br.readLine()) != null) {
				        resp.append(responseLine.trim());
				    }
				    System.out.println(resp.toString());
				}
		response.sendRedirect("/ESEO_TP_CLIENT_I3/VillesServlet");
	}

}
