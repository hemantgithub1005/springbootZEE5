package com.zee.zee5app.dto;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.zee.zee5app.Utils.CustomListSerializer;
import com.zee.zee5app.dto.EROLE;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="login")
public class Login {
	
	
	
	@Id
	@Email
	private String userName;
	private String password;
	
	
//	@OneToOne(fetch = FetchType.LAZY) 
////	@JsonIgnoreProperties("hibernateLazyInitializer","handler")
	
	
	    @OneToOne
        @JsonIgnoreProperties("\"hibernateLazyInitializer\",\"handler\"")
//	    @JsonSerialize(using=CustomListSerializer.class)
	    @JsonProperty(access=Access.WRITE_ONLY)
	    @JoinColumn(name = "regId")
		private User register;
	
	
//	public Login(String userName, String password, String regId, ROLE role) {
//		super();
//		this.userName = userName;
//		this.password = password;
//		this.regId = regId;
//		this.role = role;
//	}
//
//	public Login() {
//		// TODO Auto-generated constructor stub
//	}
//
//	@Override
//	public int compareTo(Login o) {
//		// TODO Auto-generated method stub
//		return this.regId.compareTo(o.getRegId());
//	}
//	
// 

}