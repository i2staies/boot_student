package com.itguigu.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件上传测试
 */
@Slf4j
@Controller
public class FormTestController {
    @GetMapping("form_layouts")
    public String form_layouts(){
        return "form/form_layouts";
    }

    /**
     * MultipartFile: 自动封装上传上来的文件
     * 在MultipartAutoConfiguration:文件上传解析器
     * 自动配置好了文件上传的大小设置，默认认为
     *      所有的请求文件上传大小不能超过10MB
     *      最大的文件不能超过1MB
 *      可通过在yml中设置spring.servlet.multipart.max-file-size=
     * @param email
     * @param username
     * @param headerImg
     * @param photos
     * @return
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImg")MultipartFile headerImg,
                         @RequestPart("photos")MultipartFile[] photos) throws IOException {

        log.info("上传的信息：email={},username={},headerImg={},photos={}",
                email,username,headerImg.getSize(),photos.length);
        if(!headerImg.isEmpty()){
            String originalFilename = headerImg.getOriginalFilename();
            headerImg.transferTo(new File("E:\\life\\尚硅谷Java学科全套教程（总207.77GB）\\尚硅谷Springboot2核心技术（好评如潮）\\img\\"+originalFilename));
        }

        if(photos.length > 0){
            for (MultipartFile photo : photos) {
                if(!photo.isEmpty()){
                    String originalFilename = photo.getOriginalFilename();
                    photo.transferTo(new File("E:\\life\\尚硅谷Java学科全套教程（总207.77GB）\\尚硅谷Springboot2核心技术（好评如潮）\\img\\"+originalFilename));
                }
            }
        }
        return "main";
    }

/*    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImg")MultipartFile headerImg,
                         @RequestPart("photos")MultipartFile[] photos) throws IOException {

        log.info("上传的信息：email={},username={},headerImg={},photos={}",
                email,username,headerImg.getSize(),photos.length);
        if(!headerImg.isEmpty()){
            InputStream inputStream = headerImg.getInputStream();
            FileOutputStream fileOutputStream = new FileOutputStream(new File("E:\\life\\尚硅谷Java学科全套教程（总207.77GB）\\尚硅谷Springboot2核心技术（好评如潮）\\img\\"+headerImg.getOriginalFilename()));
            byte bytes[] = new byte[1024*8];
            int len;
            while((len = inputStream.read(bytes))!=-1){
                fileOutputStream.write(bytes,0,len);
            }
            inputStream.close();
            fileOutputStream.close();
        }
        return "main";
    }*/
}
