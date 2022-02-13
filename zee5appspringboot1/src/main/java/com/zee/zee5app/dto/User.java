package com.zee.zee5app.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.validator.constraints.Length;

import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import java.lang.*;
import java.math.BigDecimal;
import java.math.BigInteger;

//write @Data and then press ctrl+space then enter to get the lombok
@Data
//we use this method to override instead of other one used below coz when we change anything later, it can handle on its own
@EqualsAndHashCode
@ToString

@NoArgsConstructor
//ORM mapping purpose
@Entity //entity class is used for ORM - from javax
//to customize table name
@Table(name = "register",uniqueConstraints= {@UniqueConstraint(columnNames="userName"),@UniqueConstraint(columnNames="email")})
public class User implements Comparable<User>{

	@Id //it will consider this column as primary key
	//camel naming conventions are converted to snake case i.e. reg_id
	@Column(name = "regId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotBlank
	@Size(max=20)
	private String username;

	@Size(max=50)
	@NotNull
	private String firstName;
	
	@Size(max=50)
	@NotNull
	private String lastName;
	
	@Size(max=50)
	@Email
	private String email;
	
	@Size(max=100)

	private String password;
	

	private BigDecimal contactNumber;

	@Override
	public int compareTo(User o) {
		 //TODO Auto-generated method stub
		//ascending
		return this.id.compareTo(o.getId());
	
		//descending order
		//return o.id.compareTo(this.getId())
	}
	@ManyToMany(fetch =FetchType.LAZY)
	@JoinTable(name="User_roles",joinColumns = @JoinColumn(name="regId"),
	inverseJoinColumns=@JoinColumn(name="roleId"))
	
	private Set<Role> roles = new HashSet<>();

	public User(String username,String email,String password,String firstName,String lastName) {
		
		this.username = username;
		this.email = email;
		this.password = password;
		this.firstName=firstName;
		this.lastName=lastName;
	}
	
	
	
	
//	 @OneToOne(mappedBy="register",cascade=CascadeType.ALL)
//	 private List<Subscription> episode=new ArrayList<>();

}