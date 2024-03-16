package com.app.homerepairs.reponse;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.app.homerepairs.model.AppUser;
import com.app.homerepairs.model.Seller;
import com.app.homerepairs.model.SellerServiceInfo;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeneralResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String phoneNumber;
	private String message;
	private String timestamp;
    private HttpStatus status;
    private String error;
    private String path;
    private AppUser appUser;
    private Seller seller;
    private BigDecimal totalAmount;
    private Integer totalItems;
    List<SellerServiceInfo> sellerService = new ArrayList<>();
    
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

	public AppUser getAppUser() {
		return appUser;
	}
	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public List<SellerServiceInfo> getSellerService() {
		return sellerService;
	}

	public void setSellerService(List<SellerServiceInfo> sellerService) {
		this.sellerService = sellerService;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Integer getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(Integer totalItems) {
		this.totalItems = totalItems;
	}
	
	
}
