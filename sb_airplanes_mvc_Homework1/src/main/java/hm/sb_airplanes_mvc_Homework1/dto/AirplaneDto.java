package hm.sb_airplanes_mvc_Homework1.dto;

import java.time.LocalDateTime;

public class AirplaneDto {

	private String startCity;
	private LocalDateTime startTime;
	private String endCity;
	private LocalDateTime endTime;
	private String flightNumber;
	private String captainName;
	
	
	public AirplaneDto(String startCity, LocalDateTime startTime, String endCity, LocalDateTime endTime,
			String flightNumber, String captainName) {
		super();
		this.startCity = startCity;
		this.startTime = startTime;
		this.endCity = endCity;
		this.endTime = endTime;
		this.flightNumber = flightNumber;
		this.captainName = captainName;
	}


	public String getStartCity() {
		return startCity;
	}


	public void setStartCity(String startCity) {
		this.startCity = startCity;
	}


	public LocalDateTime getStartTime() {
		return startTime;
	}


	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}


	public String getEndCity() {
		return endCity;
	}


	public void setEndCity(String endCity) {
		this.endCity = endCity;
	}


	public LocalDateTime getEndTime() {
		return endTime;
	}


	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}


	public String getFlightNumber() {
		return flightNumber;
	}


	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}


	public String getCaptainName() {
		return captainName;
	}


	public void setCaptainName(String captainName) {
		this.captainName = captainName;
	}


	@Override
	public String toString() {
		return "AirplaneDto [startCity=" + startCity + ", startTime=" + startTime + ", endCity=" + endCity
				+ ", endTime=" + endTime + ", flightNumber=" + flightNumber + ", captainName=" + captainName + "]";
	}
	
}
