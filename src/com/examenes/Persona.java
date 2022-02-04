package com.examenes;

import java.security.SecureRandom;
import java.util.HashMap;

public class Persona {
    private String nombre;
    private Integer edad;
    private String nss;
    private String sexo;
    private double peso;
    private double altura;

    public Persona(String nombre, Integer edad, Integer nss, String sexo, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.nss = this.generaNSS(8);
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public Boolean esMayorDeEdad(){
        return edad>=18;
    }

    public double calcularIMC(){
        return peso/(altura*altura);
    }

    public Integer estaEnPesoIdeal() {
        if (sexo.equals("H")) {
            if (calcularIMC() >= 20 && calcularIMC() <= 25) {
                return 0;
            } else if (calcularIMC() > 25) {
                return 1;
            }
        } else if (sexo.equals("M")) {
            if (calcularIMC() >= 19 && calcularIMC() <= 24) {
                return 0;
            } else if (calcularIMC() > 24) {
                return 1;
            }
        }
        return -1;
    }

    public Boolean comprobarSexo(char sexo){
        if (sexo=='H' || sexo=='M'){
            return true;
        }
        return false;
    }

    public String ToString(){
        HashMap persona = new HashMap<String, Object>();
        persona.put("Nombre", nombre);
        persona.put("Edad", edad.toString());
        persona.put("NSS", nss);
        persona.put("Sexo", sexo);
        persona.put("Peso", peso);
        persona.put("Altura", altura);
        return persona.toString();
    }

    public String generaNSS(int len){
        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder( len );
        for(int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }
}

