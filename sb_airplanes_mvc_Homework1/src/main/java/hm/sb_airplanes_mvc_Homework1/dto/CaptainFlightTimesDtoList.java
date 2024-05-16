package hm.sb_airplanes_mvc_Homework1.dto;

import java.util.List;

public class CaptainFlightTimesDtoList {

	private List<CaptainFlightTimesDto> captainFlightDtos;

	public CaptainFlightTimesDtoList(List<CaptainFlightTimesDto> captainFlightDtos) {
		super();
		this.captainFlightDtos = captainFlightDtos;
	}

	public List<CaptainFlightTimesDto> getCaptainFlightDtos() {
		return captainFlightDtos;
	}

	public void setCaptainFlightDtos(List<CaptainFlightTimesDto> captainFlightDtos) {
		this.captainFlightDtos = captainFlightDtos;
	}

	@Override
	public String toString() {
		return "CaptainFlightTimesDtoList [captainFlightDtos=" + captainFlightDtos + "]";
	}
	
}
