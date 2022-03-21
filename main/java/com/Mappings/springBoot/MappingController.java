package com.Mappings.springBoot;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class MappingController {
	
	Map<String,RestUser>allUsers=new HashMap<>();
	private Object userId;
	
	@GetMapping(path="/user")
	public Collection<RestUser> getMethod() {
		return allUsers.values();
	}
	
	@PostMapping(path="/user")
	public String postMethod(@RequestBody RestUser userdetails) {
		RestUser addvalue=new RestUser();
		addvalue.setUserid(userdetails.getUserid());
		addvalue.setName(userdetails.getName());
		addvalue.setEmail(userdetails.getEmail());
		allUsers.put(Integer.toString(userdetails.getUserid()),addvalue);
		return "users added";	
	}
	
	@PutMapping(path="/{userId}")
	public String String (@PathVariable String userId,@RequestBody RestUser userdetails) {
		if(allUsers.containsKey(userId)) {
			RestUser addvalue=new RestUser();
			addvalue.setUserid(userdetails.getUserid());
			addvalue.setName(userdetails.getName());
			addvalue.setEmail(userdetails.getEmail());
			allUsers.put(userId,addvalue);
		return "Update Users";
	}
	else {
		return "Userid Not found";
	}
	}

	@DeleteMapping(path="/{userId}")
	public String deleteMethod(@PathVariable String useId) {
		if(allUsers.containsKey(userId)) {
		allUsers.remove(userId);
		return "User deleted";
	}
		else {
			return "user id not found";
		}
		}
}


