package com.cefet.dolphub.Entidades.Comunicacao;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "aviso", schema = "public")
public class Aviso {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aviso_sq")
    @SequenceGenerator(schema = "public", name = "aviso_sq", sequenceName = "aviso_sq", initialValue = 1, allocationSize = 1)
    @Column(name = "id_aviso")
    private Long id;

    @Column(name = "titulo_aviso")
    private String titulo;

    @Column(name = "mensagem_aviso")
    private String mensagem;
    
}
