package edu.eci.cvds.servlet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;


@ManagedBean(name = "CalculadoraBean")
@SessionScoped


public class CalculadoraBean {
    ArrayList<Double> listaNumeros;
    private double media;
    //ArrayList<Double> moda;
    private double desviacionEstandar;
    private double varianza;
    private int longitud;

    public CalculadoraBean(){
        listaNumeros = new ArrayList<Double>();
        media = 0;
        //moda = new ArrayList<Double>();
        desviacionEstandar = 0;
        varianza = 0;
        longitud = 0;
    }

    public void calcular(String lista){
        try{
            conversionEntrada(lista);
            calcularPromedio(this.listaNumeros);
            calcularModa(this.listaNumeros);
            CalcularDesviacionEstandar(this.listaNumeros);
            CalcularVarianza(this.listaNumeros);
        }
        catch(Exception exception){
            conversionEntrada(lista);
            calcularPromedio(this.listaNumeros);
            calcularModa(this.listaNumeros);
            CalcularDesviacionEstandar(this.listaNumeros);
            CalcularVarianza(this.listaNumeros);
        }
    }

    public void conversionEntrada(String lista){
        String[] listaTemporal = lista.split(";");
        for(String value:listaTemporal){
            listaNumeros.add(Double.parseDouble(value));
        }
    }

    public ArrayList<Double> getDatos(){return this.listaNumeros;}
    public void setListaNumeros(ArrayList<Double> datos){this.listaNumeros = datos;}

    public double getMedia(){return this.media;}
    public void setMedia(double media){this.media = media;}

    //public ArrayList<Double> getModa(){return this.moda;}
    //public void setModa(ArrayList<Double> moda){this.moda = moda;}

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
    public void calcularPromedio(ArrayList<Double> datos){
        double suma = 0;
        double media = 0;
        for(double dato:datos){
            suma += dato;
        }
        media = (datos.size() > 0) ? suma /datos.size() :0 ;
        setMedia(media);
        //return media;
    }

    /**
     * Funcion encargada de el calculo de la desviacion estandar de los datos ingresado s
     * @param datos --> Lista de numeros a los cuales se le saca la desviacion estandar
     * @return Double --> Desviacion estandar de los datos
     */
    public void CalcularDesviacionEstandar(ArrayList<Double> datos){
        double numerador = 0;
        //double media = calcularPromedio(datos);
        double desviacionEstandar = 0;
        if(datos.size() >0 ){
            for(double dato:datos){
                numerador += Math.pow(Math.abs(dato-media), 2);
            }
            desviacionEstandar = Math.sqrt(numerador/datos.size());
        }
        setDesviacionEstandar(desviacionEstandar);
        //return desviacionEstandar;
    }

    /**
     * Funcion encargada de el calculo de la varianza de los datos ingresado s
     * @param datos --> Lista de numeros a los cuales se le saca la varianza
     * @return Double --> Varianza de los datos
     */
    public void CalcularVarianza(ArrayList<Double> datos){
        //Double desviacionEstandar = CalcularDesviacionEstandar(datos);
        Double varianza = Math.pow(desviacionEstandar,2);
        setVarianza(varianza);
        //return varianza;
    }

    public void calcularModa(ArrayList<Double> datos){
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
        System.out.print("obj");
        //return moda;
    }

    public void restart(){
        this.listaNumeros = new ArrayList<Double>();
    }
}
