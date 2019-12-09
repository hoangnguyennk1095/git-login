package com.hiber.Controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hiber.dao.accountDAO;
import com.hiber.dao.productDAO;
import com.hiber.entity.Accounts;
import com.hiber.entity.category;
import com.hiber.entity.product;

@Controller
public class accountController {
	@Autowired
	accountDAO dao;
	@Autowired
	productDAO dao1;
	@Autowired
	HttpSession session;
	@Autowired
	ServletContext app;

	@RequestMapping("/admin/listAccount")
	public String list(Model model) {
		List<Accounts> list = dao.findAll();
		model.addAttribute("listAccount", list);
		session.setAttribute("listAccount", list);
		return "admin/listAccount";
	}

	@RequestMapping("/clerk/listAccountCus")
	public String listAccountCus(Model model) {
		List<Accounts> list = dao.findAccountCus();
		model.addAttribute("listAccountCus", list);
		session.setAttribute("listAccountCus", list);
		return "clerk/listAccountCus";
	}

	@RequestMapping("index")
	public String Index(Model model) {
		return "index";

	}

	@RequestMapping("admin/indexAdmin")
	public String IndexAdmin(Model model) {
		return "admin/indexAdmin";

	}

	@RequestMapping("clerk/indexClerk")
	public String IndexClerk(Model model) {
		return "clerk/indexClerk";

	}

	@GetMapping("/login")
	public String login() {
		return "/login";

	}

	@PostMapping("/login")
	public String login(Model model, @RequestParam("userName") String username,
			@RequestParam("password") String password) {
		Accounts accounts = dao.findbyUer(username);
		if (accounts == null) {
			model.addAttribute("message", "Invalid Username");
			return "erro";
		} else if (accounts.getRole() == 0) {
			session.setAttribute("account", accounts);
			model.addAttribute("message", "Login for Admin");
			session.setAttribute("User", accounts.getUserName());
			session.setAttribute("UserRole", accounts.getRole());
			return "admin/indexAdmin";
		} else if (accounts.getRole() == 1) {
			session.setAttribute("account", accounts);
			model.addAttribute("message", "Login for Clerk");
			session.setAttribute("User", accounts.getUserName());
			session.setAttribute("UserRole", accounts.getRole());
			return "clerk/indexClerk";
		} else if (accounts.getRole() == 2) {
			session.setAttribute("account", accounts);
			session.setAttribute("User", accounts.getUserName());
			session.setAttribute("UserRole", accounts.getRole());
			String url = (String) session.getAttribute("back-uri");
			if (url != null) {
				return "redirect:" + url;
			}
			model.addAttribute("account", accounts);
			model.addAttribute("message", "Login for Cus");
			return "redirect:/index/0";
		} else {
			model.addAttribute("message", "Login Fail");
		}
		return "erro";

	}

	@RequestMapping("/logout")
	public String logout(Accounts acc) {
		if (session.getAttribute("User") != null) {
			session.removeAttribute("User");
			session.setAttribute("logout", app);
			return "redirect:/index/0";
		}
		return "redirect:/index/0";
	}

	@GetMapping("/account/create")
	public String create(Model model) {
		Accounts user = new Accounts();
		model.addAttribute("form", user);
		return "account/create";

	}

	@PostMapping("/account/create")
	public String create(Model model, @ModelAttribute("form") Accounts Accounts) {
		Accounts.setRole(2);
		dao.creatAccount(Accounts);
		model.addAttribute("message", "Đắng ký thành công");
		return "redirect:/index/0";

	}

	@GetMapping("/admin/createAdmin")
	public String createAdmin(Model model) {
		Accounts user = new Accounts();
		model.addAttribute("form1", user);
		return "admin/createAdmin";

	}

	@PostMapping("/admin/createAdmin")
	public String createAdmin(Model model, @ModelAttribute("form1") Accounts Accounts) {
		dao.creatAccount(Accounts);
		model.addAttribute("message", "Đắng ký thành công");
		return "redirect:/indexAdmin";

	}

	@RequestMapping("/changeAccount/{userName}")
	public String changeAccount(Model model, @PathVariable("userName") String username) {
		Accounts user = dao.findbyUer(username);
		model.addAttribute("form1", user);
		return "ChangePass";
	}

	@RequestMapping("/updateprofile/{userName}")
	public String updateProfile(Model model, @PathVariable("userName") String username) {
		Accounts user = dao.findbyUer(username);
		model.addAttribute("form1", user);
		return "updateProfile";
	}

	@PostMapping("/updatePass")
	public String changPass(Model model, @ModelAttribute("form1") Accounts entity) {

		dao.update(entity);
		System.out.println(entity.getUserName());
		// model.addAttribute("list", dao.findAll());
		return "redirect:/profileCus/**";
	}

	@RequestMapping("profileCus/{userName}")
	public String cusProduct(Model model, @PathVariable("userName") String username) {
		username = (String) session.getAttribute("User");
		Accounts acc = dao.findbyUer(username);
		List<product> product = dao1.findAllbyUsername(username);
		model.addAttribute("listProductUser", product);
		session.setAttribute("profileCus", acc);
		model.addAttribute("profileCus", acc);
		return "/profileCus";
	}

	@RequestMapping("productOfUser/{userName}")
	public String productOfUser(Model model, @PathVariable("userName") String username) {
		username = (String) session.getAttribute("User");
		Accounts acc = dao.findbyUer(username);
		List<product> product = dao1.findAllbyUsername(username);
		model.addAttribute("listProductUser", product);
		session.setAttribute("profileCus", acc);
		model.addAttribute("profileCus", acc);
		return "customer/productOfUser";
	}

	@RequestMapping("/clerk/delete/{userName}")
	public String delete(Model model, @PathVariable("userName") String id) {
		Accounts acc = dao.delete(id);
//		product product = dao1.deleteProductByUsername(id);
		List<Accounts> list = dao.findAccountCus();
		model.addAttribute("listAccountCus", list);
		model.addAttribute("message", "Xóa phẩm thành công");
		model.addAttribute("deleteAccountCus", acc);
		return "redirect:/clerk/listAccountCus";
	}

	@RequestMapping("/admin/deleteAdmin/{userName}")
	public String deleteAdmin(Model model, @PathVariable("userName") String id) {
		Accounts acc = dao.delete(id);
//		product product = dao1.deleteProductByUsername(id);
		List<Accounts> list = dao.findAll();
		model.addAttribute("listAccount", list);
		model.addAttribute("message", "Xóa phẩm thành công");
		model.addAttribute("deleteAccountCus", acc);
		return "redirect:/admin/listAccount";
	}

}
