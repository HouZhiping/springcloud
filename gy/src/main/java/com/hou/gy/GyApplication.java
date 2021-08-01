package com.hou.gy;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.Proxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GyApplication {

	public static void main(String[] args) {

		try (Playwright playwright = Playwright.create()) {
			System.out.println("开始创建浏览器");
			BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
			launchOptions.setProxy(new Proxy("http://127.0.0.1:7890"));
			launchOptions.setHeadless(false).setSlowMo(5000);
			Browser browser = playwright.chromium().launch();
			Page page = browser.newPage();
			page.navigate("http://www.facebook.com/");
			System.out.println(page.title());
//            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
		}
		SpringApplication.run(GyApplication.class, args);
	}

}
