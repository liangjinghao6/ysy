package com.safety.lejane.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy({ @ContextConfiguration(name = "parent", locations = "classpath:./spring/applicationContext.xml") })
@Transactional
public class AbstractTest {
	@Autowired
	private WebApplicationContext wac;
	
	protected MockMvc mockMvc;
//	private MockHttpServletRequestBuilder builder;
	
	protected static HttpHeaders httpHeaders;
	
	ObjectMapper objectMapper = new ObjectMapper();
	
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac)
				.alwaysExpect(MockMvcResultMatchers.status().isOk())
				.alwaysDo(MockMvcResultHandlers.print())
				.build();
		if(httpHeaders == null) {
			httpHeaders = new HttpHeaders();
			httpHeaders.add("safetyId", "100088");
			httpHeaders.add("token", "19g75aiy638v11noapclwmqvan");			
		}
	}

	protected String getContent(String filename) {
		String pkg = getClass().getPackage().getName();
		
		String file = pkg.replaceAll("\\.", "/") + "/" + filename + ".json";
		
		return ReaderTest.reader(file);
	}
	
	protected RequestBuilder getBuilder(String url,
			String fileName) {
		MockHttpServletRequestBuilder builder =	MockMvcRequestBuilders.post(url).headers(httpHeaders);
		
		Map<?, ?> paramMap = null;
		try {
			paramMap = objectMapper.readValue(getContent(fileName), HashMap.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		if (! paramMap.isEmpty()) {
			Set<?> keySet = paramMap.keySet();
			for (Object key: keySet) {
				builder = builder.param(key + "", paramMap.get(key) + "");
			}
		}
		return builder;
	}
}
