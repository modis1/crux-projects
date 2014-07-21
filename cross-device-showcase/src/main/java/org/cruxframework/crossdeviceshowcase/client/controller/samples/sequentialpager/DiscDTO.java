package org.cruxframework.crossdeviceshowcase.client.controller.samples.sequentialpager;

import java.io.Serializable;


public class DiscDTO implements Serializable
{	
	private static final long serialVersionUID = -4135882705373439428L;
	
	private String discName;
	private String artistName;
	private int releaseYear;
	private int stock;
	
	public DiscDTO(String discName, String artistName, int releaseYear, int stock)
	{
		this.discName = discName;
		this.artistName = artistName;
		this.releaseYear = releaseYear;
		this.stock = stock;
	}

	public String getDiscName() {
		return discName;
	}

	public void setDiscName(String discName) {
		this.discName = discName;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(short releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(short stock) {
		this.stock = stock;
	}
}
