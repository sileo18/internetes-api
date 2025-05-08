package com.example.internetes_api.service;

import com.example.internetes_api.dtos.ContactFormDTO;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${app.mail.to}") // Email para onde a mensagem será enviada
    private String mailTo;

    @Value("${app.mail.from}") // Email que aparecerá como remetente (pode ser sobrescrito pelo servidor SMTP)
    private String mailFrom;

    public void sendContactFormEmail(ContactFormDTO contactFormDTO) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8"); // "utf-8" para caracteres especiais

            String emailContent = buildEmailContent(contactFormDTO);

            helper.setText(emailContent, true); // true para indicar que o conteúdo é HTML (ou pode ser false para texto simples)
            helper.setTo(mailTo);
            helper.setSubject("Novo Contato do Site Internetes: " + contactFormDTO.getSubject());
            helper.setFrom(mailFrom); // O email do remetente real do formulário será incluído no corpo
            helper.setReplyTo(contactFormDTO.getEmail()); // Importante para responder diretamente ao usuário

            javaMailSender.send(mimeMessage);
            logger.info("Email de contato enviado com sucesso de {} para {}", contactFormDTO.getEmail(), mailTo);

        } catch (MessagingException | MailException e) {
            logger.error("Erro ao enviar email de contato: {}", e.getMessage());
            // Você pode querer lançar uma exceção customizada aqui para ser tratada no controller
            throw new RuntimeException("Erro ao enviar email: " + e.getMessage(), e);
        }
    }

    private String buildEmailContent(ContactFormDTO dto) {
        // Você pode usar um template engine (Thymeleaf, Freemarker) para emails mais complexos.
        // Para um email simples:
        return "<p>Você recebeu uma nova mensagem de contato do site Internetes:</p>" +
                "<p><strong>Nome:</strong> " + dto.getName() + "</p>" +
                "<p><strong>Email para Resposta:</strong> " + dto.getEmail() + "</p>" +
                "<p><strong>Assunto:</strong> " + dto.getSubject() + "</p>" +
                "<p><strong>Mensagem:</strong></p>" +
                "<p style=\"white-space: pre-wrap;\">" + dto.getMessage() + "</p>" + // pre-wrap para manter quebras de linha
                "<hr>" +
                "<p><em>Este email foi enviado através do formulário de contato do site Internetes.</em></p>";
    }
}