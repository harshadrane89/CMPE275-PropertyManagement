package com.propertymanagement.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.propertymanagement.DTO.AdvertsimentInfo;
import com.propertymanagement.agent.AgentManager;

/**
 * Servlet implementation class CreateAdd
 */
@WebServlet("/CreateAdd")
public class CreateAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateAdd() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		AdvertsimentInfo addInfo = new AdvertsimentInfo();
		addInfo.setPropertyId(request.getParameter("pId"));
		addInfo.setPropertyInfo((request.getParameter("pInfo")).trim());
		addInfo.setPropertyType(request.getParameter("pType"));
		addInfo.setAddress(request.getParameter("pAdd"));
		addInfo.setCityName(request.getParameter("pCity"));
		addInfo.setZipCode(request.getParameter("pZip"));
		addInfo.setLang(request.getParameter("pLong"));
		addInfo.setLat(request.getParameter("pLat"));
		addInfo.setPrice(request.getParameter("pPrice"));

		AgentManager aManager = (AgentManager) session.getAttribute("manager");
		addInfo.setAgentId(aManager.getAgentInfo().getuId());
		aManager.setAddInfo(addInfo);
		response.sendRedirect("Create_Add_Img.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("jbdaidbdaobdouboldubolub");
		HttpSession session = request.getSession();
		AgentManager aManager = (AgentManager) session.getAttribute("manager");
		aManager.createModifyAdd("new");
		response.sendRedirect("Display.jsp");
	}

}
