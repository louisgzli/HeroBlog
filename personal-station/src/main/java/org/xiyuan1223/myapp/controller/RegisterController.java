package org.xiyuan1223.myapp.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.xiyuan1223.myapp.common.HibernateTemplate;
import org.xiyuan1223.myapp.vo.Station;

@Controller
@RequestMapping("/user")
public class RegisterController {
	@Resource
	Station station;
	@Resource
	HibernateTemplate hibernateTemplate;
	Log log = LogFactory.getLog(getClass());
	/**
	 *ֱ�Ӱѱ��Ĳ���д��Controller��Ӧ�ķ������β���
	 * @param username
	 * @param password
	 */
	@RequestMapping("/addUser1")
	public String addUser(String username,String password){
		System.out.println("ע��ɹ���");
		System.out.println("�û�����"+username);
		System.out.println("���룺"+password);
		 return "/user/success";
	}
	/**
	 * ͨ��HttpServletRequest����
	 * @param request
	 * @return
	 */
	@RequestMapping("/addUser2")
    public String addUser2(HttpServletRequest request) {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("userName is:"+userName);
        System.out.println("password is:"+password);
        return "/user/success";
    }
	@RequestMapping(value="/addUser3",method=RequestMethod.GET)
	public String addUser3(HttpServletRequest request){
		station.setUsername(request.getParameter("username"));
		station.setPassword(request.getParameter("password"));
		station.setSex(request.getParameter("sex"));
		station.setInterest(request.getParameter("interest"));
		station.setCity(request.getParameter("city"));
		station.setEmail(request.getParameter("email"));
		hibernateTemplate.save(station);
		return "user/sucRegister";
		
	}
}
