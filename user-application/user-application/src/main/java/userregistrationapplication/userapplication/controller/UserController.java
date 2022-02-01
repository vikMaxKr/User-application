package userregistrationapplication.userapplication.controller;

import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import userregistrationapplication.userapplication.entity.User;

@Controller
@RequestMapping("/user")
public class UserController {
	private RestTemplate restTemplate;
	private String crmRestUrl;
	private final String uri="http://localhost:8080/rest/saveuser";	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	public UserController(RestTemplate theRestTemplate, 
										@Value(uri) String theUrl) {
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;
	}
	
		
	@GetMapping("/showform")
	public String showForm( Model themodel)
	{
		User theuser=new User();
		themodel.addAttribute("user",theuser);
		return "user-form";
	}
	
	@PostMapping("/saveuser")
	public String saveuser(@ModelAttribute("user") User theuser) {
		restTemplate.postForEntity(crmRestUrl, theuser, String.class);
		logger.info("success");
		return "saveduser";
		
	}
	@GetMapping("/getuserbyname")
	public String getUserById(HttpServletRequest request,Model theModel)
	{
		String users="";
		String theName=request.getParameter("userName");
		try {
		RestTemplate restTemplate=new RestTemplate();
		String url="http://localhost:8080/rest/users";
		User theuser = restTemplate.getForObject(url + "/" + theName, User.class);
		users="User Name = "+theuser.getUserName()+"  First Name = "+theuser.getFirstName()+"  Last Name= "+theuser.getLastName()+"  Email =  "+theuser.getEmail();
		theModel.addAttribute("returnedUser", users);
		logger.info("success"+theuser);
		return "saveduser";
		}
		catch(RuntimeException e){
			return "userNotFound";
		}
	}

}
