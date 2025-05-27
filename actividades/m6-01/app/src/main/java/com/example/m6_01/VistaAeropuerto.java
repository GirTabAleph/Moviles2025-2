package com.example.m6_01;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class VistaAeropuerto extends View {

    private int cellSize = 100;
    private List<Avion> aviones = new ArrayList<>();
    private int columnas = 10;
    private int filas = 10;

    public VistaAeropuerto(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeAirplanes();
    }

    private void initializeAirplanes() {
        aviones.clear();
        int airplaneCount = 20; // Más aviones
        java.util.Random random = new java.util.Random();
        // Usar una lista de posiciones posibles para evitar superposición y distribuir mejor
        List<int[]> posiciones = new ArrayList<>();
        for (int x = 0; x < columnas; x++) {
            for (int y = 0; y < filas; y++) {
                posiciones.add(new int[]{x, y});
            }
        }
        // Mezclar las posiciones
        java.util.Collections.shuffle(posiciones, random);
        for (int i = 0; i < airplaneCount && i < posiciones.size(); i++) {

            int[] pos = posiciones.get(i);
            Avion.Direction direction = Avion.Direction.values()[random.nextInt
                    (Avion.Direction.values().length)];
            aviones.add(new Avion(pos[0], pos[1], direction));

        }

    }

    public List<Avion> getAviones() {
        return aviones;
    }

    public void setAviones(List<Avion> airplanes) {

        if (airplanes == null) {

            this.aviones = new ArrayList<>();

        } else {

            this.aviones = airplanes;

        }

    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public void setColumnas(int columnas) {

        this.columnas = columnas;

    }

    public int getColumnas() {

        return columnas;

    }
    public int getFilas() {

        return filas;

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        cellSize = Math.min(w / columnas, h / filas);
        columnas = w / cellSize;
        filas = h / cellSize;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawGrid(canvas);
        drawAirplanes(canvas);
    }

    private void drawGrid(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.GRAY);

        for (int i = 0; i <= columnas; i++) {

            int x = i * cellSize;
            canvas.drawLine(x, 0, x, filas * cellSize, paint);

        }

        for (int i = 0; i <= filas; i++) {

            int y = i * cellSize;
            canvas.drawLine(0, y, columnas * cellSize, y, paint);

        }

    }

    private void drawAirplanes(Canvas canvas) {

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(4);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(cellSize * 0.7f);

        for (Avion avion : aviones) {

            int x = avion.getPosX() * cellSize + cellSize / 2;
            int y = avion.getPosY() * cellSize + cellSize / 2 + (int) (cellSize * 0.25f);

            if (avion.isAtDestination()) {
                paint.setColor(Color.GREEN);

            } else if (avion.isCollided()) {

                paint.setColor(Color.RED);

            } else {

                paint.setColor(Color.BLUE);

            }

            float angle = 0;
            switch (avion.getDirection()) {

                case NORTH: angle = 0; break;
                case EAST: angle = 90; break;
                case SOUTH: angle = 180; break;
                case WEST: angle = 270; break;

            }

            canvas.save();
            canvas.rotate(angle, x, y - (int) (cellSize * 0.25f));

            if (avion.isCollided() || avion.isAtDestination()) {

                // Dibuja un círculo relleno
                float radio = cellSize * 0.3f;
                canvas.drawCircle(x, y - (int) (cellSize * 0.25f), radio, paint);

            } else {

                // Dibuja un vil asterisco.
                canvas.drawText("*", x, y, paint);

            }

            canvas.restore();

        }

    }

}