package hm.sb_airplanes_mvc_Homework1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hm.sb_airplanes_mvc_Homework1.database.Database;
import hm.sb_airplanes_mvc_Homework1.dto.AirplaneDto;
import hm.sb_airplanes_mvc_Homework1.dto.AirplaneDtoList;
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
	
	
}
