package br.edu.ifpe.bemvi_api.api.mensagemPrivada;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MensagemPrivadaDTO {

    private Long id;

    @NotNull(message = "O ID do remetente é de preenchimento obrigatório")
    private Long idRemetente;

    @NotNull(message = "O ID do destinatário é de preenchimento obrigatório")
    private Long idDestinatario;

    @NotBlank(message = "O texto da mensagem é de preenchimento obrigatório")
    private String textoMensagem;

    private LocalDateTime dataHoraEnvio;
}