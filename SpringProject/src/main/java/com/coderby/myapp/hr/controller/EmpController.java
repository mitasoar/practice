package com.coderby.myapp.hr.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.coderby.myapp.hr.model.EmpVO;
import com.coderby.myapp.hr.service.IEmpService;

@Controller
public class EmpController {
	
	@Autowired
	IEmpService empService;
	
	@RequestMapping(value="/hr/count")
	public String empCount(@RequestParam(value="deptid", required = false, defaultValue = "0") int deptid, Model model) {
		if (deptid == 0) {
			model.addAttribute("count", empService.getEmpCount());
		} else {
			model.addAttribute("count", empService.getEmpCount(deptid));
		}
		return "hr/count";
	}
	
	@RequestMapping(value= {"/hr", "/hr/list"})
	public String getAllEmps(Model model) {
		List<EmpVO> empList = empService.getEmpList();
		model.addAttribute("empList", empList);
		return "hr/list";
	}
	
	@RequestMapping(value="/hr/{employeeId}")
	public String getEmpInfo(@PathVariable int employeeId, Model model) {
		EmpVO emp = empService.getEmpInfo(employeeId);
		model.addAttribute("emp", emp);
		return "hr/view";
	}
	
	@GetMapping(value="/hr/insert")
	public String insertEmp(Model model) {
		model.addAttribute("deptList", empService.getAllDeptId());
		model.addAttribute("jobList", empService.getAllJobId());
		model.addAttribute("managerList", empService.getAllManagerId());
		return "hr/insertform";
	}
	
	@PostMapping(value="/hr/insert")
	public String insertEmp(EmpVO emp, Model model) {
		empService.insertEmp(emp);
		return "redirect:/hr";
	}
	
	@GetMapping(value="/hr/update")
	public String updateEmp(int empid, Model model) {
		model.addAttribute("emp", empService.getEmpInfo(empid));
		model.addAttribute("deptList", empService.getAllDeptId());
		model.addAttribute("jobList", empService.getAllJobId());
		model.addAttribute("managerList", empService.getAllManagerId());
		return "hr/updateform";
	}
	
	@PostMapping(value="/hr/update")
	public String updateEmp(EmpVO emp, Model model) {
		empService.updateEmp(emp);
		return "redirect:/hr/" + emp.getEmployeeId();
	}
	
	@GetMapping(value="/hr/delete")
	public String deleteEmp(int empid, Model model) {
		model.addAttribute("emp", empService.getEmpInfo(empid));
		return "hr/deleteform";
	}
	
	@PostMapping(value="/hr/delete")
	public String deleteEmp(int empid, String email, Model model) {
		empService.deleteEmp(empid, email);
		return "redirect:/hr";
	}
	
	@ExceptionHandler({RuntimeException.class})
	public ModelAndView runtimeException(HttpServletRequest request, Exception ex) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("url", request.getRequestURI());
		mav.addObject("exception", ex);
		mav.setViewName("error/runtime");
		return mav;
	}
	
//	static final Logger logger = LoggerFactory.getLogger(EmpController.class);
//	
//	@ExceptionHandler({SQLException.class, DataAccessException.class})
//	public ModelAndView databaseError(HttpServletRequest request, Exception ex) {
//		logger.error("Request: " + request.getRequestURL() + " raised " + ex);
//		
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("exception", ex);
//		mav.addObject("url", request.getRequestURL());
//		mav.setViewName("hr/error");
//		return mav;
//	}
	
}
