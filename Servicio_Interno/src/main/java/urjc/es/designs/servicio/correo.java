package urjc.es.designs.servicio;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class correo {

	@Autowired
	private JavaMailSender mailsender;
	
	public void sendMail(String to,String subject,String text) {
		
		MimeMessage message = mailsender.createMimeMessage();
		System.out.println("Estoyyy aqquii");
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message,true);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(text);
			
			FileSystemResource file = new FileSystemResource("factura.pdf");
			helper.addAttachment(file.getFilename(), file);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		mailsender.send(message);
		
	}
}
