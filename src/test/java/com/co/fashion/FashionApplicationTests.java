package com.co.fashion;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class FashionApplicationTests {

	@Test
	void contextLoads() {
		int n = 1+2;
		log.info("{}", n);
	}

}
