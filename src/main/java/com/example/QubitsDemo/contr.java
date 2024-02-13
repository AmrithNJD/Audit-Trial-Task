package com.example.QubitsDemo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller

public class contr {
	@Autowired 
    
private repo repos;
@Autowired
private orderrepo orepo;
@RequestMapping("/CreateTenant")
public String create(HttpServletRequest req, HttpServletResponse res)
{
	String TenantName = req.getParameter("TenantName");
	String TenantShortCode = req.getParameter("TenantShortCode");
	String Country = req.getParameter("Country");
	Feilds f = new Feilds();
	f.setTenantName(TenantName);
	f.setTenantShortCode(TenantShortCode);
	f.setCountry(Country);
	repos.save(f);
	return "index";
	
}
//	@RequestMapping("/")
//	public String displayData(Model model) {
//		Iterable<Feilds> iterableData = repos.findAll();
//
//		// Convert Iterable to List
//		List<Feilds> dataList = new ArrayList<>();
//
//		// Add the data to the model
//		model.addAttribute("dataList", dataList);
//
//		return "index";
//	}
//@RequestMapping("/")
//public String welcome(ModelMap model) {
//	model.addAttribute("message", "Programmer Gate");
//	return "index";
//}
//	@RequestMapping("/")
//	public String getAllNotes(ModelMap model)
//	{
//		Iterable<Feilds> products = repos.findAll();
//		products.forEach((p) -> {
//			System.out.println(p.getName());
//			model.addAttribute("message", p.getName());
//		});
//		return "index";
//	}
@RequestMapping("/")
public String getAllNotes(ModelMap model)
{
	List a = new ArrayList();
	Iterable<Feilds> products = repos.findAll();
	products.forEach((p) -> {
//			System.out.println(p.getName());
		a.add(p);
		model.addAttribute("dataList", a);


	});

	return "index";
}
	@RequestMapping("/show")
	public String getAllorder(ModelMap model)
	{
		List a = new ArrayList();
		Iterable<orderDetails> products = orepo.findAll();
		products.forEach((p) -> {
//			System.out.println(p.getName());

			a.add(p);
			model.addAttribute("dataList", a);

			System.out.println(a);

		});

		return "index";
	}
	@PutMapping("/view")
public String update(HttpServletRequest requp, HttpServletResponse resup)
{
	int Tenanti = Integer.parseInt(requp.getParameter("Tenantid"));
	String TenantName = requp.getParameter("TenantName");
	String TenantShortCode = requp.getParameter("TenantShortCode");
	String Country = requp.getParameter("Country");
	Feilds up = repos.findById(Tenanti).get();

	up.setTenantName(TenantName);
	up.setTenantShortCode(TenantShortCode);
	up.setCountry(Country);
	repos.save(up);
	return "index";
}
@DeleteMapping("/Delete")
public String delete(HttpServletRequest reqd, HttpServletResponse resd)
{
	int TenantName = Integer.parseInt(reqd.getParameter("Tenantid"));


	repos.deleteById(TenantName);
	return "index";
}
}
