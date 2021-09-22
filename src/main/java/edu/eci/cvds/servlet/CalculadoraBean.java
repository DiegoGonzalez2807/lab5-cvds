package edu.eci.cvds.servlet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Dictionary;
import java.util.HashMap;

import javax.annotation.ManagedBean;
import javax.faces.bean.ApplicationScoped;

@ManagedBean(value = "CalculadoraBean")
@ApplicationScoped


public class CalculadoraBean {
    ArrayList<Double> listaNumeros;
    double media;
    ArrayList<Double> moda;
    double desviacionEstandar;
    double varianza;
    int longitud;

    public CalculadoraBean(){
        listaNumeros = new ArrayList<Double>();
        media = 0;
        moda = new ArrayList<Double>();
        desviacionEstandar = 0;
        varianza = 0;
        longitud = 0;
    }

    public ArrayList<Double> getDatos(){return this.listaNumeros;}
    public void setListaNumeros(ArrayList<Double> datos){this.listaNumeros = datos;}

    public double getMedia(){return this.media;}
    public void setMedia(double media){this.media = media;}

    public ArrayList<Double> getModa(){return this.moda;}
    public void setModa(ArrayList<Double> moda){this.moda = moda;}

    public double getDesviacionEstandar(){return this.desviacionEstandar;}
    public void setDesviacionEstandar(double desviacionEstandar){this.desviacionEstandar = desviacionEstandar;}

    public double getVarianza(){return this.varianza;}
    public void setVarianza(double varianza){this.varianza = varianza;}

    public int getLongitud(){return this.longitud;}
    public void setLongitud(int longitud){this.longitud = longitud;}

    /**
     * Funcion encargada de el calculo del promedio de los datos ingresados
     * @param datos --> Lista de numeros a la cual se le sacara la media
     * @return Double--> Media de los numero ingresados
     */
    public double calcularPromedio(ArrayList<Double> datos){
        double suma = 0;
        double media = 0;
        for(double dato:datos){
            suma += dato;
        }
        media = (datos.size() > 0) ? suma /datos.size() :0 ;
        setMedia(media);
        return media;
    }

    /**
     * Funcion encargada de el calculo de la desviacion estandar de los datos ingresado s
     * @param datos --> Lista de numeros a los cuales se le saca la desviacion estandar
     * @return Double --> Desviacion estandar de los datos
     */
    public double CalcularDesviacionEstandar(ArrayList<Double> datos){
        double numerador = 0;
        double media = calcularPromedio(datos);
        double desviacionEstandar = 0;
        if(datos.size() >0 ){
            for(double dato:datos){
                numerador += Math.pow(Math.abs(dato-media), 2);
            }
            desviacionEstandar = Math.sqrt(numerador/datos.size());
        }
        setDesviacionEstandar(desviacionEstandar);
        return desviacionEstandar;
    }

    /**
     * Funcion encargada de el calculo de la varianza de los datos ingresado s
     * @param datos --> Lista de numeros a los cuales se le saca la varianza
     * @return Double --> Varianza de los datos
     */
    public double CalcularVarianza(ArrayList<Double> datos){
        Double desviacionEstandar = CalcularDesviacionEstandar(datos);
        Double varianza = Math.pow(desviacionEstandar,2);
        setVarianza(varianza);
        return varianza;
    }

    public ArrayList<Double> calcularModa(ArrayList<Double> datos){
        HashMap<Double,Integer> listaModa = new HashMap<Double,Integer>();
        ArrayList<Double> moda = new ArrayList<Double>();
        for(Double data: datos){
            if(!listaModa.containsKey(data)){
                listaModa.put(data, Collections.frequency(datos, data));
            }
        }
        //Parte para sacar mayor valor
        Collection<Integer> values = listaModa.values();
        //Sacar maximo de la coleccion
        Integer maxValue = Collections.max(values);
        for(double key: listaModa.keySet()){
            if(maxValue.equals(listaModa.get(key))){
                moda.add(key);
            }
        }
        return moda;
    }

    public void restart(){
        listaNumeros.clear();
    }
}
