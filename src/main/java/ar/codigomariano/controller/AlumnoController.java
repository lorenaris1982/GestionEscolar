package ar.codigomariano.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

import ar.codigomariano.ejemplo1.domain.Alumno;
import ar.codigomariano.service.AlumnoService;

import org.springframework.ui.Model;

@Controller
public class AlumnoController {

    private final AlumnoService alumnoService;

    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @GetMapping("/alumno/modificar")
    public String mostrarFormularioModificar(HttpSession session, Model model) {

        Alumno alumno = (Alumno) session.getAttribute("alumno");

        model.addAttribute("alumno", alumno);

        return "modificar-alumno";
    }

    @PostMapping("/alumno/modificar")
    public String modificarDatos(
            @RequestParam("mail") String mail,
            @RequestParam("telefono") String telefono,
            HttpSession session) {

        Alumno alumno = (Alumno) session.getAttribute("alumno");

        Alumno actualizado = alumnoService.actualizarDatosContacto(
                alumno.getId(),
                mail,
                telefono
        );

        session.setAttribute("alumno", actualizado);

        return "redirect:/alumno/portal";
    }
    
    @GetMapping("/alumno/portal")
    public String mostrarPortal(HttpSession session, Model model) {

        Alumno alumno = (Alumno) session.getAttribute("alumno");

        model.addAttribute("alumno", alumno);

        return "portal-alumno";
    }
    
    
}