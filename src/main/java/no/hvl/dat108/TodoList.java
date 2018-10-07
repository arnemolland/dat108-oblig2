package no.hvl.dat108;

import java.util.ArrayList;
import java.util.List;

public class TodoList{
    private List<TodoItem> items = new ArrayList<>();

    public void addItem(TodoItem item){
        items.add(item);
    }

    public List<TodoItem> getItems(){
        return items;
    }

    public TodoList(){
        
    }
}