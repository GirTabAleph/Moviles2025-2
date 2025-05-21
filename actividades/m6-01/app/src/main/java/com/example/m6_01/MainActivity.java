package com.example.m6_01;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private VistaAeropuerto vistaAeropuerto;
    private TextView pasosTxv, colisionesTxv;
    private int pasos = 0;
    private int choques = 0;
    private java.util.Stack<List<Avion>> historial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vistaAeropuerto = findViewById(R.id.vistaAeropuerto);
        pasosTxv = findViewById(R.id.txtPasos);
        colisionesTxv = findViewById(R.id.txtColisiones);

        findViewById(R.id.btnContinuar).setOnClickListener(v -> nextStep());
        findViewById(R.id.btnPrevio).setOnClickListener(v -> previousStep());
    }

    private void nextStep() {

        if (hasCollidedAirplanes() || hasBorderAirplanes()) {

            removeCollidedAndBorderAirplanes();

        } else {

            List<Avion> newAirplanes = calculateNewPositions();
            detectCollisions(newAirplanes);
            markBorderAirplanes(newAirplanes);
            if (historial == null) historial = new java.util.Stack<>();
            historial.push(new ArrayList<>(vistaAeropuerto.getAirplanes()));
            vistaAeropuerto.setAirplanes(newAirplanes);
            pasos++;
            updateCounters();
            vistaAeropuerto.invalidate();
        }
    }

    private boolean hasCollidedAirplanes() {
        for (Avion avion : vistaAeropuerto.getAirplanes()) {
            if (avion.isCollided()) return true;
        }
        return false;
    }

    private boolean hasBorderAirplanes() {
        for (Avion avion : vistaAeropuerto.getAirplanes()) {
            if (avion.isCollided() && avion.isAtBorder(
                    vistaAeropuerto.getColumnas(), vistaAeropuerto.getFilas())) return true;
        }
        return false;
    }

    private void removeCollidedAndBorderAirplanes() {
        List<Avion> airplanes = vistaAeropuerto.getAirplanes();
        airplanes.removeIf(Avion::isCollided);
        vistaAeropuerto.setAirplanes(airplanes);
        vistaAeropuerto.invalidate();
    }

    private void markBorderAirplanes(List<Avion> airplanes) {
        for (Avion airplane : airplanes) {
            if (!airplane.isCollided() && airplane.isAtBorder(
                    vistaAeropuerto.getColumnas(), vistaAeropuerto.getFilas())) {
                airplane.setCollided(true);
                airplane.setAtDestination(true);
            }
        }
    }

    private List<Avion> calculateNewPositions() {
        List<Avion> copy = new ArrayList<>();
        int columns = vistaAeropuerto.getColumnas();
        int rows = vistaAeropuerto.getFilas();

        for (Avion original : vistaAeropuerto.getAirplanes()) {

            Avion copia = new Avion(original.getPosX(), original.getPosY(), original.getDirection());
            copia.mover(columns, rows);
            copy.add(copia);

        }

        return copy;

    }

    private List<Avion> detectCollisions(List<Avion> aviones) {

        Map<String, List<Avion>> positions = new HashMap<>();
        List<Avion> collided = new ArrayList<>();

        for (Avion avion : aviones) {

            String key = avion.getPosX() + "-" + avion.getPosY();
            positions.computeIfAbsent(key, k -> new ArrayList<>()).add(avion);

        }

        for (List<Avion> group : positions.values()) {

            if (group.size() > 1) {

                choques += group.size();
                group.forEach(airplane -> {
                    airplane.setCollided(true);
                    collided.add(airplane);

                });

            }

        }
        return collided;
    }

    private void updateCounters() {
        pasosTxv.setText(getString(R.string.pasos, pasos));
        colisionesTxv.setText(getString(R.string.colisiones, choques));
    }

    private void previousStep() {

        if (historial != null && !historial.isEmpty()) {

            vistaAeropuerto.setAirplanes(historial.pop());
            pasos--;
            updateCounters();
            vistaAeropuerto.invalidate();

        }

    }

}