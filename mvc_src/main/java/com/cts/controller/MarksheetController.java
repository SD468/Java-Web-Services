package com.cts.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.cts.client.MarksheetClient;
import com.cts.dto.MarksDetails;
import com.cts.dto.Marksheet;
import com.cts.dto.Merit;
import com.cts.service.MarksheetService;
import com.cts.service.MarksheetServiceImpl;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@SessionAttributes("userName")
public class MarksheetController {

	private final Logger LOGGER = LoggerFactory.getLogger(MarksheetController.class);

	@Autowired
	private MarksheetClient client;
	MarksheetService ms = new MarksheetServiceImpl();
	
	/**
	 * will return the all marksheet details
	 * @param session
	 * @return
	 */
	@GetMapping("/client/home")
	public ModelAndView getAllMarksheet(HttpSession session) {
		LOGGER.info("Start");
		ModelAndView view = new ModelAndView("home");
		List<Marksheet> findAll = client.findAll();
		/*
			List<Marksheet> list = new ArrayList<Marksheet>();
			for(MarksDetails entity:findAll) {
				Marksheet marksheet = new Marksheet(ms.findPercentage(entity), ms.findTotalMarks(entity), ms.findGrade(entity),
						entity.getRollNo(), entity.getStudentName(), entity.getFirstLang(), entity.getSecondLang(),
						entity.getMath(), entity.getPhys(), entity.getChem());
				list.add(marksheet);
				
			}
			*/
			view.addObject("msList",findAll);
		
		LOGGER.debug("Mark Details: " + findAll);
		LOGGER.info("End");
		return view;
	}
	/**
	 * will show 
	 * @return
	 */
	/*
	 * @PostMapping("/client/home") public ModelAndView showHomePage() {
	 * ModelAndView view = new ModelAndView("home"); List<MarksDetails> findAll =
	 * client.findAll(); view.addObject("msList", findAll); return view; }
	 */
	
	/*
	 * will show new marksheet page
	 */
	@GetMapping("/client/home/addMs")
	public String showNewMarksheetPage(ModelMap model, HttpSession session) {
		LOGGER.info("Start");
		model.addAttribute("mark-add", new MarksDetails());
		LOGGER.info("End");
		return "addMs";
	}
	
	/**
	 * will add the details and will return to the home page
	 * @param model
	 * @param session
	 * @param ms
	 * @param result
	 * @return
	 */
	@PostMapping("/client/home/addMs")
	public String addNewMarksheet(Model model, HttpSession session, @ModelAttribute("mark-add") @Valid MarksDetails ms,
			BindingResult result) {
		LOGGER.info("Start");
		if (result.hasErrors()) {

			return "addMs";
		}

		MarksDetails entity = client.create(ms).getBody();

		LOGGER.info("End");
		return "redirect:/client/home";
	}
	/**
	 * will delete marksheet
	 * @param rollNo
	 * @param session
	 * @return
	 */
	@RequestMapping("/client/home/delete-ms")
	public String deleteMarksheet(@RequestParam int rollNo, HttpSession session) {
		LOGGER.info("Start");
		client.deletByRollNo(rollNo);
		LOGGER.info("End");
		return "redirect:/client/home";

	}
	/**
	 * will go the addms page with the existing details
	 * @param rollNo
	 * @param model
	 * @return
	 */
	@GetMapping("/client/home/update-ms")
	public String showUpdateMarksheetPage(@RequestParam("rollNo") int rollNo, ModelMap model) {
		LOGGER.info("Start");
		Marksheet entity = client.findByRollNo(rollNo).getBody();
		LOGGER.debug("Details Found"+ entity);
		model.addAttribute("mark-add", entity);
		LOGGER.info("End");
		return "addMs";
	}
	/**
	 * to update
	 * @param model
	 * @param todo
	 * @param result
	 * @param session
	 * @return
	 */
	@PostMapping("/client/home/update-ms")
	public String updateMarksheet(Model model, @ModelAttribute("mark-add") @Valid MarksDetails todo,
			BindingResult result, HttpSession session) {
		LOGGER.info("Start");
		if (result.hasErrors()) {
			return "addMs";
		}

		model.addAttribute("marks-add", client.update(todo));
		LOGGER.info("End");
		return "redirect:/client/home";
	}
	/**
	 * for search
	 * @param m
	 * @param rollNo
	 * @param session
	 * @return
	 */
	@GetMapping(value = "/client/home/search")
	public ModelAndView Search(Model m, @RequestParam("rollNo") String rollNo, HttpSession session) {
		LOGGER.info("Start");
		LOGGER.debug(rollNo);
		ModelAndView mav = new ModelAndView("displayMs");
		Marksheet marksheet = client.findByRollNo(Integer.parseInt(rollNo)).getBody();
//		MarksDetails entity = new MarksDetails();
//		
//
//		entity = client.findByRollNo(Integer.parseInt(rollNo)).getBody();
//		LOGGER.debug("found Details:"+entity);
//		Marksheet marksheet = new Marksheet(ms.findPercentage(entity), ms.findTotalMarks(entity), ms.findGrade(entity),
//				entity.getRollNo(), entity.getStudentName(), entity.getFirstLang(), entity.getSecondLang(),
//				entity.getMath(), entity.getPhys(), entity.getChem());

		mav.addObject("search", marksheet);
		LOGGER.info("End");
		return mav;
	}
	
	@GetMapping("/client/getMeritList")
	public ModelAndView getMeritList(HttpSession session) {
		LOGGER.info("Start");
		ModelAndView view = new ModelAndView("MeritList");
		List<Merit> meritList =  client.getMeritList().getBody();
		view.addObject("meritList",meritList);
		
		LOGGER.debug("Mark Details: " + meritList);
		LOGGER.info("End");
		return view;
	}
}
