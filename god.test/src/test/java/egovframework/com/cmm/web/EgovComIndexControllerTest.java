package egovframework.com.cmm.web;

import static org.junit.Assert.assertEquals;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.CmmnDetailCode;
import egovframework.com.cmm.service.impl.CmmUseDAO;
import lombok.extern.slf4j.Slf4j;

@Slf4j

@RunWith(SpringRunner.class)

@WebAppConfiguration

@ContextConfiguration({ "classpath*:egovframework/spring/com/**/context-*.xml",
		"file:../god.egov/src/main/webapp/WEB-INF/config/egovframework/springmvc/egov-com-servlet.xml" })

@ActiveProfiles({ "mysql", "dummy" })

@Transactional(readOnly = true)
public class EgovComIndexControllerTest {

	@Autowired
	CmmUseDAO cmmUseDAO;

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void test() {
		log.debug("test");

		// given
		ComDefaultCodeVO vo = new ComDefaultCodeVO();
		vo.setCodeId("COM001");

		// when
		List<CmmnDetailCode> results = new ArrayList<>();
		try {
			results = cmmUseDAO.selectCmmCodeDetail(vo);
		} catch (Exception e) {
			log.error(e.getMessage());
		}

		// then
		assertEquals(results.get(0).getCodeId(), vo.getCodeId());

		log.debug("results={}", results);
		log.debug("size={}", results.size());
	}

	@Test
	public void test2() {
		log.debug("test2");

		try {
// @formatter:off
//			this.mockMvc.perform(get("/accounts/1").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
//			.andExpect(status().isOk())
//			.andExpect(content().contentType("application/json"))
//			.andExpect(jsonPath("$.name").value("Lee"));

			this.mockMvc.perform(get("/index.do").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
			.andExpect(status().isOk());
// @formatter:on

		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

}
