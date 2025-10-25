package Ejercicio8;

public class Capsula {
    String nombre;
    int intensidad;

    public Capsula (String nombre, int intensidad) {
        this.nombre = nombre;
        this.intensidad = intensidad;
    }

    public Capsula() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIntensidad() {
        return intensidad;
    }

    public void setIntensidad(int intensidad) {
        this.intensidad = intensidad;
    }

    @Override
    public String toString() {
        return "Capsula de:" + nombre + '\'' +
                "Intensidad: " + intensidad;
    }
}
