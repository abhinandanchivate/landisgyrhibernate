package com.landisgyr.emplmngt;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landisgyr.emplmngt.dto.PatientRecord;
import com.landisgyr.emplmngt.exception.NotFoundException;
import com.landisgyr.emplmngt.repository.PatientRecordRepository;

@WebMvcTest
public class PartientRecordControllerTest {

	@Autowired
	MockMvc mockMvc;
	@Autowired
	ObjectMapper mapper;
	
	@MockBean
	PatientRecordRepository patientRecordRepository;
	
	PatientRecord patientRecord = new PatientRecord(1L, "abhi", 32, "bangalore");
	PatientRecord patientRecord2 = new PatientRecord(2L, "abhinandan", 32, "bangalore");
	PatientRecord patientRecord3 = new PatientRecord(3L, "aadvik", 1, "bangalore");
	
	@Test
	public void deletePatientById_success() throws Exception {
	    Mockito.when(patientRecordRepository.findById(patientRecord2.getPatientId())).thenReturn(Optional.of(patientRecord2));

	    mockMvc.perform(MockMvcRequestBuilders
	            .delete("/patient/2")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk());
	}

	@Test
	public void deletePatientById_notFound() throws Exception {
	    Mockito.when(patientRecordRepository.findById(5l)).thenReturn(null);

	    mockMvc.perform(MockMvcRequestBuilders
	            .delete("/patient/5")
	            .contentType(MediaType.APPLICATION_JSON))
	    .andExpect(status().isBadRequest())
	            .andExpect(result ->
	                    assertTrue(result.getResolvedException() instanceof NotFoundException))
	    .andExpect(result ->
	            assertEquals("Patient with ID 5 does not exist.", result.getResolvedException().getMessage()));
	}
	
	@Test
	public void createRecord_success() throws Exception {
	    PatientRecord record = PatientRecord.builder()
	            .name("advik")
	            .age(1)
	            .address("Pune")
	            .build();

	    Mockito.when(patientRecordRepository.save(record)).thenReturn(record);

	    MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/patient")
	            .contentType(MediaType.APPLICATION_JSON)
	            .accept(MediaType.APPLICATION_JSON)
	            .content(this.mapper.writeValueAsString(record));

	    mockMvc.perform(mockRequest)
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$", notNullValue()))
	            .andExpect(jsonPath("$.name", is("advik")));
	    }
	
	@Test
	public void getPatientById_success() throws Exception {
	    Mockito.when(patientRecordRepository.findById(patientRecord.getPatientId())).thenReturn(java.util.Optional.of(patientRecord));

	    mockMvc.perform(MockMvcRequestBuilders
	            .get("/patient/1")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$", org.hamcrest.Matchers.notNullValue()))
	            .andExpect(jsonPath("$.name", org.hamcrest.Matchers.is("abhi")));
	}
	
	@Test
	public void getAllRecords_success() throws Exception{
		List<PatientRecord> records = new ArrayList<>
		(Arrays.asList(patientRecord,patientRecord2,patientRecord3));
		
		Mockito.when(patientRecordRepository.findAll()).thenReturn(records);
		
		 mockMvc.perform(MockMvcRequestBuilders
		            .get("/patient")
		            .contentType(MediaType.APPLICATION_JSON))
		            .andExpect(status().isOk())
		            .andExpect(jsonPath("$", org.hamcrest.Matchers.hasSize(3)))
		            .andExpect(jsonPath("$[2].name", org.hamcrest.Matchers.is("aadvik")))
		            ;
	}
}
