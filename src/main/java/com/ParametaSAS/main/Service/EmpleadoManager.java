package com.ParametaSAS.main.Service;

import com.ParametaSAS.main.model.Empleado;
import com.ParametaSAS.main.repository.EmpleadoRepository;
import net.bytebuddy.asm.Advice;
import org.apache.commons.validator.GenericValidator;
import org.hibernate.validator.internal.constraintvalidators.bv.AssertFalseValidator;
import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import javax.validation.constraints.AssertFalse;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@Service
public class EmpleadoManager {
    @Autowired
    private EmpleadoRepository repository;


    public List<Empleado> getEmpleado(){
        return repository.findAll();
    }
    public String setEmpleado (Empleado empleadoParametros) {
        //Age Validatión
        if (ChronoUnit.YEARS.between(empleadoParametros.getDataBirth(),LocalDate.now())<17){
            return "El usuario debe ser mayor de edad";
        }
        //Validación de la fecha
        dateValidation(empleadoParametros);

        ageYearMonthDay(empleadoParametros);
        timeEnterprise(empleadoParametros);

        repository.save(empleadoParametros);
        return "Usuario creado exitosamente";
    }
    //Metodo para calcular Años mese y edad del empleado Años- Meses - días
    public void ageYearMonthDay(Empleado empleadoParametros) {
        LocalDate now = LocalDate.now();
        Period data = Period.between(empleadoParametros.getDataBirth(),now);
        int anios = data.getYears()-100;
        int month = data.getMonths();
        int days = data.getDays();
        empleadoParametros.setEmployeeAge(anios + " years"+" - " + month +" Months" + " - " + days + " Days" );
    }
        //método para calcular el tiempo de trabajo en la empresa Años y meses
        public void timeEnterprise(Empleado empleadoParametros){
            LocalDate now = LocalDate.now();

            //Duration days = Duration.between(now.atStartOfDay(),empleadoParametros.getStartDateEnterprise().atStartOfDay());
            Period day = Period.between(empleadoParametros.getStartDateEnterprise(),now);
            int anios = day.getYears();
            int month = day.getMonths();
            empleadoParametros.setTimeEnterprise(anios + " Years"+" - " + month +" Months");
    }

    public void dateValidation(Empleado empleadoParametros) {
        int years = empleadoParametros.getDataBirth().getYear();
        int months = empleadoParametros.getDataBirth().getMonthValue();
        int days = empleadoParametros.getDataBirth().getDayOfMonth();
        System.out.println("Anios" + years + " " + "meses "+ months + " " +"dias" +days);
    }

}
