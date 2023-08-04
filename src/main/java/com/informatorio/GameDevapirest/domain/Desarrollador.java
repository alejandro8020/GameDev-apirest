package com.informatorio.GameDevapirest.domain;
import com.informatorio.GameDevapirest.enumeration.desarrollador.DesarrolladorEnum;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Desarrollador {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID",strategy="org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 36,columnDefinition = "varchar(36)",updatable = false,nullable = false)
    private UUID uuid;

    @Column(length = 50,columnDefinition = "varchar(50)",updatable = true,nullable = false)
    private String name;

    @Column(length = 50,columnDefinition = "varchar(50)",updatable = true,nullable = false)
    private String mail;

    @Enumerated(EnumType.STRING)
    private DesarrolladorEnum rol;

    @ManyToOne
    private Juego juego;

    @Builder.Default
    @OneToMany(mappedBy = "desarrollador")
    private List<Tarea> tarea = new ArrayList<>();

    @Override
    public String toString() {
        return "Desarrollador{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", rol=" + rol +
                ", juego=" + juego +
                '}';
    }
}
