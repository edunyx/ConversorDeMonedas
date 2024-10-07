package com.conversor;

import java.util.Scanner;

public class Conversor {
    private Scanner scanner;
    private APIService apiService;

    public Conversor() {
        scanner = new Scanner(System.in);
        apiService = new APIService();
    }

    public void iniciarConversor() {
        System.out.println("Bienvenido al conversor de monedas");
        System.out.print("Ingrese la cantidad en USD: ");
        double cantidad = scanner.nextDouble();

        System.out.print("Ingrese la moneda destino (por ejemplo, EUR, GBP): ");
        String monedaDestino = scanner.next().toUpperCase();

        double tasaCambio = apiService.obtenerTasaCambio(monedaDestino);

        if (tasaCambio != 0) {
            double resultado = convertir(cantidad, tasaCambio);
            System.out.printf("%.2f USD son %.2f %s%n", cantidad, resultado, monedaDestino);
        } else {
            System.out.println("Error al obtener la tasa de cambio.");
        }
    }

    public double convertir(double cantidad, double tasaCambio) {
        return cantidad * tasaCambio;
    }
}