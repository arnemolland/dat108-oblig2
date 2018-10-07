package no.hvl.dat108;

import no.hvl.dat108.TodoItem;
import java.util.ArrayList;
import java.util.List;

public class TodoList{
    private List<TodoItem> items = new ArrayList<>();

    public void addItem(TodoItem item){
        items.add(item);
    }

    public void removeItem(String item){
        items.removeIf(s -> s.getName().equals(item));
    }

    public List<TodoItem> getItems(){
        return items;
    }

    public TodoList(){
        
    }
}