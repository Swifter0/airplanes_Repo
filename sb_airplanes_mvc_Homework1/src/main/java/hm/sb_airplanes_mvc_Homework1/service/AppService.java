package hm.sb_airplanes_mvc_Homework1.service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hm.sb_airplanes_mvc_Homework1.database.Database;
import hm.sb_airplanes_mvc_Homework1.dto.AirplaneDto;
import hm.sb_airplanes_mvc_Homework1.dto.AirplaneDtoList;
import hm.sb_airplanes_mvc_Homework1.dto.CaptainFlightTimesDto;
import hm.sb_airplanes_mvc_Homework1.dto.CaptainFlightTimesDtoList;
import hm.sb_airplanes_mvc_Homework1.model.Airplane;

@Service
public class AppService {

	private Database db;

	@Autowired
	public AppService(Database db) {
		super();
		this.db = db;
	}

	public AirplaneDtoList getAllFlights() {
		
		AirplaneDtoList dtoList = null;
		List<AirplaneDto> airplaneDtos = new ArrayList<>();
		List<Airplane> airplanes = db.getAllFlights();
		
		for(int index = 0; index < airplanes.size(); index++) {
			
			Airplane currentAirplane = airplanes.get(index);
			
			
			AirplaneDto currentAirplaneDto = new AirplaneDto(
					currentAirplane.getStartCity(),
					currentAirplane.getStartTime(),
					currentAirplane.getEndCity(),
					currentAirplane.getEndTime(),
					currentAirplane.getFlightNumber(),
					currentAirplane.getCaptainName()
					);
			airplaneDtos.add(currentAirplaneDto);
		}
		
		dtoList = new AirplaneDtoList(airplaneDtos);
		dtoList.orderFlights();
		
		return dtoList;
	}

	public CaptainFlightTimesDtoList getCaptainFlightTimes() {
		
		CaptainFlightTimesDtoList captainDtoList = null;
		List<CaptainFlightTimesDto> captainFlightTimes = new ArrayList<>();
		
		List<Airplane> airplaneList = db.getAllFlights();
		
		for(int index = 0; index < airplaneList.size(); index++) {
			
			Airplane currentAirplane = airplaneList.get(index);
			Duration duration = Duration.between(currentAirplane.getStartTime(), currentAirplane.getEndTime());
			CaptainFlightTimesDto currentCaptainDto = new CaptainFlightTimesDto(
					currentAirplane.getCaptainName(),
					duration
					);
			
			boolean contained = false;
			
			for(int secIndex = 0; secIndex < captainFlightTimes.size(); secIndex++) {
				
				CaptainFlightTimesDto currentDto = captainFlightTimes.get(secIndex);
				
				if(currentDto.getCaptainName().equals(currentCaptainDto.getCaptainName())) {
					
					currentDto.addFlightTime(duration);
					contained = true;
					break;
				}
				
			}
			
			if(contained == false) {
				
				captainFlightTimes.add(currentCaptainDto);
				
			}
			
		}
		
		captainDtoList = new CaptainFlightTimesDtoList(captainFlightTimes);
		
		
		return captainDtoList;
	}

	public CaptainFlightTimesDtoList getCaptainsWithTransport() {
		
		CaptainFlightTimesDtoList captainDto = null;
		List<CaptainFlightTimesDto> captainDtoList = new ArrayList<>();
		
		AirplaneDtoList airplaneDtos = getAllFlights();
		List<AirplaneDto> airplaneDtoList = airplaneDtos.getAirplaneDtoList();
		
		for(int index = 0; index < airplaneDtoList.size(); index++) {
			
			AirplaneDto currentAirplaneDto = airplaneDtoList.get(index);
			Duration duration = Duration.between(currentAirplaneDto.getStartTime(), currentAirplaneDto.getEndTime());
			CaptainFlightTimesDto currentCaptainDto = new CaptainFlightTimesDto(
					currentAirplaneDto.getCaptainName(),
					duration
					);
			currentCaptainDto.setFlights(airplaneDtoList);
			
			if(currentCaptainDto.hasRouteToStartCityWithTransfer()) {
				
				boolean contained = false;
				
				for(int secIndex = 0; secIndex < captainDtoList.size(); secIndex++) {
					
					CaptainFlightTimesDto currentDto = captainDtoList.get(secIndex);
					if(currentCaptainDto.getCaptainName().equals(currentDto.getCaptainName())) {
						
						contained = true;
						
					}
				}
				
				if(contained == false) {
					captainDtoList.add(currentCaptainDto);	
				}
				
			}
		}
		
		captainDto = new CaptainFlightTimesDtoList(captainDtoList);
		
		return captainDto;
	}
	
	
}
