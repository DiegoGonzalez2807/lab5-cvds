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
        }
        catch(FileNotFoundException fileNotFoundException){
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            message = Service.getHTMLError(resp.getStatus(), "No existe Item con el identificador dado");

        }
        catch(MalformedURLException malformedURLException){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
        catch(Exception exception){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            message = Service.getHTMLError(resp.getStatus(), "Requerimiento Invalido.");
        }
        finally{

        }
    }
}
