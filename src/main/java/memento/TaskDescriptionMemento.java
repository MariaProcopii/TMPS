package memento;

public class TaskDescriptionMemento implements Memento{
    private final int id;
    private final String content;
    public TaskDescriptionMemento(int id, String description) {
        this.id = id;
        this.content = description;
    }

    public String getContent(){
        return content;
    }

    public int getId(){
        return id;
    }
}
