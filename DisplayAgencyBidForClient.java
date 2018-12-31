package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nis.controller.BookingController;
import com.nis.controller.ClientControllerSak;

/**
 * Servlet implementation class DisplayAgencyBidForClient
 */
@WebServlet("/DisplayAgencyBidForClient")
public class DisplayAgencyBidForClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAgencyBidForClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		try{
			ResultSet rs=ClientControllerSak.showAllBid(request.getParameter("emailid"));
			out.println("<html>");
			out.println("<table border=1>");
			out.println("<caption> List of Agency Bids</caption>");
			if(rs.next())
			{
			out.println("<tr><th>Sn</th><th>Booking Id</th><th>Source/<br>Destination</th><th>From/<br>To</th><th>Vehicle</th><th>Current<Br>Date/Time</th><th>BidAmount</th><th>Confirm</th></tr>");
			int sn=1;
			do
			{
		    out.println("<tr><td>"+sn+"</td><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"<br>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>From "+rs.getString(7)+"<br> to "+rs.getString(8)+"</td><td>"+rs.getString(9)+"</td><td><a href=#>Confirm</a></td></tr>");		
			}while(rs.next());
			out.print("</table></html>");
			}
			else
			{
			 out.println("No Bookings...");	
			}
			
			out.flush();
		}catch(Exception e)
		{
			out.println(e);
		}
		
	}

}
