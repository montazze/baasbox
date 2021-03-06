package com.baasbox.controllers;

import play.mvc.Results.Status;
import play.mvc.Results;

public enum CustomHttpCode {
			SESSION_TOKEN_EXPIRED (40101,401,"Authentication info not valid or not provided. HINT: is your session expired?","error");
			
			private String type;
			private int bbCode;
			private int httpCode;
			private String description;

			private CustomHttpCode(int bbCode, int httpCode, String description, String type){
				this.bbCode=bbCode;
				this.httpCode=httpCode;
				this.description=description;
				this.type=type;
			}
			
			public String getType() {
				return type;
			}
			
			public int getBbCode(){
				return this.bbCode;
			}
			
			public int gethttpCode(){
				return this.httpCode;
			}
			
			public String gedescription(){
				return this.description;
			}
			
			public Status getStatus(){
				return Results.status(this.bbCode, this.description);
			}
			
			public static CustomHttpCode getFromBbCode(int bBcode){
				for (CustomHttpCode v: values()){
					if (v.getBbCode()==bBcode) return v;
				}
				return null;
			}
			
}
