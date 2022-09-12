package com.ParametaSAS.main.repository;

import com.ParametaSAS.main.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado,String> {

}
