package egovframework.com.admin.cmm.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.com.admin.cmm.service.impl.AdminCmmUseDAO;
import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.CmmnDetailCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class AdminEgovComIndexController {

	private final AdminCmmUseDAO adminCmmUseDAO;

	@RequestMapping("/admin/index.do")
	public String index(ModelMap model) {
		ComDefaultCodeVO vo = new ComDefaultCodeVO();
		vo.setCodeId("COM001");

		List<CmmnDetailCode> results = new ArrayList<>();
		try {
			results = adminCmmUseDAO.selectCmmCodeDetail(vo);
		} catch (Exception e) {
			log.error(e.getMessage());
		}

		log.debug("results={}", results);
		log.debug("size={}", results.size());

		return "egovframework/com/cmm/EgovUnitMain";
	}

}
