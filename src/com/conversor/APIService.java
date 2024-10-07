package com.conversor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class APIService {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/25fdddd0ef8bc9bc3d0a6121/latest/USD";

    public double obtenerTasaCambio(String monedaDestino) {
        try {
            URL url = new URL(API_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JSONObject jsonResponse = new JSONObject(response.toString());
            return jsonResponse.getJSONObject("conversion_rates").getDouble(monedaDestino);
        } catch (Exception e) {
            e.printStackTrace();
            return 0; // Manejo de errores
        }

    }
}