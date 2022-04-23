package todo;

public class Todo {

    private int id;
    private String titulo;
    private boolean completado;

    public Todo(int id, String titulo, boolean completado) {
        this.id = id;
        this.titulo = titulo;
        this.completado = completado;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isCompletado() {
        return completado;
    }

}
