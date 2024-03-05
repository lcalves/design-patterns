package br.com.lcalves.designpatterns.domain.repository;

import br.com.lcalves.designpatterns.domain.model.Adress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdressRepository extends JpaRepository<Adress, String> {


}
