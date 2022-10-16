package com.panacea.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.panacea.model.hrm.ArmyEmployee;
import com.panacea.model.hrm.LeaveRegister;
import com.panacea.model.login.*;
import com.panacea.model.login.DropDownType;
import com.panacea.model.login.UserMaster;
import com.panacea.repository.leave.UserMaserRepo;
import com.panacea.repository.hrm.*;
import com.panacea.utils.AESDecrypt;
import com.panacea.utils.AESEncrypt;

@Controller
@RequestMapping({ "/", "/login" })
public class LoginController {
	@Autowired
	UserMaserRepo UserMasterRepo;
	@Autowired
	ArmyEmployeeRepo ArmyEmployeeRepo;
	private static final Logger LOGGER = LogManager.getLogger(LoginController.class);

	@GetMapping("/LogOut")
	public String LogOut(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "index";
	}

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@PostMapping("/login")
	public String loginvalidation(@ModelAttribute(name = "loginForm") UserMaster login, Model model,
			HttpServletRequest request) {
		String ViewName = "";
		String UserID = request.getParameter("username");
		String Password = request.getParameter("password");
		HttpSession sessionParam = request.getSession();

		if (UserMasterRepo.existsById(UserID)) {
			UserMaster usermaster = UserMasterRepo.findById(UserID).orElseThrow();
			if (usermaster.getUserID().equals(UserID)
					&& AESDecrypt.decrypt(usermaster.getUserPassword()).equals(Password)) {

				sessionParam.setAttribute("UserId", UserID);
				sessionParam.setAttribute("Module", usermaster.getUserModule());
				sessionParam.setAttribute("UserRole", usermaster.getUserRole());
				sessionParam.setAttribute("UserBranch", usermaster.getUserBranch());
				sessionParam.setAttribute("EmployeeId", usermaster.getEmployeeId());
				sessionParam.setAttribute("UserName", usermaster.getUserName());
				if (usermaster.getUserModule().equals("ACCOUNTING")) {
					if (usermaster.getUserRole().equals("S")) {
						ViewName = "Accounting/Accounting";
					} 
					else if (usermaster.getUserRole().equals("E")) {
						ViewName = "Accounting/AccountingEndUser";
					}
					else {
						ViewName = "Accounting/AccountingSuper";
					}
				} else if (usermaster.getUserModule().equals("INVENTORY")) {
					{
						
						if (usermaster.getUserRole().equals("S")) {
							ViewName = "Inventory/InventorySuper";
						} 
						else if (usermaster.getUserRole().equals("E")) {
							ViewName = "Inventory/InventoryEndUser";
						}
						
						else {
							ViewName = "Inventory/Inventory";
						}
					}

				} else if (usermaster.getUserModule().equals("LEAVE")) {
					ArmyEmployee ArmyEmployee = ArmyEmployeeRepo.findById(usermaster.getEmployeeId()).get();
					
					sessionParam.setAttribute("Rank", ArmyEmployee.getRank());
					
					if (usermaster.getUserRole().equals("M")) {
						ViewName = "HRM/LeaveManagement";
					} else if (usermaster.getUserRole().equals("S")) {
						ViewName = "HRM/HRSuperUser";
					}
					 else if (usermaster.getUserRole().equals("G")) {
							ViewName = "HRM/RPNoc";
						}
					else {
						ViewName = "HRM/LeaveEndUser";
					}
				} else if (usermaster.getUserModule().equals("HRM")) {
					if (usermaster.getUserRole().equals("S")) {
						ViewName = "HRM/HRSuperUser";
					}

				}

			} else {
				model.addAttribute("error", "Incorrect Username or Password");
				ViewName = "index";
			}
		} else {
			model.addAttribute("error", "User ID not Exist !!");
			ViewName = "index";
		}
		return ViewName;

	}

	@GetMapping("/UserHome")
	public String UserHome(HttpServletRequest request, Model model) {
		String ViewName = "";
		try {
			String UserID = request.getSession().getAttribute("UserId").toString();
			if (UserID == null || UserID.equals("")) {
				model.addAttribute("error", "Session Out!!! Please login Again!!");
				ViewName = "index";
			} else {
				if (UserMasterRepo.existsById(UserID)) {
					UserMaster usermaster = UserMasterRepo.findById(UserID).orElseThrow();
					if (usermaster.getUserID().equals(UserID)) {

						if (usermaster.getUserModule().equals("ACCOUNTING")) {
							if (usermaster.getUserRole().equals("S")) {
								ViewName = "Accounting/Accounting";
							} 
							else if (usermaster.getUserRole().equals("E")) {
								ViewName = "Accounting/AccountingEndUser";
							}
							else {
								ViewName = "Accounting/AccountingSuper";
							}
						} else if (usermaster.getUserModule().equals("INVENTORY")) {
							{
								if (usermaster.getUserRole().equals("S")) {
									ViewName = "Inventory/InventorySuper";
								} 
								else if (usermaster.getUserRole().equals("E")) {
									ViewName = "Inventory/InventoryEndUser";
								}
								
								else {
									ViewName = "Inventory/Inventory";
								}
							}

						} else if (usermaster.getUserModule().equals("LEAVE")) {
														
							if (usermaster.getUserRole().equals("M")) {
								ViewName = "HRM/LeaveManagement";
							} else if (usermaster.getUserRole().equals("S")) {
								ViewName = "HRM/HRSuperUser";
							}
							 else if (usermaster.getUserRole().equals("G")) {
									ViewName = "HRM/RPNoc";
								}
							else {
								ViewName = "HRM/LeaveEndUser";
							}
						} else if (usermaster.getUserModule().equals("HRM")) {
							if (usermaster.getUserRole().equals("S")) {
								ViewName = "HRM/HRSuperUser";
							}

						}

					} else {
						model.addAttribute("error", "Incorrect User ID or Password");
						ViewName = "index";
					}
				} else {
					model.addAttribute("error", "User ID not Exist !!");
					ViewName = "index";
				}
			}
		} catch (Exception e) {
			model.addAttribute("error", "Server Maybe Suspend Your Session Please login Again !!");
			ViewName = "index";
		}

		return ViewName;
	}

	@GetMapping({ "/erpUserList" })
	public String getUserListHRM(HttpServletRequest request, Model model) {
		HttpSession sessionParam = request.getSession();
		try {
			String Module = sessionParam.getAttribute("Module").toString();
			if (Module == null || Module.equals("")) {
				return "Index";
			} else {

				model.addAttribute("UserList", UserMasterRepo.FindUserListByModule(Module));
				return "Common/List-User";
			}
		} catch (Exception e) {
			return "redirect:/UserHome";
		}

	}
	
	
	@GetMapping({ "/ULMSuserList" })
	public String ULMSuserList(HttpServletRequest request, Model model) {
		HttpSession sessionParam = request.getSession();
		try {
			String Module = sessionParam.getAttribute("Module").toString();
			if (Module == null || Module.equals("")) {
				return "Index";
			} else {

				model.addAttribute("UserList", UserMasterRepo.FindUserListByModule(Module));
				return "Common/List-User";
			}
		} catch (Exception e) {
			return "redirect:/UserHome";
		}

	}
	@Autowired
	ArmyRankRepo ArmyRankRepo;
	@Autowired
	ArmyCompayRepo ArmyCompayRepo;
	@RequestMapping("/AddNewSystemUser")
	public ModelAndView AddNewSystemUser(Model model,HttpServletRequest request) {
		HttpSession sessionParam = request.getSession();
		String Module;
		try {
			 Module = sessionParam.getAttribute("Module").toString();
		}catch(Exception e) {
			 Module="Module Not Found";
		}
		
		
		List<DropDownType> ModuleList = new ArrayList<DropDownType>();
		ModuleList.add(new DropDownType(Module, Module));
		
		
		List<DropDownType> BranchList = new ArrayList<DropDownType>();
		BranchList.add(new DropDownType("0018", "Jashore"));
		BranchList.add(new DropDownType("0019", "Dhaka"));
		BranchList.add(new DropDownType("0020", "Cumilla"));
		BranchList.add(new DropDownType("0021", "Chattagram"));
		
		
		List<DropDownType> UserRoleList = new ArrayList<DropDownType>();
		UserRoleList.add(new DropDownType("S", "Super Admin"));
		UserRoleList.add(new DropDownType("M", "Admin"));
		UserRoleList.add(new DropDownType("E", "End User"));
		UserRoleList.add(new DropDownType("G", "G-GatePost"));
		
		
		ModelAndView mav = new ModelAndView("Common/add-User");
		UserMaster UserMaster = new UserMaster();
		mav.addObject("UserMaster", UserMaster);
		mav.addObject("UserRoleList", UserRoleList);
		mav.addObject("BranchList", BranchList);
		mav.addObject("ModuleList", ModuleList);
		mav.addObject("Ranklist", ArmyRankRepo.findAll());
		mav.addObject("companylist", ArmyCompayRepo.findAll());
		
		mav.addObject("EmployeeList", ArmyEmployeeRepo.findAll());
		return mav;
	}
	
	
	@RequestMapping("/showUpdateUserForm")
	public ModelAndView showUpdateUserForm(@RequestParam String UserID,HttpServletRequest request) {
		
		HttpSession sessionParam = request.getSession();
		String Module;
		try {
			 Module = sessionParam.getAttribute("Module").toString();
		}catch(Exception e) {
			 Module="Module Not Found";
		}
		
		
		List<DropDownType> ModuleList = new ArrayList<DropDownType>();
		ModuleList.add(new DropDownType(Module, Module));
		
		
		List<DropDownType> BranchList = new ArrayList<DropDownType>();
		BranchList.add(new DropDownType("0018", "Jashore"));
		BranchList.add(new DropDownType("0019", "Dhaka"));
		BranchList.add(new DropDownType("0020", "Cumilla"));
		BranchList.add(new DropDownType("0021", "Chattagram"));
		
		
		List<DropDownType> UserRoleList = new ArrayList<DropDownType>();
		UserRoleList.add(new DropDownType("S", "Super Admin"));
		UserRoleList.add(new DropDownType("M", "Admin"));
		UserRoleList.add(new DropDownType("E", "End User"));
		UserRoleList.add(new DropDownType("G", "G-GatePost"));
		
		ModelAndView mav = new ModelAndView("Common/add-User");
		UserMaster UserMaster = UserMasterRepo.findById(UserID).get();
		mav.addObject("UserMaster", UserMaster);
		mav.addObject("UserRoleList", UserRoleList);
		mav.addObject("BranchList", BranchList);
		mav.addObject("ModuleList", ModuleList);
		mav.addObject("Ranklist", ArmyRankRepo.findAll());
		mav.addObject("companylist", ArmyCompayRepo.findAll());
		mav.addObject("EmployeeList", ArmyEmployeeRepo.findAll());
		return mav;
	}
	
	
	@PostMapping("/saveNewSystemUser")
	public String saveNewSystemUser(@ModelAttribute("usermaster") UserMaster usermaster,HttpServletRequest request) {
		HttpSession sessionParam = request.getSession();
		String Module;
		try {
			 Module = sessionParam.getAttribute("Module").toString();
		}catch(Exception e) {
			 Module="Module Not Found";
		}
		if (!UserMasterRepo.existsById(usermaster.getUserID())) {			
			usermaster.setRankName(ArmyRankRepo.FindRank(usermaster.getRankCode()));
			usermaster.setUserPassword(AESEncrypt.encrypt(usermaster.getUserPassword()));
			usermaster.setActivation("A");
			usermaster.setCompany(usermaster.getCompany());
			usermaster.setCompanyName(ArmyCompayRepo.findcomapny(usermaster.getCompany()));
			usermaster.setUserModule(Module);
			UserMasterRepo.save(usermaster);			
		}
		else {
			UserMaster UserMaster=UserMasterRepo.getById(usermaster.getUserID());
			UserMaster.setUserMobile(usermaster.getUserMobile());
			UserMaster.setUserPassword(AESEncrypt.encrypt(usermaster.getUserPassword()));
			UserMaster.setUserEmailId(usermaster.getUserEmailId());
			UserMaster.setUserName(usermaster.getUserName());
			UserMaster.setRankCode(usermaster.getRankCode());
			UserMaster.setRankName(ArmyRankRepo.FindRank(usermaster.getRankCode()));
			UserMaster.setCompany(usermaster.getCompany());
			UserMaster.setUserRole(usermaster.getUserRole());
			UserMaster.setCompanyName(ArmyCompayRepo.findcomapny(usermaster.getCompany()));
			usermaster.setActivation("A");
			UserMasterRepo.save(UserMaster);
		}
		
		return "redirect:ULMSuserList";
	}

	@GetMapping("/DeleteUser/{UserID}")
	public ModelAndView DeleteUser(@PathVariable String UserID,HttpServletRequest request) {
		UserMaster UserMaster = UserMasterRepo.findById(UserID).get();
		UserMaster.setActivation("I");
		UserMasterRepo.save(UserMaster);
		String Module=null;
		
		HttpSession sessionParam = request.getSession();
		try {
			 Module = sessionParam.getAttribute("Module").toString();
			
		} catch (Exception e) {
			Module= "NF";
		}
		
		ModelAndView mav = new ModelAndView("Common/List-User");
		mav.addObject("UserList", UserMasterRepo.FindUserListByModule(Module));
		return mav;
	}

	

	@GetMapping("/AccountsInfo")
	public ModelAndView AccountsInfo(@RequestParam String UserId,HttpServletRequest request) {
		String EmpID=null;
		
		HttpSession sessionParam = request.getSession();
		try {
			EmpID = sessionParam.getAttribute("EmployeeId").toString();
			
		} catch (Exception e) {
			EmpID= "NF";
		}
		
		ModelAndView mav = new ModelAndView("Common/update-UserInfo");
		mav.addObject("message","");
		mav.addObject("UserMaster", UserMasterRepo.getById(UserId));
		mav.addObject("EmployeeList", ArmyEmployeeRepo.findById(EmpID).get());
		return mav;
	}
	
	
	@PostMapping("/UpdateUserInfo")
	public String UpdateUserInfo(@ModelAttribute("usermaster") UserMaster usermaster,HttpServletRequest request,Model model) {
		String EmpID=null;
		String UserId=null;
		HttpSession sessionParam = request.getSession();
		try {
			EmpID = sessionParam.getAttribute("EmployeeId").toString();
			UserId=sessionParam.getAttribute("UserId").toString();
			
		} catch (Exception e) {
			EmpID= "NF";
		}
		if(!usermaster.getConPassword().equalsIgnoreCase(usermaster.getUserPassword())) {
			model.addAttribute("message", "Both Password Are not Matched !");
			model.addAttribute("UserMaster", UserMasterRepo.getById(UserId));
			model.addAttribute("EmployeeList", ArmyEmployeeRepo.findById(EmpID).get());
			return "Common/update-UserInfo";
		}
		else {
			if (UserMasterRepo.existsById(usermaster.getUserID())) {	
				UserMaster UserMaster = UserMasterRepo.findById(usermaster.getUserID()).orElseThrow();
				UserMaster.setUserPassword(AESEncrypt.encrypt(usermaster.getUserPassword()));
				UserMaster.setUserMobile(usermaster.getUserMobile());
				UserMaster.setUserEmailId(usermaster.getUserEmailId());
				UserMaster.setUserName(usermaster.getUserName());
				UserMaster.setActivation("A");
				UserMasterRepo.save(UserMaster);
			}
			return "redirect:/UserHome";
		}	
	}
	
	
	

	@GetMapping("{tab}")
	public String tab(@PathVariable String tab) {

		if (Arrays.asList("tab1", "tab2", "tab3", "tab4", "tab5", "tab6", "tab7").contains(tab)) {

			return "HRM/_" + tab;
		}

		return "HRM/_empty";
	}
}