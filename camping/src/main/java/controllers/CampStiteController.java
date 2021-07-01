package controllers;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import logic.CampSite;
import logic.Loc;
import logic.Member;
import logic.PagingBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.ShopService;
import utils.WebConstants;
@Controller
public class CampStiteController {
	@Autowired
	private ShopService shopService;	
	//ADMIN
	@RequestMapping(value="campList")
	public String campList(Model model, HttpServletRequest request, HttpSession session, String currentPage){
		int total = shopService.getTotalRecordCampSite();
		int start = 1;		
		if (currentPage != null && !currentPage.equals(""))
			start = Integer.parseInt(currentPage);
		List<CampSite> campList = shopService.getCampSiteList(start);
		PagingBean pb = new PagingBean(request, total);
		model.addAttribute("campList", campList);
		model.addAttribute("pb", pb);
		Member loginUser = (Member)session.getAttribute(WebConstants.USER_KEY);
		if(loginUser != null){
			model.addAttribute("loginUser", loginUser);
		}
		return "admin/camp/campList";
	}		
	@RequestMapping(value="campDetail")
	public String campDetail(Integer sId, Model model, HttpSession session){
		CampSite campsite = shopService.getCampSiteBysId(sId);
		model.addAttribute("campsite", campsite);
		Member loginUser = (Member)session.getAttribute(WebConstants.USER_KEY);
		if(loginUser != null){
			model.addAttribute("loginUser", loginUser);
		}
		return "admin/camp/campDetail";
	}	
	@RequestMapping(value={"campReg"}, method=RequestMethod.GET)
	public String campReg(Model model, HttpSession session){
		Member loginUser = (Member)session.getAttribute(WebConstants.USER_KEY);
		if(loginUser != null){
			model.addAttribute("loginUser", loginUser);
		}
		return "admin/camp/campReg";
	}	
	@RequestMapping(value={"campReg"}, method=RequestMethod.POST)
	public String campReg(CampSite campsite, HttpServletRequest request) throws IOException{
		if(!campsite.getFile().isEmpty()){
			String fname = campsite.getFile().getOriginalFilename();
			String path = request.getSession().getServletContext().getRealPath("/admin/upload");
			String fpath = path + "\\" + fname;
			
			FileOutputStream fs = new FileOutputStream(fpath);
			fs.write(campsite.getFile().getBytes());
			fs.close();
			
			campsite.setPicUrl(fname);
		}
		shopService.insertCampSite(campsite);
		
		return "redirect:campList.html";
	}	
	@RequestMapping(value={"campEdit"}, method=RequestMethod.GET)
	public String campEdit(Integer sId, Model model, HttpSession session){
		CampSite campsite = shopService.getCampSiteBysId(sId);
		model.addAttribute("campsite", campsite);
		Member loginUser = (Member)session.getAttribute(WebConstants.USER_KEY);
		if(loginUser != null){
			model.addAttribute("loginUser", loginUser);
		}
		return "admin/camp/campEdit";
	}	
	@RequestMapping(value={"campEdit"}, method=RequestMethod.POST)
	public String campEdit(CampSite campsite, HttpServletRequest request) throws IOException{
		if(!campsite.getFile().isEmpty()){
			String fname = campsite.getFile().getOriginalFilename();
			String path = request.getSession().getServletContext().getRealPath("/admin/upload");
			String fpath = path + "\\" + fname;
			
			FileOutputStream fs = new FileOutputStream(fpath);
			fs.write(campsite.getFile().getBytes());
			fs.close();
			
			campsite.setPicUrl(fname);
		}			
		shopService.updateCampSite(campsite);				
		return "redirect:campList.html";
	}
	
	@RequestMapping(value="campDelete")
	public String campDelete(Integer sId){
		shopService.deleteCampSite(sId);
		return "redirect:campList.html";
	}		
	//CUSTOMER
	@RequestMapping(value="campsiteList")
	public String campSiteList(Model model, HttpServletRequest request, HttpSession session, String currentPage){
		int start = 1;		
		if (currentPage != null && !currentPage.equals(""))
			start = Integer.parseInt(currentPage);
		List<CampSite> campSiteList = shopService.getCampSiteList(start);
		int total = shopService.getTotalRecordCampSite();
		PagingBean pb = new PagingBean(request, total);
		model.addAttribute("campSiteList", campSiteList);
		List<Loc> locList = shopService.locList();
		model.addAttribute("pb", pb);
		model.addAttribute("locCode", 100);
		model.addAttribute("locList", locList);
		Member loginUser = (Member)session.getAttribute(WebConstants.USER_KEY);
		if(loginUser != null){
			model.addAttribute("loginUser", loginUser);
		}
		return "campsite/campsiteList";
	}	
	@RequestMapping(value="selectedcampsite")
	public String selectedCampsite(Model model, HttpServletRequest request, HttpSession session, String currentPage){
		int start = 1;		
		if (currentPage != null && !currentPage.equals(""))
			start = Integer.parseInt(currentPage);
		List<CampSite> campSiteListbylocCode;
		List<Loc> locList = shopService.locList();
		int total;	
		Integer locCode = Integer.parseInt(request.getParameter("locCode"));		
		if(locCode == 100){
			campSiteListbylocCode = shopService.getCampSiteList(start);
			total = shopService.getTotalRecordCampSite();					
		} else {
			campSiteListbylocCode = shopService.getCampStieBylocCode(locCode);			
			total = shopService.getTotalRecordCampSiteBylocCode(locCode);
		}		
		String picUrl = shopService.getPicUrl(locCode);
		PagingBean pb = new PagingBean(request, total);
		model.addAttribute("campSiteList", campSiteListbylocCode);
		model.addAttribute("picUrl", picUrl);
		model.addAttribute("pb", pb);
		model.addAttribute("locCode", locCode);
		model.addAttribute("locList", locList);
		Member loginUser = (Member)session.getAttribute(WebConstants.USER_KEY);
		if(loginUser != null){
			model.addAttribute("loginUser", loginUser);
		}
		return "campsite/campsiteList";
	}	
}