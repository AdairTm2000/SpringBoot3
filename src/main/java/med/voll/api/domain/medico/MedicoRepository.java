package med.voll.api.domain.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findByActivoTrue(Pageable paginacion);

    // primer cambio en intellij

    @Query("""
            select m from Medico m where m.activo= true AND m.especialidad=:especialidad and m.id not in(select c.medico.id from Consulta c where c.fecha=:fecha) order by rand() limit 1
            """)
    Medico seleccionarMedicoConEspecilidadEnFecha(Especialidad especialidad, LocalDateTime fecha);

    @Query("""
            select p.activo from Medico p where p.id=:id_medico
            """)
    Boolean findActivoById(Long id_medico);
}
