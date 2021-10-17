package cl.nisum.rest.api.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.nisum.rest.api.data.dto.Phone;
import cl.nisum.rest.api.data.repository.PhoneRepository;

@Service
public class PhoneService {

	@Autowired
	PhoneRepository phoneRepository;

	public List<Phone> saveAll(List<Phone> lstPhone) {

		List<Phone> result = null;
		result = this.phoneRepository.saveAll(lstPhone);
		return result;
	}
}
