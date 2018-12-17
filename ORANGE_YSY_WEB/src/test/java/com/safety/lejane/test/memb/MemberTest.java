package com.safety.lejane.test.memb;

import java.io.File;
import java.io.FileInputStream;
import java.net.URI;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.safety.lejane.test.AbstractTest;

public class MemberTest extends AbstractTest{

	@Test
	public void testMemberPage() throws Exception {
		mockMvc.perform(getBuilder("/memb/page/v1", "MemberPage"));
	}
	
	@Test
	public void testMemberDetail() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/memb/detail/v1").headers(httpHeaders).param("membId", "4"));
	}

	@Test
	public void testMemberTotal() throws Exception {
		mockMvc.perform(getBuilder("/memb/page/v1", "MemberPage"));
	}
	
	@Test
	@Rollback(true)
	public void testMemberAdd() throws Exception {
		mockMvc.perform(getBuilder("/memb/add/v1", "MemberAdd"));
	}
	
	@Test
	@Rollback(true)
	public void testMemberUpdate() throws Exception {
		mockMvc.perform(getBuilder("/memb/update/v1", "MemberAdd"));
	}

	@Test
	@Rollback(true)
	public void testArchiveUpload() throws Exception {
		MockMultipartFile f = new MockMultipartFile("file", "tt.xlsx", "utf-8", new FileInputStream(new File("d://tt.xlsx")));
		mockMvc.perform(
				MockMvcRequestBuilders
						.fileUpload("/memb/archive/upload/v1")
						.file(f)
						.headers(httpHeaders)
						.param("addCompId", "1"));
	}

//
//	@Test
//	public void testArchiveDownload() throws Exception {
//		mockMvc.perform(MockMvcRequestBuilders.get("/memb/archive/download/v1").headers(httpHeaders).param("fbIds", "3,4"));
//	}
//	
//	@Test
//	public void testArchiveFailDownload() throws Exception {
//		mockMvc.perform(MockMvcRequestBuilders.get("/memb/archive/fail/download/v1").headers(httpHeaders).param("fbIds", "3,4"));
//	}
//	
//	@Test
//	@Rollback(true)
//	public void testArchiveAdd() throws Exception {
//		mockMvc.perform(MockMvcRequestBuilders.get("/memb/archive/add/v1").headers(httpHeaders).param("fbIds", "3,4"));
//	}
//	
//	@Test
//	@Rollback(true)
//	public void testArchiveUpdate() throws Exception {
//		mockMvc.perform(MockMvcRequestBuilders.get("/memb/archive/update/v1").headers(httpHeaders).param("fbIds", "3,4"));
//	}
//	
//	@Test
//	public void testArchiveDetail() throws Exception {
//		mockMvc.perform(MockMvcRequestBuilders.get("/memb/archive/detail/v1").headers(httpHeaders).param("fbIds", "3,4"));
//	}
//	
//	@Test
//	public void testFamilyList() throws Exception {
//		mockMvc.perform(MockMvcRequestBuilders.get("/memb/family/list/v1").headers(httpHeaders).param("fbIds", "3,4"));
//	}
//	
//	
//	@Test
//	@Rollback(true)
//	public void testFamilyAdd() throws Exception {
//		mockMvc.perform(MockMvcRequestBuilders.get("/memb/family/add/v1").headers(httpHeaders).param("fbIds", "3,4"));
//	}
//	
//	@Test
//	@Rollback(true)
//	public void testFamilyUpdate() throws Exception {
//		mockMvc.perform(MockMvcRequestBuilders.get("/memb/family/update/v1").headers(httpHeaders).param("fbIds", "3,4"));
//	}
//	
//	@Test
//	@Rollback(true)
//	public void testFamilyDelete() throws Exception {
//		mockMvc.perform(MockMvcRequestBuilders.get("/memb/family/delete/v1").headers(httpHeaders).param("fbIds", "3,4"));
//	}
}
