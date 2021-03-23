package egovframework.com.admin.cmm.web;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AdminEgovComIndexRestControllerTest {

	@Test
	public void test() {
		log.debug("test");

		RestTemplate restTemplate = new RestTemplate();

		String json = restTemplate.getForObject("http://localhost:8080/admin/admin/indexJson.do", String.class);

		log.debug("json={}", json);
	}

	@Test
	public void test2() {
		log.debug("test2");

		RestTemplate restTemplate = new RestTemplate();

		String json = restTemplate.getForObject("http://localhost:8080/admin/api/v1/admin/index.do", String.class);

		log.debug("json={}", json);
	}

	@Test
	public void test3() {
		log.debug("test3");

		RestTemplate restTemplate = new RestTemplate();

		String json = restTemplate.getForObject("http://localhost:8080/admin/uat/uap/selectLoginPolicyList.do",
				String.class);

		log.debug("json={}", json);
	}

}
