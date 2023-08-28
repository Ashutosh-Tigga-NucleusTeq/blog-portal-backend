package com.example.demo.exception;

public class UserRegistrationException extends RuntimeException{
		private long statusCode;
		private String message;
		
		@Override
		public String toString() {
			return "UserRegistrationException [statusCode=" + statusCode + ", message=" + message + "]";
		}

		public long getStatusCode() {
			return statusCode;
		}

		public void setStatusCode(long statusCode) {
			this.statusCode = statusCode;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public UserRegistrationException(long statusCode, String message) {
			super();
			this.statusCode = statusCode;
			this.message = message;
		}

		public UserRegistrationException() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		
}
