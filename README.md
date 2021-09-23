# LABORATORIO 5 - MVC PRIMEFACES INTRODUCTION - 2021-2
## INTEGRANTES  
- Cristian Andres Castellanos Fino
- Diego Alejandro Gonzalez Gualteros  
## PARTE I
### Protocolo Telnet  
  Para este punto hacemos uso del protocolo telnet con el _host_ ```www.escuelaing.edu.co``` _puerto_ ```80``` y el _recurso_ ```/sssss/abc.html```  
  ![img1](Imagenes/PARTE I/img1.jpg)  
  En este caso se retorno el error _301 Moved Permanently_ es decir el archivo fue movido a otra dirección, como este exiten otro tipo de mensajes para dnotar distintos casos. Se dividen en un grupo de 5.  
  1. Respuestas informativas (100–199)
  2. Respuestas satisfactorias (200–299)
  3. Redirecciones (300–399)
  4. Errores de los clientes (400–499)
  5. Errores de los servidores (500–599)  

Ahora realizaremos una conexion telnet con el _host_ ```www.httpbin.org```, _puerto_ ```80``` y el _recurso_ ```/html```.  
![img2](Imagenes/PARTE I/img3.jpg)  
Como resultado se obtuvo la informacion del request, como el mensaje enviado fue _200_ es decir correcto, se nos envio el recurso, el cual se denota en el codigo html.  

De la misma manera como podemos hacer un request con telnet, exite otro metodo que es con el comando ```curl```, este comando nos permite generar un requets a la direccion que le pidamos. Al hacer uso del comando, se ve que la peticion fue aceptada y nos envia el recurso.  
![img3](Imagenes/PARTE I/img3.jpg)  
De la misma manera existen comandos para _curl_ como lo es ```-i```, en este caso se nos mostro ademas del recurso pedido, la informacion del request enviado, con su mensaje de respuesta, la longitud del archivo, entre otros.  
![img4](Imagenes/PARTE I/img5.jpg)  
Si hacemos uso del comando ```-v``` se nos mostrara ademas de la misma informacion que con _-i_, una mayor cantidad de informacion como es la informacion de la peticion realizada.  
![img5](Imagenes/PARTE I/img4.jpg)  
## PARTE II
### Servlet 
  Para este punto del laboratorio se genero un proyecto maven con el arquetipo web estandar de maven. Al compilar y empaquetar el proyecto, observamos que no se encuentra ningun tipo de error.  
  ![img6](https://github.com/DiegoGonzalez2807/lab5-cvds/blob/7db75f31b211017e4d92314665e0e70c52d6a551/Imagenes/PARTE%20II/img6.png)
  
  Modificamos el archivo ```pom.xml```para que tenga las dependencia necesarias para que nuestro servicio web corra, en este caso lo haremos por medio de _Tomcat_ por el puerto _8080_, una vez modificado el archivo pom, corremos le servicio por medio del comando ```mvn tomcat7:run```.  Nuevamente vemos que no se genera ningun tipo de erro.  
  ![img7](https://github.com/DiegoGonzalez2807/lab5-cvds/blob/7db75f31b211017e4d92314665e0e70c52d6a551/Imagenes/PARTE%20II/img7.png)  
  Ahora para ver como funciona nuestro servidor web, abrimos en un navegador el url de nuestro archivo ```localhost:8080/helloServlet``` , en donde esta el puerto por el que nos comunicamos y el urlPatterns de la clase SampleServlet.  
  ![img8](https://github.com/DiegoGonzalez2807/lab5-cvds/blob/7db75f31b211017e4d92314665e0e70c52d6a551/Imagenes/PARTE%20II/img8.png)  
  Vemos como funciona nuestro servidor, ahora por medio de la peticion Get, vamos a pedir a nuestro servidor web un saludo personalizado, dando parametros en la url, ```localhost:8080/helloServlet?name=Diego```.  
  ![img9](https://github.com/DiegoGonzalez2807/lab5-cvds/blob/7db75f31b211017e4d92314665e0e70c52d6a551/Imagenes/PARTE%20II/img9.png)  
  
  Buscamos la dependencia _gson_ y la greagamos a nuestro archivo _pom_.  
  ![img10](https://github.com/DiegoGonzalez2807/lab5-cvds/blob/7db75f31b211017e4d92314665e0e70c52d6a551/Imagenes/PARTE%20II/img10.png)  
  Probamos que haya sido instalado correctamente buscando en la direccion ```https://jsonplaceholder.typicode.com/todos/1``` y probando distintos valores al final del path.  
  ![img11](https://github.com/DiegoGonzalez2807/lab5-cvds/blob/7db75f31b211017e4d92314665e0e70c52d6a551/Imagenes/PARTE%20II/img11.png)  
  ![img12](https://github.com/DiegoGonzalez2807/lab5-cvds/blob/7db75f31b211017e4d92314665e0e70c52d6a551/Imagenes/PARTE%20II/img12.png)  
  ![img13](https://github.com/DiegoGonzalez2807/lab5-cvds/blob/7db75f31b211017e4d92314665e0e70c52d6a551/Imagenes/PARTE%20II/img13.png)  la cual 
  
  Realizamos una aplicacion la cual nos retorne un mensaje de acuerdo al paramtro que se le envie, si el ```id``` es valido o no.  
  ![img16](https://github.com/DiegoGonzalez2807/lab5-cvds/blob/7db75f31b211017e4d92314665e0e70c52d6a551/Imagenes/PARTE%20II/img16.png)  
  En este caso no se envio ningun parametro por lo cual se espera que mande una pagina que nos muestre un error.  
  ![img17](https://github.com/DiegoGonzalez2807/lab5-cvds/blob/7db75f31b211017e4d92314665e0e70c52d6a551/Imagenes/PARTE%20II/img17.png)  
  En este caso se envia un ```id``` que no es valido, puesto que es un _String_, por lo cual se manda mensaje de error.  
  ![img18](https://github.com/DiegoGonzalez2807/lab5-cvds/blob/7db75f31b211017e4d92314665e0e70c52d6a551/Imagenes/PARTE%20II/img18.png)  
  Para este caso se envia un ```id``` que no esta en el rango valido, por lo cual se envia un mensaje de error.  
  ![img19](https://github.com/DiegoGonzalez2807/lab5-cvds/blob/7db75f31b211017e4d92314665e0e70c52d6a551/Imagenes/PARTE%20II/img19.png)  
  En este caso se envio un ```id``` valido, por lo cual se nos muestra una pequeña tabla.  
## PARTE III  
  Por medio de scripts nos es posible generar en la pagina creada un servicio que lea datos que ingrese el usuario, en este caso le pedimos a el susuario el ```id```.  
  ![img20](https://github.com/DiegoGonzalez2807/lab5-cvds/blob/0e1d0e1a355832af6bfc6435a3b165ee79303f0e/Imagenes/PARTE%20III/img20.jpg)  
  Vemos que el usuario ingresa 1, al compararlo con la pagina de ActualServlet con ```id=1``` vemos que es igual a la pagina que fuimos enviados al enviar el id, en la caja de texto.  
  ![img21](https://github.com/DiegoGonzalez2807/lab5-cvds/blob/232851d38953eb19353e013370a2f736a747f730/Imagenes/PARTE%20III/img21.jpg)  
  ![img22](https://github.com/DiegoGonzalez2807/lab5-cvds/blob/232851d38953eb19353e013370a2f736a747f730/Imagenes/PARTE%20III/img22.jpg)  
  
  
  


