package demo;
import com.jfinal.core.Controller;
import com.jfinal.core.Path;
import com.jfinal.kit.Ret;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

import java.util.List;

@Path("/AddController")
public class AddController extends Controller{
//	public void index(){
//		render("/AddController.html");
//	}
	public void index() {
		//跨域请求设置
		getResponse().addHeader("Access-Control-Allow-Origin", "*");
		//从前端获取数据
		String Name = getPara("name");
		String Age = getPara("age");
		System.out.println(Db.findById("test",2));

//		List<String> titleList = Db.query("select user from test");
		List<Record> titleList = Db.find("select * from test");
		System.out.println(titleList);
//		renderJson(titleList);



//		向数据库添加数据
//		Record user = new Record().set("user", "James").set("age", 25).set("id",4);
//		System.out.println(user);
//		Db.save("test", user);


		System.out.println("姓名:"+Name+"\t年龄:"+Age);
		//设置前端数据，渲染成Json
//		setAttr("name",Name);
//		setAttr("age",Age);
//		renderJson();
//		renderJson (Ret.ok ("name", Name).set("age", Age));
//		render("/AddController.html");

//		renderJson(Ret.by("code", 0).set("msg", "").set("data", (Object)null));
		renderJson(Ret.ok("data", titleList));
	}

//	从数据库获取数级
	public void getList(){
		List<Record> users = Db.find("select * from user where age > 18");

	}

//	后端数据加载到前端
	public void loadList(){

	}
}


