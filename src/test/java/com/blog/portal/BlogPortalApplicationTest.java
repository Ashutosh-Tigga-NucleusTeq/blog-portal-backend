package com.blog.portal;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogPortalApplicationTest {

	@Test
	void contextLoads() {
		assertTrue(true);
	}

	@Test
	public void main() {
		BlogPortalApplication.main(new String[] {});
	}

}
