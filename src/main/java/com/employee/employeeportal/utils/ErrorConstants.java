package com.employee.employeeportal.utils;

public enum ErrorConstants {
	
		EMPL_REG_FAIL(100, "Employee Registration Failed."), 
		EMPL_FETCH_FAIL(101, "Employee Fetch Failed.");
	
		private int errorCode;
		private String errorMsg;
		
		public int getErrorCode() {
			return errorCode;
		}
		public void setErrorCode(int errorCode) {
			this.errorCode = errorCode;
		}
		public String getErrorMsg() {
			return errorMsg;
		}
		public void setErrorMsg(String errorMsg) {
			this.errorMsg = errorMsg;
		}
		
		private ErrorConstants(int errorCode, String errorMsg) {
			this.errorCode = errorCode;
			this.errorMsg = errorMsg;
		}
}
