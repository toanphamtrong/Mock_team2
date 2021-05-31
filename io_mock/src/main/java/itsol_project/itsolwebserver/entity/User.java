package itsol_project.itsolwebserver.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import itsol_project.itsolwebserver.dto.UserDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( name = "user",
uniqueConstraints = {
		@UniqueConstraint(columnNames = "username"),
		@UniqueConstraint(columnNames = "email")
})
@EntityListeners(AuditingEntityListener.class)
public class User extends BaseEntity {
    @Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "username", length = 18)
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "email", length = 100)
	private String email;
	@Column(name = "fullname", length = 50)
	private String fullname;
	@Column(name = "phone", length = 15)
	private String phone;
	@Column(name = "address")
	private String address;
	@Column(name = "birthday")
	private Date birthday;
	@Column( name = "status", nullable = false)
	private int status;
	public UserDto toDTO(User user) {
		UserDto dto = new UserDto();
		dto.setId(user.getId());
		dto.setUsername(user.getUsername());
		dto.setPassword(user.getPassword());
		dto.setFullname(user.getFullname());
		dto.setEmail(user.getEmail());
		dto.setBirthday(user.getBirthday());
		dto.setAddress(user.getAddress());
		dto.setPhoneNumber(user.getPhone());
		dto.setStatus(user.getStatus());
		dto.setCreatedDate(user.getCreatedDate());
		return dto;
	}
	public User(String username, String password, String email, String fullname, Date birthDay, String address, String phone,  int status) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.fullname = fullname;
		this.birthday = birthDay;
		this.address = address;
		this.phone = phone;
		this.status = status;
	}
}
