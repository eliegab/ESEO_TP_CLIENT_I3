package com.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.models.Ville;

/**
 * Servlet implementation class DistanceServlet
 */
public class DistanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DistanceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		URL url = new URL("http://localhost:8181/ville");
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
		String[] tabledContent = jsonedContent.split("\\},\\{");
		List<Ville> listOfCities = new ArrayList<Ville>();
		for (String entry : tabledContent) {
			if(entry.charAt(0)!='{') entry="{"+entry;
			if(entry.charAt(entry.length()-1)!='}') entry=entry+"}";
			JSONObject ob = new JSONObject(entry);
			listOfCities.add(new Ville(ob));
		}
		request.setAttribute("listCities", listOfCities);
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Double latitudeArrivee=Double.parseDouble(request.getParameter("villeArrivee").split(";")[2]);
		Double longitudeArrivee=Double.parseDouble(request.getParameter("villeArrivee").split(";")[1]);
		Double latitudeDepart=Double.parseDouble(request.getParameter("villeDepart").split(";")[2]);
		Double longitudeDepart=Double.parseDouble(request.getParameter("villeDepart").split(";")[1]);
		int r = 6371;
		double p = 0.017453292519943295;  //Pi/180
		double a = 0.5 - Math.cos((latitudeArrivee-latitudeDepart)*p)/2 + Math.cos(latitudeDepart*p)*Math.cos(latitudeArrivee*p) * (1-Math.cos((longitudeArrivee-longitudeDepart)*p)) / 2;

		double d = 2 * r * Math.asin(Math.sqrt(a));
		request.setAttribute("nomDepart",request.getParameter("villeDepart").split(";")[0]);
		request.setAttribute("nomArrivee",request.getParameter("villeArrivee").split(";")[0]);
		request.setAttribute("distance", d);
		doGet(request, response);
	}

}
