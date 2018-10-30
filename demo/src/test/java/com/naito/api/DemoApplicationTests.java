package com.naito.api;

import com.naito.api.Utils.HttpClientUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.URISyntaxException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
		try {
			new HttpClientUtil().efetuarRequisicao();
		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
		}
	}

}
