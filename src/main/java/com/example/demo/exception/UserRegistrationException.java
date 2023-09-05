package com.example.demo.exception;

public class UserRegistrationException extends RuntimeException{
		/**
	 * sesrialVersionUID field
	 */
	private static final long serialVersionUID = 1L;
		private String message;
		
		@Override
		public String toString() {
			return "UserRegistrationException [ message=" + message + "]";
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public UserRegistrationException( String message) {
			super();
			this.message = message;
		}

		public UserRegistrationException() {
			super();
			// TODO Auto-generated constructor stub
		}
}
