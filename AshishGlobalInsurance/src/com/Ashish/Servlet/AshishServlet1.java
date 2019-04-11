package com.Ashish.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/AshishServlet1","/temp"})	//temp as a shortcut to AshishServlet1 as defined in the xml file
public class AshishServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     public AshishServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//request.getRequestDispatcher("/main.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double baseCost =0.0;  //depends according to the insurance type
		
		try {
			response.setContentType("text/html");	//displays the output in html form
			PrintWriter out = response.getWriter();
			
			//gets values from main.jsp page
			String fName=request.getParameter("first_name");		
			String lName=request.getParameter("last_name");
	        String email=request.getParameter("email"); 
	        String age=request.getParameter("age");
	        int getAge = Integer.parseInt(age);
	        String gender=request.getParameter("gender");
	        String healthIssues=request.getParameter("healthIssues");
	        String badHabbits=request.getParameter("badHabbits");
	        String insuranceType=request.getParameter("insuranceType");
	        
			//Premium Calculation Part
	        switch (insuranceType) {
			case "Auto":
				baseCost = 100.0;
				if (getAge >= 18 && getAge <25) {      //People get wiser as they age, so the risk of getting into car wreck goes down. Thus, policy holder get discount as she/he gets older
					baseCost = baseCost * 1.4;			//40% higher then the baseCost
				}else if (getAge >=25 && getAge <30){
					baseCost = baseCost * 1.3;			//30% higher then the baseCost
				}else if (getAge >=30 && getAge <35){
					baseCost = baseCost * 1.2;			//20% higher then the baseCost
				}else if (getAge >=35 && getAge <40){
					baseCost = baseCost * 1.1;			//10% higher then the baseCost
				}else if (getAge >=40){
					baseCost = baseCost * 1.0;			//same as the base cost
				}
				break;

			case "Life": case "Health":
				if 	(insuranceType.equals("Life")) {
					baseCost = 30.0;
				}else if (insuranceType.equals("Health")) {
					baseCost = 120.0;
				}

				if (getAge >= 18 && getAge <25) {		//the premiums goes up over time as the policy holder ages
					baseCost = baseCost * 1.0;			
				}else if (getAge >=25 && getAge <30){
					baseCost = baseCost * 1.1;			
				}else if (getAge >=30 && getAge <35){
					baseCost = baseCost * 1.2;			
				}else if (getAge >=35 && getAge <40){
					baseCost = baseCost * 1.3;			
				}else if (getAge >=40){
					baseCost = baseCost * 1.4;			
				}
				break;
			default:
				out.print("Error: Type of insurance unknown");
				return;
			}
	        
			if (gender.equals("Male")) {
				baseCost = baseCost * 1.1;			//Premium is high for a male policy holder
			}
	
			if (healthIssues.equals("Yes")) {
				baseCost = baseCost * 1.1;			//Premium is high when a policy holder has health issues
			}
	
			if (badHabbits.equals("Yes")) {
				baseCost = baseCost * 1.1;			//Premium is high  when a policy holder has bad habbits
			}
			// Premium calculation ends
			
			out.print("<head>");
			out.print("<title>ASHISH GLOBAL INSURANCE</title>");
			out.print("<style>");		//sets the css for the objects below
			out.print("#tit {color:White; border-style:solid; text-align:center; background: #ff0000; vertical-align:middle; opacity:0.8; font-size: 24px;}");
			out.print("hr {display:block; border-width:3px;}");
			out.print("label {color:Black; font-weight:Regular; font-size:19; text-align:right;}");
			out.print("#tbox {font-size:16;}");
			out.print("p {color:brown}");
			out.print(".button {background-color:#ff0000; border:none; color:white; padding:7px 16px; text-align:center; text-decoration:none; display:inline-block;font-size:16px; margin:4px 2px; cursor:pointer;}");
			out.print("#topTit{border-radius:1%/100%; border:1px solid #000; color:White; border-style:solid; text-align:center; background: #ff0000; vertical-align:middle; opacity:0.8; font-size: 24px;}");
			out.print("div {position: absolute; top:0; bottom: 0; left: 0; right: 0; margin: auto; width: 400px; height: 400px;}");
			out.print("th, td {font-size:19;}");
			out.print("</style>");
			out.print("</head>");
			
			out.print("<body>");  
			out.print("<div>");
			out.print("<form action=\"index.html\">");
			out.print("<table width=\"400px\" bgcolor=\"#D3D3D3\">");
			out.print("<col width=\"150\">");
			
			out.print("<th colspan=\"2\" id=\"tit\">");
			out.print("GENERATED QUOTE:");		//Prints the heading
			out.print("</th>");
			
			out.print("<tr>");		//This statement prints first name row
			out.print("<td valign=\"top\">");
			out.print("<label for=\"first_name\">First Name: </label>");
			out.print("</font>");
			out.print("</td>");
			out.print("<td valign=\"top\">");
			out.println(fName);
			out.print("</td>");
			out.print("</tr>");
			
			out.print("<tr>"); 		//This statement prints last name row
			out.print("<td valign=\"top\">");
			out.print("<label for=\"last_name\">Last Name: </label>");
			out.print("</td>");
			out.print("<td valign=\"top\">");
			out.println(lName);
			out.print("</td>");
			out.print("</tr>");
			
			out.print("<tr>"); 		//This statement prints Email row
			out.print("<td valign=\"top\">");
			out.print("<label for=\"email\">Email Id: </label>");
			out.print("</td>");
			out.print("<td valign=\"top\">");
			out.println(email);
			out.print("</td>");
			out.print("</tr>");
			
			out.print("<tr>");		//This statement prints age row
			out.print("<td valign=\"top\">");
			out.print("<label for=\"age\">Age: </label>");
			out.print("</td>");
			out.print("<td valign=\"top\">");
			out.println(age);
			out.print("</td>");
			out.print("</tr>");
			
			out.print("<tr>");		//This statement prints gender row
			out.print("<td valign=\"top\">");
			out.print("<label for=\"gender\">Gender: </label>");
			out.print("</td>");
			out.print("<td valign=\"top\">");
			out.println(gender);
			out.print("</td>");
			out.print("</tr>");
				
			out.print("<tr>");		//This statement prints health issues
			out.print("<td valign=\"top\">");
			out.print("<label for=\"healthIssues\">Health Issues: </label>");
			out.print("</td>");
			out.print("<td valign=\"top\">");
			out.println(healthIssues);
			out.print("</td>");
			out.print("</tr>");
			
			out.print("<tr>");		//This statement print bad habbits row
			out.print("<td valign=\"top\">");
			out.print("<label for=\"badHabbits\">Bad Habbits: </label>");
			out.print("</td>");
			out.print("<td valign=\"top\">");
			out.println(badHabbits);
			out.print("</td>");
			out.print("</tr>");
			
			out.print("<tr>");		//This statement prints the total cost of the insurance
			out.print("<td valign=\"top\" colspan =2>");
			out.print("<label for=\"badHabbits\">Your monthly " + insuranceType + " insurance cost is only $" + String.format("%.2f", baseCost) + ". <br> Hurry up and get your insurance today!</label>"); //string format puts baseCost in two decimal places
			out.print("</td>");
			out.print("</tr>");
			
			out.print("<tr>");
			out.print("<td></td>");
			out.print("<td style=\"text-align:Left\">");
			out.print("<input type=\"submit\" class=\"button\" value=\"HOME\">");		//Prints the home button
			out.print("</td>");
			out.print("</tr>");
			
			out.print("</table>");
			out.print("</form>");
			out.print("</div>");
			out.print("</body>");
			
			out.close();
		} catch (Exception e) {System.out.println(e);}
	}

}
