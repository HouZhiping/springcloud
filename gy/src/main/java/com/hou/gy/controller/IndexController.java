package com.hou.gy.controller;

import com.hou.gy.entity.Res;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.Proxy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags={"5-buttonManage"})
@RestController
@RequestMapping("/index")
@RefreshScope
public class IndexController {


    @GetMapping("test")
    public Res<String> index(){
        return Res.success("index");
    }

    @Value("${useLocalCache:false}")
    private boolean useLocalCache;


    @ApiOperation(value = "1.getUseLocalCache")
    @RequestMapping("/get")
    public Res<Boolean> get() {
        return Res.success(useLocalCache);
    }

    @RequestMapping("/greeting")
    public Res<String> greeting() {
        return Res.success("Hello, I am gy-app");
    }




    public static void main(String[] args) {
        System.out.println("程序开始");
        try (Playwright playwright = Playwright.create()) {
            System.out.println("开始创建浏览器");
            BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
            launchOptions.setProxy(new Proxy("http://127.0.0.1:7890"));
            launchOptions.setHeadless(false);
            launchOptions.setTimeout(600000).setSlowMo(1000);
            Browser browser = playwright.chromium().launch(launchOptions);
            System.out.println(browser.isConnected());
            Page page = browser.newPage();
            System.out.println(browser.isConnected());
            browser.onDisconnected((a) -> System.out.println("浏览器关闭回调"));
            page.navigate("https://twitter.com/login");
            System.out.println("点击");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(page.title());
            browser.close();
//            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
        }


    }







}
