package com.md.dm.infovis;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mcavallo.opencloud.Cloud;
import org.mcavallo.opencloud.Tag;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		Cloud cloud = new Cloud();

		// Sets the number of tag to display in the cloud
		cloud.setMaxTagsToDisplay(100);

		// We want to partiton the tag weights into ten distinct levels,
		// so we set the maximum weight to 10.0.
		cloud.setMaxWeight(10.0);

		// Sets a default url to assign to tags.
		// The format specifier %s will be substituted by the tag name
		cloud.setDefaultLink("http://localhost:8080/vast-challenge/VIService");

		//Add sample tags with corresponding score
		cloud.addTag(new Tag("algerie",3.0));
		cloud.addTag(new Tag("amv",3.0));
		cloud.addTag(new Tag("chanson",4.0));
		cloud.addTag(new Tag("cheval",3.0));
		cloud.addTag(new Tag("concert",1.0));
		cloud.addTag(new Tag("concert",2.0));
		cloud.addTag(new Tag("concert",1.0));  // if we add a tag that is already present, the scores are summed
		cloud.addTag(new Tag("dance",7.0));
		cloud.addTag(new Tag("danse",5.0));
		cloud.addTag(new Tag("delire",3.0));
		cloud.addTag(new Tag("drole",4.0));
		cloud.addTag(new Tag("electro",5.0));
		cloud.addTag(new Tag("foot",5.0));
		cloud.addTag(new Tag("football",3.0));
		cloud.addTag(new Tag("france",5.0));
		cloud.addTag(new Tag("fun",4.0));
		cloud.addTag(new Tag("guitare",4.0));
		cloud.addTag(new Tag("humour",5.0));
		cloud.addTag(new Tag("live",5.0));
		cloud.addTag(new Tag("love",5.0));
		cloud.addTag(new Tag("manga",3.0));
		cloud.addTag(new Tag("maroc",6.0));
		cloud.addTag(new Tag("moi",5.0));
		cloud.addTag(new Tag("montage",3.0));
		cloud.addTag(new Tag("paris",4.0));
		cloud.addTag(new Tag("pub",3.0));
		cloud.addTag(new Tag("rock",3.0));
		cloud.addTag(new Tag("ski",3.0));
		cloud.addTag(new Tag("sport",3.0));
		cloud.addTag(new Tag("star",4.0));
		cloud.addTag(new Tag("tck",3.0));
		cloud.addTag(new Tag("TECKTONIK",10.0));
		cloud.addTag(new Tag("trailer",3.0));
		cloud.addTag(new Tag("voiture",3.0));

		request.setAttribute("Cloud", cloud);
		
		  getServletConfig().getServletContext().getRequestDispatcher(
	        "/charts/tagcloud.jsp").forward(request,response);

	}

}
