package cl.nisum.rest.api.data.listener;

import java.util.Date;

import javax.persistence.PrePersist;

import org.springframework.stereotype.Component;

import cl.nisum.rest.api.data.dto.User;

@Component
public class UserListener {

	@PrePersist
	public void onPrePrist(final User user) {
		user.setCreated(new Date());
		user.setModified(new Date());
		user.setLastLogin(new Date());
		user.setIsActive(true);
	}
}
