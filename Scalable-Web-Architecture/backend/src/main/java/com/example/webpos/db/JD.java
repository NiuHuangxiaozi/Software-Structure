package com.example.webpos.db;


import com.example.webpos.model.Category;
import com.example.webpos.model.Product;
import com.example.webpos.model.Setting;
import com.example.webpos.repository.CategoryRepository;

import jakarta.annotation.PostConstruct;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class JD implements PosDB {


    private List<Product> products = null;
    private CategoryRepository category_repository;

    @Autowired
    private List<Setting> Settings;

    public  JD(CategoryRepository cate){
        this.category_repository=cate;
    }

    @PostConstruct
    public void init(){
         //添加shop信息
         this.Settings.set(0,new Setting("$", true, 30,"settings.jpg", "教育超市", "上海市静安区教育大厦", "美国弗吉尼亚","15190785634","版权所有"));
    }

    @Override
    public List<Product> getProducts() {
        try {
            if (products == null)
                products = parseJD("Java");
        } catch (IOException e) {
            products = new ArrayList<>();
        }
        return products;
    }

    @Override
    public Product getProduct(String productId) {
        for (Product p : getProducts()) {
            if (p.getId().equals(productId)) {
                return p;
            }
        }
        return null;
    }

    public static List<Product> parseJD(String keyword) throws IOException {

        //计算程序运行的时间
        long stime = System.currentTimeMillis();

        //获取请求https://search.jd.com/Search?keyword=java
        String url = "https://search.jd.com/Search?keyword=" + keyword;
        //解析网页
        Connection connection = Jsoup.connect(url)
                    .timeout(10000).header("Cookie", "__jdv=122270672%7Cdirect%7C-%7Cnone%7C-%7C1714112474309; mba_muid=17141124743081154229562; mba_sid=17141124743152710446883681032.1; wlfstk_smdl=gukau3qnuk8u79fr1e9qnwgygfnlaj6q; __jdu=17141124743081154229562; _pst=jd_4512a9b3eecd9; logintype=qq; unick=jd_152093bkd; pin=jd_4512a9b3eecd9; npin=jd_4512a9b3eecd9; thor=C9314CFE846F229D2190D522979CD70425770D04D6539F6FD0E7636A213D53E322B48035D0CD2AC3B1328BC739936045E5D4F54CF112C8EE90B73D88E7FD0F1792F57A7A07862D60A8844D0553C925A51FEBDF845B68A7BF1E1EF1E2703D0B6606317E0D2389905758E9F7AC5AEB935A3E997EC6A765400521E93F7336D459D81DC61102C1FE53BFB2B82684DE5174C368CFC2F3C2B2AB0C40DD8B008FB70BF4; flash=2_Ynf6gQAxVVVygl0hXnQW8LpkNQVRpoPtdF8cu30xpTKNnij9vpfC6n82f7WQT-9GJetjatO6OCC2pbezMIugZM2VKkhj9zKGDLc9F5ipCrq8U7doriD5ebnIHqUSrCCZFWKjivf-cJx4nxu4utPKQe**; _tp=s7YG5PXrB5%2FoUY37o66S%2FfiWQF7W1ZK1ZNnrjXdjC%2Bs%3D; pinId=aeM2NBb2BlqWGVCJcRkULLV9-x-f3wj7; ipLoc-djd=12-904-0-0; jsavif=1; jsavif=1; shshshfpa=b484d30c-92a5-5dbb-b92c-ef3787ec959f-1714112505; shshshfpx=b484d30c-92a5-5dbb-b92c-ef3787ec959f-1714112505; __jda=143920055.17141124743081154229562.1714112474.1714112474.1714112474.1; __jdb=143920055.4.17141124743081154229562|1.1714112474; __jdc=143920055; 3AB9D23F7A4B3CSS=jdd03YRP7T2ZW2LXTGIOMN3VLWYVUNGKFM5MENIHYKOMDCVLN5BLSSNKYTP6S43RTKSWBRNHF63SSFIOU57NZ7PAQ6PVBMEAAAAMPDEISNAAAAAAADDGJACB463LJRAX; _gia_d=1; xapieid=jdd03YRP7T2ZW2LXTGIOMN3VLWYVUNGKFM5MENIHYKOMDCVLN5BLSSNKYTP6S43RTKSWBRNHF63SSFIOU57NZ7PAQ6PVBMEAAAAMPDEISNAAAAAAADDGJACB463LJRAX; shshshfpb=BApXcpbEZGupAcn0cYOKzDwvlhkA8KiRFBlZQIipo9xJ1MkV8NoC2; qrsc=1; rkv=1.0; areaId=12; 3AB9D23F7A4B3C9B=YRP7T2ZW2LXTGIOMN3VLWYVUNGKFM5MENIHYKOMDCVLN5BLSSNKYTP6S43RTKSWBRNHF63SSFIOU57NZ7PAQ6PVBME")
                    .userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/118.0.0.0 Safari/537.36"); // 设置你的 cookie 名称和值
        System.out.println("***************");
        // 获取 HTML 文档
        Document document = connection.get();
        System.out.println(document);
        // FileOutputStream fileOutputStream = new FileOutputStream("output.txt");
        // PrintWriter printWriter = new PrintWriter(fileOutputStream);
        // printWriter.println(document);
        
        // fileOutputStream.close();
        // printWriter.close();
        //所有js的方法都能用
        Element element = document.getElementById("J_goodsList");
        //获取所有li标签
        Elements elements = element.getElementsByTag("li");
//        System.out.println(element.html());
        List<Product> list = new ArrayList<>();

        //获取元素的内容
        for (Element el : elements
        ) {

            //关于图片特别多的网站，所有图片都是延迟加载的
            String id = el.attr("data-spu");
            System.out.println(id);
            String img = "https:".concat(el.getElementsByTag("img").eq(0).attr("data-lazy-img"));
            System.out.println(img);
            String price = el.getElementsByAttribute("data-price").text();
            String title = el.getElementsByClass("p-name").eq(0).text();
            if (title.indexOf("，") >= 0)
                title = title.substring(0, title.indexOf("，"));

            Product product = new Product(id, title, Double.parseDouble(price), img, 1, 0, 10);

            list.add(product);
        }

        long etime = System.currentTimeMillis();
        System.out.printf("执行时长：%d 毫秒.", (etime - stime));
        return list;
    }


    //lab5，先放在这里，到时候再实现
    //add in lab4 
    public List<Setting> getSettings(){
        return this.Settings;
    }

    public List<Category> getCategories(){
        List<Category> all_categories=this.category_repository.findAll();
        return all_categories;
    }

    public boolean setProduct(Product product){
        String Id=product.getId();
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getId()==Id){
                products.set(i, product);
                return true;
            }
        }
        return false;
    }

}
