package itsol_project.itsolwebserver.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role_user")
@Getter
@Setter
public class Role_user extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column( name = "user_id")
	private Long user_id;
	@Column ( name = "role_id")
	private Long role_id;
	
	public Role_user(Long user_id, Long role_id) {
		this.user_id = user_id;
		this.role_id = role_id;
	}
}
