package com.blog.portal.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class EmptyDataExceptionTest {

	@Test
	void testEmptyDataException() {
		String message = "No Record Found";
		EmptyDataException exception = new EmptyDataException(message);
		assertEquals(message,exception.getMessage());
	}

}
