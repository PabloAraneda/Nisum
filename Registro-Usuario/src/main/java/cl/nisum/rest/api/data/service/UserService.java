package cl.nisum.rest.api.data.service;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.nisum.rest.api.data.dto.Phone;
import cl.nisum.rest.api.data.dto.User;
import cl.nisum.rest.api.data.repository.UserRepository;

@Service
public class UserService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PhoneService phoneService;

	public List<User> getAll() {
		return this.userRepository.findAll();
	}

	public User save(User user) {
		User usuario = new User();
		UUID token = UUID.randomUUID();
		user.setToken(token.toString());
		List<Phone> lsPhone = user.getPhones();
		user.setPhones(null);
		usuario = this.userRepository.save(user);
		for (Phone phone : lsPhone) {
			phone.setUser(user);
		}
		lsPhone = this.phoneService.saveAll(lsPhone);
		user.setPhones(lsPhone);
		return usuario;
	}

	public List<User> saveAll(List<User> lstUser) {
		return this.userRepository.saveAll(lstUser);
	}
}
