package com.kuang;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class Boot06TaskApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    void contextLoads() {

        //一个简单的邮件
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("通知：明天来狂神这听课");
        message.setText("今晚七点半开会");

        message.setTo("468685628@qq.com");
        message.setFrom("468685628@qq.com");
        mailSender.send(message);
    }

    @Test
    public void contextLoads2() throws MessagingException {
        //邮件设置2：一个复杂的邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setSubject("通知-明天来狂神这听课");
        helper.setText("<b style='color:red'>今天 7:30来开会</b>",true);

        //发送附件
        helper.addAttachment("1.jpg",new File("C:\\Users\\WangLi\\Desktop\\1.png"));
        helper.addAttachment("2.jpg",new File("C:\\Users\\WangLi\\Desktop\\1.png"));

        helper.setTo("468685628@qq.com");
        helper.setFrom("468685628@qq.com");

        mailSender.send(mimeMessage);
    }

}
