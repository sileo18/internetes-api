package com.example.internetes_api.controller;

import com.example.internetes_api.dtos.ContactFormDTO;
import com.example.internetes_api.service.EmailService;
// import jakarta.validation.Valid; // Se estiver usando validações no DTO
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    private static final Logger logger = LoggerFactory.getLogger(ContactController.class);

    @Autowired
    private EmailService emailService;

    // Adicione @CrossOrigin se seu frontend estiver em um domínio/porta diferente
    // Ex: @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/send")
    public ResponseEntity<String> sendContactMessage(
            /*@Valid*/ @RequestBody ContactFormDTO contactFormDTO) { // Descomente @Valid se usar validações
        try {
            logger.info("Recebida solicitação de contato: {}", contactFormDTO);
            emailService.sendContactFormEmail(contactFormDTO);
            return ResponseEntity.ok("Mensagem enviada com sucesso!");
        } catch (Exception e) {
            logger.error("Falha ao processar solicitação de contato: {}", e.getMessage());
            // Não exponha detalhes internos do erro para o cliente em produção
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Falha ao enviar mensagem. Por favor, tente novamente mais tarde.");
        }
    }
}
