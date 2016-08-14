package com.revature.data;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONConverter {
	private ObjectMapper mapper = new ObjectMapper();
	//Single Trainee
	public String getTraineeJSON(Trainee obj) throws JsonProcessingException{
		return mapper.writeValueAsString(obj);
	}
	public Trainee getTraineeJSON(String json) throws JsonParseException, JsonMappingException, IOException{
		return mapper.readValue(json,Trainee.class);
	}

	//Multiples
	public String getTraineeJSONArray(Trainee[] obj) throws JsonProcessingException{
		return mapper.writeValueAsString(obj);
	}
	public Trainee[] getTraineeJSONArray(String json) throws JsonParseException, JsonMappingException, IOException{
		return mapper.readValue(json,Trainee[].class);
	}
}
