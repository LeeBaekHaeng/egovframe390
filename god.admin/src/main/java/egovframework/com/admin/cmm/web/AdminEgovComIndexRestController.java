package egovframework.com.admin.cmm.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import egovframework.com.admin.cmm.service.impl.AdminCmmUseDAO;
import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.CmmnDetailCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AdminEgovComIndexRestController {

	private final AdminCmmUseDAO adminCmmUseDAO;

	@GetMapping("/api/v1/admin/index.do")
	public List<CmmnDetailCode> index() {
		ComDefaultCodeVO vo = new ComDefaultCodeVO();
		vo.setCodeId("COM001");

		try {
			return adminCmmUseDAO.selectCmmCodeDetail(vo);
		} catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}
	}

}
