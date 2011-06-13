package com.md.dm.infovis;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.mcavallo.opencloud.Cloud;
import org.mcavallo.opencloud.Tag;

import util.HibernateUtil;

import com.md.dm.vi.tp.entity.Microblog;

/**
 * Servlet implementation class TagCloud
 */
public class TagCloud extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TagCloud() {
		super();
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

			Cloud cloud = new Cloud();

			// Sets the number of tag to display in the cloud
			cloud.setMaxTagsToDisplay(100);

			// We want to partiton the tag weights into ten distinct levels,
			// so we set the maximum weight to 10.0.
			cloud.setMaxWeight(10.0);

			// Sets a default url to assign to tags.
			// The format specifier %s will be substituted by the tag name
			cloud.setDefaultLink("http://localhost:8080/vast-challenge/VIService");

			// Add sample tags with corresponding score
			cloud.addTag(this.createTagFor(session, "flu"));
			cloud.addTag(this.createTagFor(session, "fever"));
			cloud.addTag(this.createTagFor(session, "chill"));
			cloud.addTag(this.createTagFor(session, "sweats"));
			cloud.addTag(this.createTagFor(session, "aches"));
			cloud.addTag(this.createTagFor(session, "pain"));
			cloud.addTag(this.createTagFor(session, "fatigue"));
			cloud.addTag(this.createTagFor(session, "cough"));
			cloud.addTag(this.createTagFor(session, "breath"));
			cloud.addTag(this.createTagFor(session, "nausea"));
			cloud.addTag(this.createTagFor(session, "vomit"));
			cloud.addTag(this.createTagFor(session, "diarrhea"));

			request.setAttribute("Cloud", cloud);

			getServletConfig().getServletContext()
					.getRequestDispatcher("/charts/tagcloud/words.jsp")
					.forward(request, response);

			// End unit of work
			session.getTransaction().commit();

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

	private Tag createTagFor(Session session, String word) {

		Criteria criteria = session.createCriteria(Microblog.class);
		List result = criteria.add(Restrictions.like("text", "%" + word + "%"))
				.list();
		int size = result.size();
		return new Tag(word, size);
	}

}
