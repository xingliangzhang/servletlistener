package web;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 一， 什么是监听器？ 
 * servlet规范当中定义的一种组件，用来监听servlet容器产生的事件并进行处理 注： 主要有两大类事件：
 * a：生命周期相关事件：容器创建或者销毁了，request，session，ServletContext上下文 产生的事件
 * b：绑定数据相关的事件：执行了，request，session，Servlet上下文的setAttribute，
 * removeAttribute产生的事件。
 * 
 * 二， ServletContent上下文是什么？ 
 * 容器在启动之后，会为每一个web应用创建唯一的一个符合ServletContent接口
 * 要求的对象。该对象会一直存在，除非应用被卸载或者容器被关闭。
 * 
 * 三，如何去获得上下文？
 *  GenericServlet，
 *  ServletConfig
 *  FilterConfig，
 *  HttpSession 都提供了getServletContext方法。
 * 四，作用:
 * a.绑定数据
 *    setAttribute，getAttribute，removeAttribute
 *    request，session，ServletContext上下文都提供了绑定数据的3个方法
 * b.区别如下：
 *   1.绑定数据生存时间不一样，request<session<ServlerContent。
 *   2.可以访问的范围不一样:request绑定的数据只有同一个‘请求’所涉及的组件（转发）可以访问。
 *                   session绑定的数据只有同一个‘回话 ’所涉及的组件可以访问。
 *                   ServletContext上下文绑定的数据整个应用的所有组件均可以访问。
 * c. 访问全局的初始化参数
 *    所谓全局的初始化参数，指的是该参数可以被web.xml文件中配置的所有组件访问。
 */
public class CountListener implements HttpSessionListener {
	
	public CountListener() {
		System.out.println("监听器实例化。。。。");
	}
	/**
	 * session 对象创建时，会自动调用该放方法
	 */
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("监听器 session 对象创建。。。。");
       //人数加1
	   //先找到session
		HttpSession session=se.getSession();
		//然后通过session找到Servlet上下文
		ServletContext sctx=session.getServletContext();
		Integer count=(Integer) sctx.getAttribute("count");
		if(count==null) {
			count=1;
		}else {
			count++;
		}
		sctx.setAttribute("count", count);
	}

	/**
	 * session 对象销毁时，会自动执行
	 */
	public void sessionDestroyed(HttpSessionEvent se) {
		
		System.out.println("监听器 session 对象销毁。。。。");
		//人数减1
		HttpSession session=se.getSession();
		//然后通过session找到Servlet上下文
		ServletContext sctx=session.getServletContext();
		Integer count=(Integer) sctx.getAttribute("count");
		count--;
		sctx.setAttribute("count", count);
		/**
		 * 记住，默认session对象30分钟后才会销毁，想快点看到效果，加退出按钮，销毁session
		 */
	}

}
