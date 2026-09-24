package ar.codigomariano.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.codigomariano.ejemplo1.domain.Alumno;
import ar.codigomariano.service.AlumnoService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    private final AlumnoService alumnoService;

    public LoginController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @GetMapping("/login")
    public String mostrarLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String procesarLogin(
            @RequestParam("dni") String dni,
            @RequestParam("contrasena") String contrasena,
            Model model,
            HttpSession session) {

        Alumno alumno = alumnoService.buscarPorDniYContrasena(dni, contrasena);

        if (alumno != null) {
        	session.setAttribute("alumno", alumno);
            model.addAttribute("alumno", alumno);
            return "portal-alumno";
        }

        model.addAttribute("error", "DNI o contraseña incorrectos");
        return "login";
    }
}