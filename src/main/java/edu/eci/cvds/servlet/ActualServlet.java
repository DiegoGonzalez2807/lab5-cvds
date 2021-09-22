package edu.eci.cvds.servlet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.util.ArrayList;

import edu.eci.cvds.servlet.model.Todo;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.NotFoundException;

//URL del servidor 
@WebServlet(urlPatterns = {"/ActualServlet"})

public class ActualServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Writer responseWriter = resp.getWriter();
        String message = "";
        try{
            //Se pide el id del ToDo, con esto se pide el ToDo con ese valor
            int toDoId = Integer.parseInt(req.getParameter("id"));   
            Todo newTodo = Service.getTodo(toDoId);
            //Si el item existe, se da una respuesta de OK
            resp.setStatus(HttpServletResponse.SC_OK);
            //Se crea una lista donde se almacena los ToDo encontrados y se
            //retornan como una tabla HTML 
            ArrayList<Todo> todoArray = new ArrayList<>();
            todoArray.add(newTodo);
            message = Service.todosToHTMLTable(todoArray);
            System.out.print(message);
        }
        //En caso de que el parametro del identificador no tenga nada en el o no se encuentre
        catch(FileNotFoundException fileNotFoundException){
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            message = Service.getHTMLError(resp.getStatus(), "No existe Item con el identificador dado");
        }
        //En caso que no se pase parametro opcional o no sea numero entero
        catch(NumberFormatException numberFormatException){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            message = Service.getHTMLError(resp.getStatus(), "Requerimiento Invalido.");
        //En caso que haya malformaciones en la URL
        }
        catch(MalformedURLException malformedURLException){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
        //En cualquier otro caso de excepcion
        catch(Exception exception){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            message = Service.getHTMLError(resp.getStatus(), "Requerimiento Invalido.");
        }
        finally{
            responseWriter.write(message);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Writer responseWriter = resp.getWriter();
        String message = "";
        try{
            //Se pide el id del ToDo, con esto se pide el ToDo con ese valor
            int toDoId = Integer.parseInt(req.getParameter("id"));   
            Todo newTodo = Service.getTodo(toDoId);
            //Si el item existe, se da una respuesta de OK
            resp.setStatus(HttpServletResponse.SC_OK);
            //Se crea una lista donde se almacena los ToDo encontrados y se
            //retornan como una tabla HTML 
            ArrayList<Todo> todoArray = new ArrayList<>();
            todoArray.add(newTodo);
            message = Service.todosToHTMLTable(todoArray);
            System.out.print(message);
        }
        //En caso de que el parametro del identificador no tenga nada en el o no se encuentre
        catch(FileNotFoundException fileNotFoundException){
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            message = Service.getHTMLError(resp.getStatus(), "No existe Item con el identificador dado");
        }
        //En caso que no se pase parametro opcional o no sea numero entero
        catch(NumberFormatException numberFormatException){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            message = Service.getHTMLError(resp.getStatus(), "Requerimiento Invalido.");
        //En caso que haya malformaciones en la URL
        }
        catch(MalformedURLException malformedURLException){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
        //En cualquier otro caso de excepcion
        catch(Exception exception){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            message = Service.getHTMLError(resp.getStatus(), "Requerimiento Invalido.");
        }
        finally{
            responseWriter.write(message);
        }
    }
}
