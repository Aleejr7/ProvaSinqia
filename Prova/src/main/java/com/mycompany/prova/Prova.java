
package com.mycompany.prova;

import java.util.Scanner;

public class Prova {

    public static void main(String[] args) {
        Prova obj = new Prova();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite a quantidade de temperaturas a serem transformadas: ");
        int quantidade = scanner.nextInt();
        
        double[] vetTemperatura = new double[quantidade]; 
        for(int i = 0; i < vetTemperatura.length; i++){
            System.out.println("Digite a temperatura");
            vetTemperatura[i] = scanner.nextDouble();
        }
        
        double mediaIniciais = obj.mediaTempIniciais(vetTemperatura);
        
        boolean verificador = true;
        String tempOrigem = "";
        String tempTransformada = "";
        
        do{
            System.out.println("Digite a unidade da temperatura de origem:");
            tempOrigem = scanner.next();
            System.out.println("Digite a unidade da temperatura que deseja transforma-la:");
            tempTransformada = scanner.next();

            verificador = true;
            if("celsius".equals(tempOrigem) && "fahrenheit".equals(tempTransformada)){
                for(int i = 0; i < vetTemperatura.length; i++){
                    double tempAntiga = vetTemperatura[i];
                    vetTemperatura[i] = obj.celsiusFarenheit(vetTemperatura[i]);
                    System.out.print("Temperatura de origem " + tempOrigem + ": " + tempAntiga + "°C");
                    System.out.println(" | Temperatura transformada " + tempTransformada + ": " + vetTemperatura[i] + "°F");
                }
            }else if("celsius".equals(tempOrigem) && "kelvin".equals(tempTransformada)){
                for(int i = 0; i < vetTemperatura.length; i++){
                    double tempAntiga = vetTemperatura[i];
                    vetTemperatura[i] = obj.celsiusKelvin(vetTemperatura[i]);
                    System.out.print("Temperatura de origem " + tempOrigem + ": " + tempAntiga + "°C");
                    System.out.println(" | Temperatura transformada " + tempTransformada + ": " + vetTemperatura[i] + "°K");
                }
            }else if("fahrenheit".equals(tempOrigem) && "celsius".equals(tempTransformada)){
                for(int i = 0; i < vetTemperatura.length; i++){
                    double tempAntiga = vetTemperatura[i];
                    vetTemperatura[i] = obj.fahrenheitCelsius(vetTemperatura[i]);
                    System.out.print("Temperatura de origem " + tempOrigem + ": " + tempAntiga + "°F");
                    System.out.println(" | Temperatura transformada " + tempTransformada + ": " + vetTemperatura[i] + "°C");
                }
            }else if("fahrenheit".equals(tempOrigem) && "kelvin".equals(tempTransformada)){
                for(int i = 0; i < vetTemperatura.length; i++){
                    double tempAntiga = vetTemperatura[i];
                    vetTemperatura[i] = obj.fahrenheitKelvin(vetTemperatura[i]);
                    System.out.print("Temperatura de origem " + tempOrigem + ": " + tempAntiga + "°F");
                    System.out.println(" | Temperatura transformada " + tempTransformada + ": " + vetTemperatura[i] + "°K");
                }
            }else if("kelvin".equals(tempOrigem) && "celsius".equals(tempTransformada)){
                for(int i = 0; i < vetTemperatura.length; i++){
                    double tempAntiga = vetTemperatura[i];
                    vetTemperatura[i] = obj.kelvinCelsius(vetTemperatura[i]);
                    System.out.print("Temperatura de origem " + tempOrigem + ": " + tempAntiga + "°K");
                    System.out.println(" | Temperatura transformada " + tempTransformada + ": " + vetTemperatura[i] + "°C");
                }
            }else if("kelvin".equals(tempOrigem) && "fahrenheit".equals(tempTransformada)){
                for(int i = 0; i < vetTemperatura.length; i++){
                    double tempAntiga = vetTemperatura[i];
                    vetTemperatura[i] = obj.kelvinFahrenheit(vetTemperatura[i]);
                    System.out.print("Temperatura de origem " + tempOrigem + ": " + tempAntiga + "K");
                    System.out.println(" | Temperatura transformada " + tempTransformada + ": " + vetTemperatura[i] + "°F");
                }
            }else{
                System.out.println("Unidades de temperaturas inválidas!");
                verificador = false;
            }
        }while(verificador == false);
        
        double mediaTransformadas = obj.mediaTempTransformadas(vetTemperatura);
        if(verificador == true){
            System.out.println(" - Média das temperaturas inicias " + "(" + tempOrigem + "): " + mediaIniciais);
            System.out.println(" - Média das temperaturas transformadas " + "(" + tempTransformada +"): " + mediaTransformadas);
        }
    }
    
    public double celsiusFarenheit(double celsius){
        double fahrenheit = (celsius * 1.8) + 32; 
        return fahrenheit;
    }
    public double celsiusKelvin(double celsius){
        double kelvin = celsius + 273.15;
        return kelvin;
    }
    public double fahrenheitCelsius(double fahrenheit){
        double celsius = (fahrenheit - 32) * 5/9;
        return celsius;
    }
    public double fahrenheitKelvin(double fahrenheit){
        double kelvin = (fahrenheit - 32) * 5/9 + 273.15;
        return kelvin;
    }
    public double kelvinCelsius(double kelvin){
        double celsius = kelvin - 273.15;
        return celsius;
    }
    public double kelvinFahrenheit(double kelvin){
        double fahrenheit = (kelvin - 273.15) * 1.8 + 32;
        return fahrenheit;
    }
    
    public double mediaTempIniciais(double[] vetTemperatura){
        double media, soma = 0;
        for(int i = 0; i < vetTemperatura.length; i++){
            soma += vetTemperatura[i];
        }
        media = soma/vetTemperatura.length;
        return media;
    }
    public double mediaTempTransformadas(double[] vetTemperatura){
        double media, soma = 0;
        for(int i = 0; i < vetTemperatura.length; i++){
            soma += vetTemperatura[i];
        }
        media = soma/vetTemperatura.length;
        return media;
    }
}
