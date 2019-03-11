package com.spring.aop;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;

import java.awt.*;

public class QrCodeTest {
    public static void main(String[] args) {
        QrConfig config = new QrConfig(300, 300);
// 设置边距，既二维码和背景之间的边距
        config.setMargin(3);
        Color foreColor=new Color(238,110,115);
        config.setImg("D:/mine1.jpg");
        int foreColorRGB=foreColor.getRGB();
        config.setForeColor(foreColorRGB);
        config.setBackColor(Color.white.getRGB());
        QrCodeUtil.generate("https://www.jianshu.com/u/b24032c00cf3",config,FileUtil.file("D:/mine.jpg"));


    }
}

