package hm.sb_airplanes_mvc_Homework1.dto;

import java.util.List;

public class AirplaneDtoList {

	private List<AirplaneDto> airplaneDtoList;

	public AirplaneDtoList(List<AirplaneDto> airplaneDtoList) {
		super();
		this.airplaneDtoList = airplaneDtoList;
	}

	public List<AirplaneDto> getAirplaneDtoList() {
		return airplaneDtoList;
	}

	public void setAirplaneDtoList(List<AirplaneDto> airplaneDtoList) {
		this.airplaneDtoList = airplaneDtoList;
	}

	@Override
	public String toString() {
		return "AirplaneDtoList [airplaneDtoList=" + airplaneDtoList + "]";
	}
	
	public void orderFlights() {
		
		for(int index = 0; index < this.airplaneDtoList.size(); index++) {
			
			AirplaneDto currentAirplaneDto = this.airplaneDtoList.get(index);
			
			for(int secIndex = index+1; secIndex < this.airplaneDtoList.size(); secIndex++) {
				
				AirplaneDto nextAirplaneDto = this.airplaneDtoList.get(secIndex);
				
				if(currentAirplaneDto.getStartTime().isAfter(nextAirplaneDto.getStartTime())) {
					
					this.airplaneDtoList.set(secIndex, currentAirplaneDto);
					this.airplaneDtoList.set(index, nextAirplaneDto);
					index--;
					break;
				}
			}
		}
		
	}
	
	
	
}
