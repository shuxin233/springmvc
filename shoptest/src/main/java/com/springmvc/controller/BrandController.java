package com.springmvc.controller;


        import com.springmvc.domain.Brand;
        import com.springmvc.service.BrandService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.RequestMapping;

        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import javax.servlet.http.HttpSession;
        import java.io.IOException;
        import java.util.List;

@Controller
public class BrandController {
    @Autowired
    private BrandService brandService;

    @RequestMapping("/index")
    public String index() throws IOException {
        System.out.println("返回首页");
        return "index";
    }

    @RequestMapping("/findShop")
    public String FindShop(Model model, HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException {
        String bname=request.getParameter("bname");
        Brand brand=brandService.FindBrand_shop(bname);
        session.setAttribute("bname",bname);
        model.addAttribute("brand", brand);
        return "index";
    }


    @RequestMapping("/findAllBrand")
    public String findAllBrand(Model model){
        List<Brand> brands=brandService.findAll();
        model.addAttribute("brandsAll",brands);
        return "index";
    }

}
