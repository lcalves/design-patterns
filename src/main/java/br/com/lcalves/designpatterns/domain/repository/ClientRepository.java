package br.com.lcalves.designpatterns.domain.repository;

import br.com.lcalves.designpatterns.domain.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    boolean existsByRegistration(String registration);
    Optional<Client> findTopByOrderByIdDesc();

    Optional<Client> findByRegistration(String registration);
    void deleteByRegistration(String registration);
}
