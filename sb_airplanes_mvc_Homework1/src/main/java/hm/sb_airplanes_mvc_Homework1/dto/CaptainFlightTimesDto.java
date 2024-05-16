package hm.sb_airplanes_mvc_Homework1.dto;

import java.time.Duration;
import java.util.List;

public class CaptainFlightTimesDto {

	String captainName;
	Duration flightTime;
	List<AirplaneDto> flights;
	
	
	public CaptainFlightTimesDto(String captainName, Duration flightTime) {
		super();
		this.captainName = captainName;
		this.flightTime = flightTime;
	}


	public String getCaptainName() {
		return captainName;
	}


	public void setCaptainName(String captainName) {
		this.captainName = captainName;
	}


	public Duration getFlightTime() {
		return flightTime;
	}


	public void setFlightTime(Duration flightTime) {
		this.flightTime = flightTime;
	}

	public void addFlightTime(Duration time) {
		
		this.flightTime = this.flightTime.plus(time);
	}
	
	
	public List<AirplaneDto> getFlights() {
		return flights;
	}


	public void setFlights(List<AirplaneDto> flights) {
		this.flights = flights;
	}


	public boolean hasRouteToStartCityWithTransfer() {
		
		boolean returnValue = false;
		
		for(int index = 0; index < flights.size(); index++) {
			
			AirplaneDto currentAirplaneDto = flights.get(index);
			
			if(currentAirplaneDto.getCaptainName().equals(captainName)) {
				for(int secIndex = index+1; secIndex < flights.size(); secIndex++) {
					
					AirplaneDto nextAirplaneDto = flights.get(secIndex);
					
					if(currentAirplaneDto.getEndTime().isBefore(nextAirplaneDto.getStartTime())) {
						
						if(currentAirplaneDto.getStartCity().equals(nextAirplaneDto.getEndCity()) && (secIndex - index > 1)) {
							
							returnValue = true;
							break;
						}
					}
				}
			}
		}
		
		
		
		return returnValue;
	}
	
	@Override
	public String toString() {
		return "CaptainFlightTimesDto [captainName=" + captainName + ", flightTime=" + flightTime + "]";
	}
	
}
