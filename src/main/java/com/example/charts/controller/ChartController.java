package com.example.charts.controller;

import com.example.charts.model.Venta;
import com.example.charts.model.VentaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ChartController {

    private final VentaRepository ventaRepository;

    public ChartController(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    @GetMapping("/grafico")
    public String mostrarGrafico(Model model) {
        List<Venta> ventas = ventaRepository.findAll();

        List<String> etiquetas = new ArrayList<>();
        List<Double> montos = new ArrayList<>();

        for (Venta venta : ventas) {
            etiquetas.add("Venta " + venta.getId());
            montos.add(venta.getMonto());
        }

        model.addAttribute("etiquetas", etiquetas);
        model.addAttribute("montos", montos);

        return "chart";
    }
    @GetMapping("/grafico-data")
    @ResponseBody
    public Map<String, Object> obtenerDatosGrafico() {
        List<Venta> ventas = ventaRepository.findAll();

        List<String> etiquetas = new ArrayList<>();
        List<Double> montos = new ArrayList<>();

        for (Venta venta : ventas) {
            etiquetas.add("Venta " + venta.getId());
            montos.add(venta.getMonto());
        }

        Map<String, Object> datosGrafico = new HashMap<>();
        datosGrafico.put("etiquetas", etiquetas);
        datosGrafico.put("montos", montos);

        return datosGrafico;
    }

}
