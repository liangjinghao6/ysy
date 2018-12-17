package com.safety.lejane.test.info;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.safety.lejane.test.AbstractTest;

public class InfomationTest extends AbstractTest{

	@Test
	public void testFbPage() throws Exception {
		mockMvc.perform(getBuilder("/fb/page/v1", "FeedBackPage"));
	}
	
	@Test
	public void testFbDetail() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/fb/detail/v1").headers(httpHeaders).param("fbId", "4"));
	}

	@Test
	@Rollback(true)
	public void testFbAdd() throws Exception {
		mockMvc.perform(getBuilder("/fb/add/v1", "FeedBackAdd"));
	}
	
	@Test
	@Rollback(true)
	public void testFbUpdate() throws Exception {
		mockMvc.perform(getBuilder("/fb/update/v1", "FeedBackAdd"));
	}


	@Test
	@Rollback(true)
	public void testFbDelete() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/fb/delete/v1").headers(httpHeaders).param("fbIds", "3,4"));
	}
}
