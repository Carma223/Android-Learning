package com.example.appdefinicionessoftware;

public class DefinicionesModel {

    private int idDefinicion;

    private String nombreDefinicion;

    private String siglasDefinicion;

    private String descripcionDefinicion;

    public DefinicionesModel(int idDefinicion, String nombreDefinicion, String siglasDefinicion, String descripcionDefinicion) {
        this.idDefinicion = idDefinicion;
        this.nombreDefinicion = nombreDefinicion;
        this.siglasDefinicion = siglasDefinicion;
        this.descripcionDefinicion = descripcionDefinicion;
    }

    public DefinicionesModel(int idDefinicion, String nombreDefinicion, String siglasDefinicion) {
        this.idDefinicion = idDefinicion;
        this.nombreDefinicion = nombreDefinicion;
        this.siglasDefinicion = siglasDefinicion;
    }

    @Override
    public String toString() {
        return "DefinicionesModel{" +
                "idDefinicion=" + idDefinicion +
                ", nombreDefinicion='" + nombreDefinicion + '\'' +
                ", siglasDefinicion='" + siglasDefinicion + '\'' +
                ", descripcionDefinicion='" + descripcionDefinicion + '\'' +
                '}';
    }

    public int getIdDefinicion() {
        return idDefinicion;
    }

    public void setIdDefinicion(int idDefinicion) {
        this.idDefinicion = idDefinicion;
    }

    public String getNombreDefinicion() {
        return nombreDefinicion;
    }

    public void setNombreDefinicion(String nombreDefinicion) {
        this.nombreDefinicion = nombreDefinicion;
    }

    public String getSiglasDefinicion() {
        return siglasDefinicion;
    }

    public void setSiglasDefinicion(String siglasDefinicion) {
        this.siglasDefinicion = siglasDefinicion;
    }

    public String getDescripcionDefinicion() {
        return descripcionDefinicion;
    }

    public void setDescripcionDefinicion(String descripcionDefinicion) {
        this.descripcionDefinicion = descripcionDefinicion;
    }
}
