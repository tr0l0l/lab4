package lab.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.ResourceBundle;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BusList
 */
public class BusList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusList() {
        super();
        // TODO Auto-generated constructor stub
    } 
    /** 
    * Processes requests for both HTTP <code>GET</code> and <code>POST</code> 
    methods. 
    response) 
    * 
    * @param request servlet request 
    * @param response servlet response 
    * @throws ServletException if a servlet-specific error occurs 
    * @throws IOException if an I/O error occurs 
    */ 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)     
    	    throws ServletException, IOException {
    	String lang = request.getParameter("lang");
        if (lang == null) {
            response.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE, "Ожидался параметр lang");
            return;
        }
        if (!"en".equalsIgnoreCase(lang) && !"ru".equalsIgnoreCase(lang)) {
            response.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE, "Параметр lang может принимать значение en или ru");
            return;
        }

        response.setContentType("text/html;charset=UTF-8");

        ResourceBundle res = "en".equalsIgnoreCase(lang)
                ? ResourceBundle.getBundle("Bus", Locale.ENGLISH)
                : ResourceBundle.getBundle("Bus", Locale.ROOT);

        PrintWriter out = response.getWriter();
            try { 
            	out.println("<html>");
                out.println("<head><title>");
                out.print(res.getString("title"));
                out.println("</title></head>");
                out.println("<body>");
                out.println("<h1>");
                out.print(res.getString("title"));
                out.println("</h1>");
                out.println("<table border='1'>");
                out.println("<tr><td><b>");
                out.print(res.getString("bus")); 
                out.println("</b></td><td><b>");
                out.print(res.getString("driver"));
                out.println("</b></td><td><b>");
                out.print(res.getString("worked"));
                out.println("</b></td></tr>");
 
                out.println("<tr><td>123</td><td>Иван Иванович</td><td>Да</td></tr>"); 
                out.println("<tr><td>321</td><td>Олег Иванович</td><td>Нет</td></tr>"); 
                out.println("</table>"); 
                out.println("</body>"); 
                out.println("</html>"); 
            } finally { 
                out.close(); 
            } 
        } 
    
    
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
