package cl.nisum.rest.api.data.dto;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import cl.nisum.rest.api.data.listener.UserListener;


@Entity
@Table(name="user")
@EntityListeners(UserListener.class)
public class User {

	@Id
    @GeneratedValue
    private UUID id;
	@JsonProperty(access = Access.WRITE_ONLY)
	private String name;
	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(name="email", unique=true)
	@NotEmpty(message = "Email es obligatorio.")
    @Pattern(regexp = "^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$", message = "Email debe ser valido")
	private String email;
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	private String token;
	private Date created;
	private Date modified;
	@Column(name="last_login", unique=false)
	private Date lastLogin;
	private Boolean isActive;
	@OneToMany(mappedBy = "user", cascade=CascadeType.ALL, orphanRemoval = true)
	private List<Phone> phones;
	
	public User() {
	}

	public User(UUID id, String name, String email, String password, String token, Date created, Date modified,
			Date lastLogin, Boolean isActive, List<Phone> phones) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.token = token;
		this.created = created;
		this.modified = modified;
		this.lastLogin = lastLogin;
		this.isActive = isActive;
		this.phones = phones;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}
	
}
