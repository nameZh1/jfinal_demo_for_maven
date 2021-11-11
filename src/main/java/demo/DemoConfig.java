package demo;

import com.jfinal.config.*;
import com.jfinal.core.Controller;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.dialect.OracleDialect;
import com.jfinal.plugin.activerecord.dialect.PostgreSqlDialect;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.render.ViewType;
import com.jfinal.server.undertow.UndertowServer;
import com.jfinal.template.Engine;

import java.io.Console;

public class DemoConfig extends JFinalConfig {
//	main方法，应该新建一个App.java
//	public static void main(String[] args) {
//		UndertowServer.start(DemoConfig.class, 80, true);
//	}
	// 配置常量 配置开发模式，true 值为开发模式
	public void configConstant(Constants me) {
		PropKit.use("config.properties");
		me.setDevMode(true);
	}
//	 使用路由扫描，参数 "demo." 表示只扫描 demo 包及其子包下的路由
	public void configRoute(Routes me) {
	me.scan("demo.");
	}

//	public void configRoute(Routes me) {
//		me.add("/user", AddController.class);
//	}

	public void configEngine(Engine me) {}
	public void configPlugin(Plugins me) {
		DruidPlugin dp = new DruidPlugin("jdbc:postgresql://localhost/zh1", "postgres", "pg123.");
		me.add(dp);
		ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);

		me.add(arp);
		arp.addMapping("test", User.class);
//		pg方言
		arp.setDialect(new PostgreSqlDialect());

	}
	public void configInterceptor(Interceptors me) {
		me.add(new CORS());
	}
	public void configHandler(Handlers me) {}

	// 跨域拦截
}
