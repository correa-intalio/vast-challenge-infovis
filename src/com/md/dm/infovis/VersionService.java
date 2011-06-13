package com.md.dm.infovis;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import util.HibernateUtil;

import com.md.dm.vi.tp.entity.Microblog;

/**
 * Servlet implementation class VersionService
 */
public class VersionService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public VersionService() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy");

		try {
			// Begin unit of work
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			Criteria criteria = session.createCriteria(Microblog.class);
			List result = criteria
					.add(Restrictions.like("text", "%flu%"))
					.add(Restrictions.between("userId", Long.valueOf(10),
							Long.valueOf(1000))).list();

			// Process request and render page...
			PrintWriter out = response.getWriter();

			for (Microblog microblog : (List<Microblog>) result) {
				out.println(microblog);
			}


			out.close();

			// End unit of work
			session
					.getTransaction().commit();
			
		} catch (Exception ex) {
			HibernateUtil.getSessionFactory().getCurrentSession()
					.getTransaction().rollback();
			if (ServletException.class.isInstance(ex)) {
				throw (ServletException) ex;
			} else {
				throw new ServletException(ex);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
