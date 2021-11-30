package com.servlets;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
 * Servlet implementation class VillesServlet
 */
public class VillesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VillesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page=1;
		if(request.getParameter("page") != null) page = Integer.parseInt(request.getParameter("page"));
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
		page=Math.min(page, tabledContent.length/50+1);
		page=Math.max(1, page);
		for (int i = (page-1)*50;i<Math.min(tabledContent.length,page*50);i++) {
			String entry=tabledContent[i];
			if(entry.charAt(0)!='{') entry="{"+entry;
			if(entry.charAt(entry.length()-1)!='}') entry=entry+"}";
			JSONObject ob = new JSONObject(entry);
			listOfCities.add(new Ville(ob));
		}
		request.setAttribute("listCities", listOfCities);
		request.setAttribute("page", page);
		request.setAttribute("lastPage", page==tabledContent.length/50+1);
		request.getRequestDispatcher("villes.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
