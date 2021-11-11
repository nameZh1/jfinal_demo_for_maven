package demo;

import javax.servlet.http.HttpServletResponse;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;

public class CORS implements Interceptor {

	@Override
	public void intercept(Invocation inv) {
		// TODO Auto-generated method stub

		if(inv.isActionInvocation()){
			Controller c = inv.getController();
			HttpServletResponse response = c.getResponse();
//			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Headers", "Content-Type,X-Requested-With");
//			response.setHeader("withCredentials", "false");
		}

		inv.invoke();

	}

}
