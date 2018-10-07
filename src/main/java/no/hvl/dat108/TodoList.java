package no.hvl.dat108;

import java.util.ArrayList;
import java.util.List;

public class TodoList{
    private List<TodoItem> items = new ArrayList<>();

    public synchronized void addItem(TodoItem item){
        items.add(item);
    }

    public synchronized void removeItem(String item){
        items.removeIf(s -> s.getName().equals(item));
    }

    public List<TodoItem> getItems(){
        return items;
    }

    public TodoList(){
        
    }
}