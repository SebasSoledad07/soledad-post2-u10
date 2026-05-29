package com.universidad.pruebas.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping(path = "/tareas", produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> tareasPage() {
        String html = "<!doctype html>\n" +
                "<html><head><meta charset=\"utf-8\"><title>Tareas</title></head>\n" +
                "<body>\n" +
                "<h1>Lista de Tareas</h1>\n" +
                "<button id=\"btn-nueva\">Nueva tarea</button>\n" +
                "<ul id=\"lista\">\n" +
                "  <li class=\"tarea-item\">Ejemplo 1</li>\n" +
                "</ul>\n" +
                "</body></html>";
        return ResponseEntity.ok(html);
    }
}

