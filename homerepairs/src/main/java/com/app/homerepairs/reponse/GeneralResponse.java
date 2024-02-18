package com.app.homerepairs.reponse;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.app.homerepairs.model.AppUser;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeneralResponse {

	private String message;
	private String timestamp;
    private HttpStatus status;
    private String error;
    private String path;
    
    //by default if zero constructor are present
    public GeneralResponse() {
		super();
	}
    
	public GeneralResponse(String message, HttpStatus status, List<AppUser> list) {
		super();
		this.message = message;
		this.status = status;
		this.list = list;
	}

	public GeneralResponse(String message, String timestamp, HttpStatus status, String error, String path, List<?> list) {
		super();
		this.message = message;
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.path = path;
		this.list = list;
	}
	List<?> list = new ArrayList<>();
    
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	}
	
    
	
}
