package com.springmvc.controller;


import com.springmvc.domain.Brand;
import com.springmvc.domain.Shop;
import com.springmvc.service.BrandService;
import com.springmvc.service.ShopService;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class ShopController {
    @Autowired
    private ShopService shopService;
    @Autowired
    private BrandService brandService;

    @RequestMapping("/insertShop")
    public String insertShop(HttpServletRequest request) throws IOException {
        int newsid=Integer.parseInt(request.getParameter("newsid"));
        String newsname=request.getParameter("newsname");
        int newnum=Integer.parseInt(request.getParameter("newnum"));
        int newprice=Integer.parseInt(request.getParameter("newprice"));
        String brand=request.getParameter("brand");

        Brand brand1=brandService.FindBrand_shop(brand);
        Shop newshop=new Shop(newsid,newsname,newnum,newprice,"aaa",brand1.getBid());
        shopService.insertShop(newshop);//添加

        return "index";
    }

    //修改一条商品
    @RequestMapping("/updateShop")
    public String updateShop(HttpServletRequest request,RedirectAttributes ra) throws IOException {
        int sid=Integer.parseInt(request.getParameter("sid"));
        Shop shop=shopService.FindShopBySid(sid);
        int newnum=Integer.parseInt(request.getParameter("newnum"));
        int newprice=Integer.parseInt(request.getParameter("newprice"));
        shop.setNum(newnum);
        shop.setPrice(newprice);
        shopService.updateShop(shop);  //update商品

        //获取bname 并传参到findShop 返回主页
        HttpSession session=request.getSession();
        String bname=(String) session.getAttribute("bname");
        ra.addAttribute("bname",bname);
        return "redirect:/findShop";
    }


    //删除一条商品
    @RequestMapping("/deleteShopBySid")
    public String deleteShopBySid(HttpServletRequest request, RedirectAttributes ra) throws IOException {
        int sid=Integer.parseInt(request.getParameter("deleteSid"));
        shopService.deleteShopBySid(sid);
        HttpSession session=request.getSession();
        String bname=(String) session.getAttribute("bname");
        System.out.println("aa"+bname);
        ra.addAttribute("bname",bname);
        return "redirect:/findShop";
    }



}
