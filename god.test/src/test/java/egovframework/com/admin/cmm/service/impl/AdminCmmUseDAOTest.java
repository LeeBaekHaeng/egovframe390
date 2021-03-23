package egovframework.com.admin.cmm.service.impl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import egovframework.com.admin.cmm.service.impl.AdminCmmUseDAO;
import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.CmmnDetailCode;
import lombok.extern.slf4j.Slf4j;

@Slf4j

@RunWith(SpringRunner.class)

@ContextConfiguration({ "classpath*:egovframework/spring/com/**/context-*.xml" })
@ActiveProfiles({ "mysql", "dummy" })

@Transactional(readOnly = true)
public class AdminCmmUseDAOTest {

	@Autowired
	AdminCmmUseDAO adminCmmUseDAO;

	@Test
	public void test() {
		log.debug("test");

		// given
		ComDefaultCodeVO vo = new ComDefaultCodeVO();
		vo.setCodeId("COM001");

		// when
		List<CmmnDetailCode> results = new ArrayList<>();
		try {
			results = adminCmmUseDAO.selectCmmCodeDetail(vo);
		} catch (Exception e) {
			log.error(e.getMessage());
		}

		// then
		assertEquals(results.get(0).getCodeId(), vo.getCodeId());

		log.debug("results={}", results);
		log.debug("size={}", results.size());
	}

}
