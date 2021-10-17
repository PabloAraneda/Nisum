package cl.nisum.rest.api.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.nisum.rest.api.data.dto.User;
import cl.nisum.rest.api.data.service.UserService;

@RestController
public class UserController extends BaseController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public User login(@Valid @RequestParam("user") String username, @RequestParam("password") String pwd) {

		User user = new User();
		user.setName(username);
		return user;

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public User save(@Valid @RequestBody User request) {
		User user = null;
		user = this.userService.save(request);
		return user;

	}

	@GetMapping("/getAll")
	public List<User> getAll() {

		List<User> lstUser = this.userService.getAll();
		return lstUser;

	}

	@PostMapping("/saveAll")
	public List<User> saveAll(@RequestBody List<User> request) {

		return this.userService.saveAll(request);
	}

}
