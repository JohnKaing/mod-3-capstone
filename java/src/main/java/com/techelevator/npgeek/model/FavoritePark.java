package com.techelevator.npgeek.model;

public class FavoritePark {

	private String parkCode = "";
	private int count = 0;
	
	public FavoritePark(String parkCode, int count) {
		this.parkCode = parkCode;
		this.count = count;
	}
	/**
	 * @return the parkCode
	 */
	public String getParkCode() {
		return parkCode;
	}
	/**
	 * @param parkCode the parkCode to set
	 */
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}
	
}
