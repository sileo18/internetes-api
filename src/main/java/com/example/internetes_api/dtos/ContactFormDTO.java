package com.example.internetes_api.dtos;

public class ContactFormDTO {

    // @NotBlank(message = "O nome é obrigatório")
    // @Size(min = 2, message = "O nome deve ter pelo menos 2 caracteres")
    private String name;

    // @NotBlank(message = "O email é obrigatório")
    // @Email(message = "Formato de email inválido")
    private String email;

    // @NotBlank(message = "O assunto é obrigatório")
    private String subject;

    // @NotBlank(message = "A mensagem é obrigatória")
    // @Size(min = 10, message = "A mensagem deve ter pelo menos 10 caracteres")
    private String message;

    // Getters e Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ContactFormDto{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}