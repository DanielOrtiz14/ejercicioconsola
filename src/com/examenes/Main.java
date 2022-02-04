package com.examenes;

import java.util.Scanner;
public class Main {

    private Persona persona = new Persona("",0,0,"",0.00,0.0);
    private Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        Main main = new Main();
        main.menu();

    }

    public void menu(){
            System.out.println(" Ingresa lo datos de la persona que desea registrar: ");
            if(ingresarDatos()){
                System.out.println("Datos ingresados correctamente");
                System.out.println( "Por su peso, " + pesoIdeal());
                System.out.println(esMayorEdad());
                System.out.println( "Sus datos son los siguientes: " + persona.ToString());
            }else {
                ingresarDatos();
            }
    }

    public Boolean ingresarDatos() {
        try {
            System.out.println("Ingrese nombre: ");
            String nombre = sc.next();
            System.out.println("Ingrese su edad: ");
            int edad = sc.nextInt();
            System.out.println("Ingrese peso en kilogramos (ejemplo 70.5): ");
            double peso = sc.nextDouble();
            System.out.println("Ingrese estatura: en metros (ejemplo 1.75): ");
            double altura = sc.nextDouble();


            String sexo = " ";
            while(persona.comprobarSexo(sexo.charAt(0)) == false){
                System.out.println("Ingrese su sexo (M o F): ");
                sexo = sc.next();
            }

            persona.setNombre(nombre);
            persona.setEdad(edad);
            persona.setPeso(peso);
            persona.setAltura(altura);
            persona.setSexo(sexo);

            return true;
        }catch(Exception e){
            System.out.println("Hubo una excepción: " + e.toString());
            return false;
        }
    }

    public String pesoIdeal(){
        switch (persona.estaEnPesoIdeal()){
            case -1:
                return "usted está por debajo del peso ideal";

            case 0:
                return "usted está en Su peso ideal";

            case 1:
                return "usted está por encima del peso ideal";

            default:
                return "Hubo un error";
        }
    }

    public String esMayorEdad(){
        if (persona.esMayorDeEdad()){
            return "Usted es mayor de edad";
        }
        return "Usted es menor de edad";
    }

}

