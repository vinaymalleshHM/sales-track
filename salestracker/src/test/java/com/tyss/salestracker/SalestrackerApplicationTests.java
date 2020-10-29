package com.tyss.salestracker;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest
class SalestrackerApplicationTests {


    @LocalServerPort
    int randomServerPort;
    
	@Test
	void contextLoads() {
	}

}
