package com.ustcinfo.ishare.eip.controller;

import com.ustcinfo.ishare.eip.bean.Student;
import com.ustcinfo.ishare.eip.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private StudentService studentService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );

		List<Student> studentList = studentService.getAll();
		System.out.println(studentList);
		model.addAttribute("studentList", studentList );

		return "home";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Locale locale, Model model, Student student) {
		logger.info("Welcome home! The client locale is {}.", locale);
		studentService.save(student);
		return "redirect:/";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(Locale locale, Model model, String id) {
		logger.info("Welcome home! The client locale is {}.", locale);
		studentService.delete(id);
		return "redirect:/";
	}
	
}
