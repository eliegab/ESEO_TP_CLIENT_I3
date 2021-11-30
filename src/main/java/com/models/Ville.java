package com.models;

import org.json.JSONObject;

public class Ville {

	public Ville(JSONObject obj) {
		this.codeCommune=obj.getString("codeCommune");
		this.nomCommune=obj.getString("nomCommune");
		this.codePostal=obj.getString("codePostal");
		this.libelleAcheminement=obj.getString("libelleAcheminement");
		this.ligne=obj.getString("ligne");
		this.latitude=obj.getString("latitude");
		this.longitude=obj.getString("longitude");
	}
	
	public Ville(String codeCommune, String nomCommune, String codePostal, String libelleAcheminement, String ligne, String latitude, String longitude) {
		super();
		this.codeCommune = codeCommune;
		this.nomCommune = nomCommune;
		this.codePostal = codePostal;
		this.libelleAcheminement = libelleAcheminement;
		this.ligne = ligne;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public Ville(String codeCommune, String nomCommune, String codePostal, String libelleAcheminement, String ligne) {
		super();
		this.codeCommune = codeCommune;
		this.nomCommune = nomCommune;
		this.codePostal = codePostal;
		this.libelleAcheminement = libelleAcheminement;
		this.ligne = ligne;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String latitude;
	
	public String longitude;
	
	public String codeCommune;

	public String nomCommune;

	public String codePostal;
	
	public Ville(String codeCommune) {
		super();
		this.codeCommune = codeCommune;
	}

	public Ville(String codeCommune, String nomCommune) {
		super();
		this.codeCommune = codeCommune;
		this.nomCommune = nomCommune;
	}

	public Ville(String codeCommune, String nomCommune, String codePostal) {
		super();
		this.codeCommune = codeCommune;
		this.nomCommune = nomCommune;
		this.codePostal = codePostal;
	}

	public Ville(String codeCommune, String nomCommune, String codePostal, String libelleAcheminement) {
		super();
		this.codeCommune = codeCommune;
		this.nomCommune = nomCommune;
		this.codePostal = codePostal;
		this.libelleAcheminement = libelleAcheminement;
	}

	public Ville() {
		super();
	}

	public String libelleAcheminement;

	public String ligne;

	public String getCodeCommune() {
		return codeCommune;
	}

	public void setCodeCommune(String codeCommune) {
		this.codeCommune = codeCommune;
	}

	public String getNomCommune() {
		return nomCommune;
	}

	public void setNomCommune(String nomCommune) {
		this.nomCommune = nomCommune;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getLibelleAcheminement() {
		return libelleAcheminement;
	}

	public void setLibelleAcheminement(String libelleAcheminement) {
		this.libelleAcheminement = libelleAcheminement;
	}

	public String getLigne() {
		return ligne;
	}

	public void setLigne(String ligne) {
		this.ligne = ligne;
	}

	
}
