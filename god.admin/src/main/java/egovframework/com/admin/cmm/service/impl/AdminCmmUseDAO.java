package egovframework.com.admin.cmm.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.CmmnDetailCode;
import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class AdminCmmUseDAO extends EgovComAbstractDAO {

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<CmmnDetailCode> selectCmmCodeDetail(ComDefaultCodeVO vo) throws Exception {
		return (List<CmmnDetailCode>) list("AdminCmmUseDAO.selectCmmCodeDetail", vo);
	}

}
