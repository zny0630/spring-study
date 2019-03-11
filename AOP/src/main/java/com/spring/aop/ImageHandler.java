package com.spring.aop;

import cn.hutool.core.util.ImageUtil;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

@Aspect
public class ImageHandler {
    private static final Logger logger= LoggerFactory.getLogger(ImageHandler.class);
    private int width;
    private int height;
    @Pointcut("execution(* com.spring.aop.ImageCopy.copyImage())")
    public void handleImage(){
    }
    @Before(value ="handleImage()")
    public void pressTextOnImage() throws IOException {
        logger.info("开始给图片添加水印");
        File srcFile=new File("D:/me.jpg");
        //创建一个BufferedImage对象
        InputStream input=new FileInputStream(srcFile);
        BufferedImage srcImg=ImageIO.read(input);

        int width=srcImg.getWidth();
        int height=srcImg.getHeight();
        System.out.println("原图宽:"+width+",原图高:"+height);

        File destFile=new File("D:/me1.jpg");
        Color color=new Color(8,190,217);
        int size=20;
        Font font=new Font("微软雅黑",Font.BOLD, 60);
        String text="楠";
        ImageUtil.pressText(srcFile,destFile,text,color,font,width/3,height/2-font.getSize(),1.0f);

    }
    @AfterReturning("handleImage()")
    public void grayImage(){
        logger.info("开始将图片转成黑白");
        File srcFile=new File("E:/me1.jpg");
        File destFile=new File("E:/me2.jpg");
        ImageUtil.gray(srcFile,destFile);
    }
}
