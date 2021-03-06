package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 先访问a。在访问b 上下文测试。
 */
public class B extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public B() {
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("B service方法开始执行。。。。");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		/**
		 * ServletContent
		 */
		// 获得ServletContent
		ServletContext sctx = getServletContext();
		// 绑定一些数据到ServletContent
		String gift = (String) sctx.getAttribute("gift");
		out.print("礼物：" + gift+"<br/>");
		/**
		 * 获取全局初始化参数
		 */
		String company = sctx.getInitParameter("company");
		out.println("全局初始化参数："+company);
		/**
		 * session
		 */
		// HttpSession session = request.getSession();
		// String gift = (String) session.getAttribute("gift");

		
		out.close();
		System.out.println("B service方法执行完毕。。");
	}

}
