package hm.sb_airplanes_mvc_Homework1.model;


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "airplanes")
public class Airplane {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "startcity")
	private String startCity;
	
	@Column(name = "starttime")
	private LocalDateTime startTime;
	
	@Column(name = "endcity")
	private String endCity;
	
	@Column(name = "endtime")
	private LocalDateTime endTime;
	
	@Column(name = "flightnumber")
	private String flightNumber;
	
	@Column(name = "captainname")
	private String captainName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "Airplane [id=" + id + ", startCity=" + startCity + ", startTime=" + startTime + ", endCity=" + endCity
				+ ", endTime=" + endTime + ", flightNumber=" + flightNumber + ", captainName=" + captainName + "]";
	}
	
}
