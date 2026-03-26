package br.com.cwi.FinAI.controller.response;
import lombok.*;

import java.sql.Timestamp;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DetalharProdutoRespone {

    private String id;

    private String nome;

    private String taxa;

    private String email;

    private Double rendaMensal;

    private int score;

    private Date dataNascimento;

    private Timestamp dataCriacao;

    private Timestamp atualizadoEm;

}
