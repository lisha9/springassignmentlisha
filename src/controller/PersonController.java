package controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jpa.JpaPerson;
import jpa.Person;

@Controller
public class PersonController {
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView userInit(){
		Person person=new Person();
		return new ModelAndView("login","command",person);
	}
	@RequestMapping(value="/success", method=RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute Person person){
		
		new JpaPerson().insert(person);
		return new ModelAndView("login","command",new Person());
	}
	
	
	@SuppressWarnings("unused")
	private ModelMap setPerson(ModelMap map){
		ArrayList<Person> person = (ArrayList<Person>) new JpaPerson().selectStar();
		map.addAllAttributes(person);
		return map;
	}
	@RequestMapping(value="/delete/{personid}")
	private ModelMap deleteRecord(int personid, ModelMap map){
		JpaPerson person=new JpaPerson();
		person.delete(personid);
		map.remove(person);
		map.addAllAttributes("delete", true);
		return new ModelAndView("login","command",new Person());
		
	}
	
	@RequestMapping(value="/edit")
	private ModelMap editRecord(int personid, ModelMap map){
		return null;
	}
}
