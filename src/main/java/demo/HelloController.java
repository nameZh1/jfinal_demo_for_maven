package demo;
import com.jfinal.core.Controller;
import com.jfinal.core.Path;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import jdk.nashorn.internal.lookup.MethodHandleFactory;

import java.util.List;

@Path("/hello")
public class HelloController extends Controller{
	public void index(){
		render("/hello.html");
	}
	public void show() {

		System.out.println(Db.find("select version()"));
		Record user = new Record();

//		Record user = new Record().set("user", "James").set("age", 25);
//		Db.save("test", user);

//		Db.deleteById("test", 4);

//		Record user = Db.findById("test", 1).set("age", 3);
//		Db.update("test", user);

//		System.out.println(Db.findById("test",1));
//		System.out.println(Db.query("select user from test"));

//		String sql = Db.getSql("sql指令名");
//		List<Record> users = Db.find(sql, 18);
//
		user = Db.findById("project_approval1",1);
//		renderJson(users);

		setAttr("user",user);

//		renderText("Hello Jfinal world.");

		render("/hello.html");
	}
	public void test() {
		renderText("abc");
	}
}
