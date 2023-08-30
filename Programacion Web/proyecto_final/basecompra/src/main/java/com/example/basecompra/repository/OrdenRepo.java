package com.example.basecompra.repository;

import com.example.basecompra.models.Orden;
import com.example.basecompra.models.enumerate.OrdenStatus;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface OrdenRepo extends JpaRepository<Orden, Long> {
    public List<Orden> findAllByStatus(OrdenStatus status);

    public List<Orden> findAllByStatus(OrdenStatus status, Pageable pageable);

    public Optional<Orden> findByIdAndClientUsername(Long id, String clientUsername);

    public List<Orden> findAllByClientUsername(String clientUsername, Pageable pageable);

    public List<Orden> findAllByClientUsernameAndStatus(String clientUsername, OrdenStatus status, Pageable pageable);

    public List<Orden> findAllByClientUsernameStartsWith(String clientUsername, Pageable pageable);

    public List<Orden> findAllByClientUsernameStartsWithAndStatus(String clientUsername, OrdenStatus status, Pageable pageable);

    public Optional<Orden> findByIdAndStatus(Long id, OrdenStatus status);

    public Integer countAllByCreateDateBetween(Date createDateStart, Date createDateEnd);

    public Integer countAllByAcceptedDateBetween(Date acceptedDateStart, Date acceptedDateEnd);

    public Integer countAllByUpdateDateBetweenAndStatus(Date updateDateStart, Date updateDateEnd, OrdenStatus status);
}
