package com.informatorio.GameDevapirest.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Juego {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID",strategy="org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 36,columnDefinition = "varchar(36)",updatable = false,nullable = false)
    private UUID uuid;

    @Column(length = 100,columnDefinition = "varchar(100)",updatable = true,nullable = false)
    private String title;

    @Column(length = 250,columnDefinition = "varchar(250)",updatable = true,nullable = false)
    private String description;

    @Builder.Default
    @OneToMany(mappedBy = "juego",cascade = {CascadeType.REMOVE})
    private List<Desarrollador> desarrollador = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "juego",cascade = {CascadeType.REMOVE})
    private List<Tarea> tarea = new ArrayList<>();

    private LocalDateTime fechaLanzamiento;

    @Override
    public String toString() {
        return "Juego{" +
                "uuid=" + uuid +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", fechaLanzamiento=" + fechaLanzamiento +
                '}';
    }
}
