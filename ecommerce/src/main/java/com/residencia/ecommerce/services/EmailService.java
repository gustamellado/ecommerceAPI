package com.residencia.ecommerce.services;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.residencia.ecommerce.exceptions.EmailException;
import com.residencia.ecommerce.vo.FecharPedidoVO;
import com.residencia.ecommerce.vo.ProdutoQtdVO;

@Component
public class EmailService {
	@Autowired
	private JavaMailSender emailSender;

	@Value("${spring.mail.username}")
	private String emailRemetente;
	
	@Value("${spring.mail.host}")
	private String emailServerHost;
	
	@Value("${spring.mail.port}")
	private Integer emailServerPort;
	
	@Value("${spring.mail.username}")
	private String emailServerUserName;
	
	@Value("${spring.mail.password}")
	private String emailServerPassword;
	
	@Value("${spring.mail.protocol}")
	private String emailServerProtocol;
	
	public JavaMailSender javaMailSender() {

		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		Properties prop = new Properties();

		mailSender.setHost(emailServerHost);
		mailSender.setPort(emailServerPort);
		mailSender.setUsername(emailServerUserName);
		mailSender.setPassword(emailServerPassword);
		mailSender.setProtocol("smtp");
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.starttls.enable", false);
		mailSender.setJavaMailProperties(prop);

		return mailSender;

	}

	public void emailFecharPedido(FecharPedidoVO fpVO) throws MessagingException, EmailException {

		this.emailSender = javaMailSender();

		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		try {
			helper.setFrom(emailRemetente);
			helper.setTo("Grupo4@gmail.com");
			helper.setSubject("Pedido Id " + fpVO.getPedidoId());

			SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
			List<ProdutoQtdVO> listProdQtd= new ArrayList<>();
			listProdQtd = fpVO.getListProdutoQtd();
			Calendar c = Calendar.getInstance();
			c.setTime(new Date()); // Using today's date
			c.add(Calendar.DATE, 10); // Adding 5 days
			DecimalFormat dfMoeda = new DecimalFormat("R$ ,##0.00");

			StringBuilder sBuilder = new StringBuilder();
			sBuilder.append("<html>\r\n");
			sBuilder.append("	<body>\r\n");
			sBuilder.append("		<div align=\"center\">\r\n");
			sBuilder.append("			PEDIDO\r\n");
			sBuilder.append("		</div>\r\n");
			sBuilder.append("		<br/>\r\n");
			sBuilder.append("		<center>\r\n");
			sBuilder.append("		<table border='1' cellpadding='5'  >\r\n");
			sBuilder.append("<tr><th>Produto</th><th>Quantidade</th></tr>\r\n");
			for(ProdutoQtdVO pp :listProdQtd) {
			sBuilder.append("		<tr>\r\n");
			sBuilder.append("			<td>\r\n");
			sBuilder.append( pp.getNomeProduto());
			sBuilder.append("			</td>\r\n");
			sBuilder.append("			<td>\r\n");
			sBuilder.append(    pp.getQuantidade());
			sBuilder.append("			</td>\r\n");
			sBuilder.append("		</tr>\r\n");
			}
			sBuilder.append("		</table>\r\n");
			sBuilder.append("Valor Total: " + dfMoeda.format(fpVO.getValorCompra()) +"\r\n");
			sBuilder.append("Data de entrega: " + sdfData.format(c.getTime()));
			sBuilder.append("		</center>\r\n");
			sBuilder.append("	</body>\r\n");
			sBuilder.append("</html>");

			helper.setText(sBuilder.toString(), true);

			emailSender.send(message);

		} catch (Exception e) {
			throw new EmailException("Houve erro ao enviar o email de Nota Fiscal: " + e.getMessage());
		}

	}

}