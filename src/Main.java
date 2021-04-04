import java.io.IOException;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		if(request.getParameter("keyword")== null) {
			String requestUri = request.getRequestURI();
			request.setAttribute("requestUri", requestUri);
			request.getRequestDispatcher("HomePage.jsp").forward(request, response);
			return;
		}
		
		String keyword = request.getParameter("keyword");
		request.setAttribute("keyword", keyword);
		GoogleQuery google = new GoogleQuery(keyword);
		HashMap<String, String> query = google.query();
		
		WordCounter counter = new WordCounter();
		ArrayList<Web> arr = new ArrayList<Web>();
		for(String key : query.keySet()) {
			int endIndex = query.get(key).indexOf("&");
			String url = query.get(key).substring(7, endIndex);
			double score = counter.countScore(url);
			arr.add(new Web(key,url,score));
		}
		Collections.sort(arr, new Sort());
		
		String[][] s = new String[arr.size()][2];
		request.setAttribute("query", s);
		int num = 0;
		for(Web element : arr) {
		    String key = element.name;
		   String value = element.url;
		    s[num][0] = key;
		    s[num][1] = value;
		    num++;
		}
		request.getRequestDispatcher("ResultPage.jsp")
		 .forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
