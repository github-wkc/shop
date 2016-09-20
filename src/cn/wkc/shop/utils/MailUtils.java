package cn.wkc.shop.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtils {

	public static void sendMail(String to, String code) {

		/**
		 * 1.获得一个Session对象. 2.创建一个代表邮件的对象Message. 3.发送邮件Transport
		 */
		// 1.获得连接对象

		Properties props = new Properties();
		props.setProperty("mail.smtp.auth", "true"); // 这个必须的加
		props.setProperty("mail.smtp.host", "smtp.163.com"); // 发邮件的主机

		Session session = Session.getInstance(props, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("17702439560@163.com",
						"wkc15114292393"); // 认证下账户
			}

		});
		// 2.创建邮件对象:
		Message message = new MimeMessage(session);
		// 设置发件人:
		try {
			message.setFrom(new InternetAddress("17702439560@163.com"));
			// 设置收件人:
			message.addRecipient(RecipientType.TO, new InternetAddress(to));
			// 抄送 CC 密送BCC
			// 设置标题
			message.setSubject("来自购物天堂传智商城官方激活邮件");
			// 设置邮件正文:
			// message.setContent(
			// "<h1>购物天堂传智商城官方激活邮件!点下面链接完成激活操作!</h1><h3><a href='http://192.168.36.103:8080/shop/user_active.action?code="
			// + code
			// + "'>http://192.168.36.103:8080/shop/user_active.action?code="
			// + code + "</a></h3>", "text/html;charset=UTF-8");
			message.setContent(
					"<h1>购物天堂激活邮件，请点击以下链接完成激活</h1><h3><a href='http://172.24.14.90:8080/"
							+ "shop_myself/user_active.action?code=" + code
							+ "'>http://169.254.182.254:8080/shop_myself/"
							+ "user_active.action?code=" + code + "<a/></h3>",
					"text/html;charset=utf-8");
			// 注意ip地址是有可能变化的，没连一次互联网，就有可能变化一次
			// 3.发送邮件:
			Transport.send(message);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		sendMail("1123038154@qq.com", "11134535");
		
	}

}
