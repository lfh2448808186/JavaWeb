package xust.lfh.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import static java.awt.Color.*;

@WebServlet(urlPatterns = "/CheckCodeServlet" )
public class CheckCode extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //1.创建一个对象，在内存中图片对象（）
        int width = 180;
        int height = 50 ;

        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        //2.美化图片
            //2.21填充背景色
        Graphics g = image.getGraphics();
        g.setColor(PINK);
        g.fillRect(0,0 ,width,height);
            //2.2划边框
        g.setColor(blue);
        g.drawRect(0,0,width-1,height-1);

        String str  = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        //生成随机角标
        Random ran = new Random();

        StringBuilder sb = new StringBuilder();
            //2.3写出验证码
        for (int i = 1; i <5 ; i++) {
            int index =ran.nextInt(str.length());
            char ch = str.charAt(index);
            sb.append(ch);
            g.drawString(""+ch,width/5*i,height-20);

        }
        String checkCode_session = sb.toString();
        /*
          将创建的验证码，保存在Session之中，确保在后台验证的时候能够正确对比。
         */
        request.getSession().setAttribute("checkCode_session",checkCode_session);
            //2.4划干扰线
        g.setColor(yellow);
        for (int i = 0; i <10 ; i++) {
            int x1 = ran.nextInt(width);
            int x2 = ran.nextInt(width);
            int y1 = ran.nextInt(height);
            int y2 = ran.nextInt(height);
            g.drawLine(x1,y1,x2,y2);
        }



        //3.输出图片
        ImageIO.write(image,"jpg",response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
