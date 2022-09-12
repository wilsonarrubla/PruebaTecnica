package com.ParametaSAS.main.Controller;

import com.ParametaSAS.main.Service.EmpleadoManager;
import com.ParametaSAS.main.model.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
@RestController
public class EmpleadoController {
    @Autowired
    private EmpleadoManager empleadoManager;
    @GetMapping("/empleados")
    public ResponseEntity<List<Empleado>> getEmpleado(){
        return new ResponseEntity<>(empleadoManager.getEmpleado(),HttpStatus.ACCEPTED);
    }

    @PostMapping("/empleados")
    public ResponseEntity<String> postEmpleado(@RequestBody @Valid  Empleado empleadoParametros){
        try {
            String mensaje = empleadoManager.setEmpleado(empleadoParametros);
            return new ResponseEntity<>(mensaje, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
