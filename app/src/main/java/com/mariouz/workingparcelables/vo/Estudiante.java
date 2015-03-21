package com.mariouz.workingparcelables.vo;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Mario on 02/03/2015.
 */
public class Estudiante  implements Parcelable{
    public Estudiante(Parcel source) {
        readFromParcel(source);
    }
    public static final Creator<Estudiante> CREATOR = new Creator<Estudiante>() {



    @Override
        public Estudiante createFromParcel(Parcel source) {
            return new Estudiante(source);
        }

        @Override
        public Estudiante[] newArray(int size) {
            return new Estudiante[size];
        }
    };
    private String nombre;
    public static final java.lang.String CARRERA_KEY ="CARRERA_KEY " ;
    public static final java.lang.String ESCUELA_KEY ="ESCUELA_KEY " ;
    public static final java.lang.String EDAD_KEY = "EDAD_KEY ";
    public static final String NOMBRE_KEY = "NOMBRE_KEY";

    private  int edad;
    private String escuela;
    private String carrera;

    private void readFromParcel(Parcel source) {
        Bundle bundle = source.readBundle();
        setNombre(bundle.getString(NOMBRE_KEY));
        setEdad(bundle.getInt(EDAD_KEY));
        setEscuela(bundle.getString(ESCUELA_KEY));
        setCarrera(bundle.getString(CARRERA_KEY));

    }

    @Override
    public int describeContents() {
        return PARCELABLE_WRITE_RETURN_VALUE;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        Bundle bundle  = new Bundle();
        bundle.putString(CARRERA_KEY, this.getCarrera());
        bundle.putInt(EDAD_KEY, this.getEdad());
        bundle.putString(ESCUELA_KEY, this.getEscuela());
        bundle.putString(NOMBRE_KEY, this.getNombre());
        dest.writeBundle(bundle);

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
}

