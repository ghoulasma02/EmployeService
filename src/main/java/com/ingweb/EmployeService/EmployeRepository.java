package com.ingweb.EmployeService;

import com.ingweb.EmployeService.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//couche DAO
@Repository
public interface EmployeRepository extends JpaRepository<Employe,Long> {

    Employe findByNom(String nom);

}
