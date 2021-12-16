package com.example.version2.controller.form;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Data @NoArgsConstructor @Getter @Setter
public class CheckoutForm {

    @NotBlank(message = "Champ obligatoire")
    private String nom;

    @Email
    private String email;

    @NotBlank
    @Pattern(regexp = "^(([+])[0-9]{1,3}|0[1-9])(((\\s[0-9]{1,3}){4,})|([0-9]*))$", message = "Numero de telephone invalide")
    private String numero;

    @NotBlank
    private String city;

    @NotNull
    @Size(min = 0, max = 99999)
    private String codePostal;
}
