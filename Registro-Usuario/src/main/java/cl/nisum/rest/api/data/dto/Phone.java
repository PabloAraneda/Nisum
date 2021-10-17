package cl.nisum.rest.api.data.dto;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="phone")
public class Phone {

	@Id
    @GeneratedValue
    private UUID id;
	private Integer number;
	private Integer cityCode;
	private Integer contryCode;
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_phone_user_id"), name="user_id", referencedColumnName = "id", columnDefinition = "varchar(255)", nullable = false)
	private User user;
	
	public Phone() {
	}

	public Phone(UUID id, Integer number, Integer cityCode, Integer contryCode, User user) {
		this.id = id;
		this.number = number;
		this.cityCode = cityCode;
		this.contryCode = contryCode;
		this.user = user;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getCityCode() {
		return cityCode;
	}

	public void setCityCode(Integer cityCode) {
		this.cityCode = cityCode;
	}

	public Integer getContryCode() {
		return contryCode;
	}

	public void setContryCode(Integer contryCode) {
		this.contryCode = contryCode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
