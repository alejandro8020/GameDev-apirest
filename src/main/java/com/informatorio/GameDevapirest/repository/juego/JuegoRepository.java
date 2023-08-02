package com.informatorio.GameDevapirest.repository.juego;
import java.util.Optional;
import java.util.UUID;

import com.informatorio.GameDevapirest.domain.Juego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JuegoRepository extends JpaRepository<Juego, UUID> {
    Optional<Juego> findBytitleIgnoreCase(String title);
}
