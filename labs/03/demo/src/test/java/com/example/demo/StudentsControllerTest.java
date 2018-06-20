//package com.example.demo;
//
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(StudentController.class)
//public class StudentsControllerTest {
//
//	   @Autowired
//	    private MockMvc mockMvc;
//
//	   
//	   
//	   @Test
//	    public void getRecordWhenRequestingIdReturnRecordDTO() throws Exception{
//	        
//	        Record record = getRecord();
//	 
//	        given(this.service.findById(ID)).willReturn(Mapper.getRecordDTO(record));
//	 
//	        //@formatter:off
//	        this.mockMvc.perform(
//	                            get(PATH + Constants.SLASH + ID)
//	                            .accept(MediaType.APPLICATION_JSON)
//	                   ).andDo(print())
//	                    .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
//	                    .andExpect(status().isOk())
//	                    .andExpect(jsonPath("$.id", equalTo(record.getId().intValue())))
//	                    .andExpect(jsonPath("$.xsdId", equalTo(record.getXsdId().intValue())))
//	                    .andExpect(jsonPath("$.disable", equalTo(record.getDisable().getValue())))
//	                    .andExpect(jsonPath("$.json", equalTo(record.getJson())))
//	                    .andExpect(jsonPath("$.eventId", equalTo(record.getEventId().intValue())))
//	                    .andExpect(jsonPath("$.initials", equalTo(record.getEvent().getInitials())))
//	                    .andExpect(jsonPath("$.eventDescription", equalTo(record.getEvent().getDescription())))
//	                    .andExpect(jsonPath("$.type", equalTo(record.getEvent().getType().getValue())))
//	                    .andExpect(jsonPath("$.employerId", equalTo(record.getEmployerId().intValue())))
//	                    .andExpect(jsonPath("$.recordStatusId", equalTo(record.getRecordStatusId().intValue())))
//	                    .andExpect(jsonPath("$.identifierType", equalTo(record.getEmployer().getIdentifierType())))
//	                    .andExpect(jsonPath("$.cpfCnpj", equalTo(record.getEmployer().getCpfCnpj())))
//	                    .andExpect(jsonPath("$.employerDescription", equalTo(record.getEmployer().getDescription())))
//	                    .andExpect(jsonPath("$.userId", equalTo(record.getRecordStatus().getUserId().intValue())))
//	                    .andExpect(jsonPath("$.createdAt", equalTo(record.getRecordStatus().getCreatedAt().toString())))
//	                    .andExpect(jsonPath("$.statusId", equalTo(record.getRecordStatus().getStatusId().intValue())))
////	                    .andExpect(jsonPath("$.statusDescription", equalTo(record.getRecordStatus().getStatus().getDescription())))
//	                    .andExpect(jsonPath("$.workerId", equalTo(record.getWorkerId().intValue())))
//	                    .andExpect(jsonPath("$.cpf", equalTo(record.getWorker().getCpf())))
//	                    .andExpect(jsonPath("$.workerDescription", equalTo(record.getWorker().getDescription())))
//	                    ;
//	        //@formatter:on
//	    }
//}
