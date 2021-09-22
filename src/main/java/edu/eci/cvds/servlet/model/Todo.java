package edu.eci.cvds.servlet.model;

public class Todo {
    
    private int userId;
    private int id;
    private String title;
    private boolean completed;
    /**
     * Constructor vacio clase Todo
     */
    public Todo(){}

    /**
     * Metodo usado para retornar el userId del To Do
     * @return userId
     */
    public int getUserId(){
        return this.userId;
    }

    /**
     * Metodo usado para retornar el id del To Do
     * @return Id
     */
    public int getId(){
        return this.id;
    }

    /**
     * Metodo usado para retonar el titulo del To Do
     * @return Title
     */
    public String getTitle(){
        return this.title;
    }

    /**
     * Metodo usado para retornar si esta completo el To Do
     * @return completed
     */
    public boolean getCompleted(){
        return this.completed;
    }

    /**
     * Metodo usado para cambiar valor de UserId
     * @param newUserId
     */
    public void setUserId(int newUserId){
        this.userId = newUserId;
    }

    /**
     * Metodo usado para cambiar valor de Id
     * @param newId
     */
    public void setId(int newId){
        this.id = newId;
    }

    /**
     * Metodo usado para cambiar valor de title
     * @param newTitle
     */
    public void setTitle(String newTitle){
        this.title = newTitle;
    }

    /**
     * Metodo usado para cambiar valor de Completed
     * @param newCompleted
     */
    public void setCompleted(boolean newCompleted){
        this.completed = newCompleted;
    }

}
