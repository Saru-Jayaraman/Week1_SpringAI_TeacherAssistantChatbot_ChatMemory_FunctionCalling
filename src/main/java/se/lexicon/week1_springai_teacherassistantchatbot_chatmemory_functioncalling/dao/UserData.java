package se.lexicon.week1_springai_teacherassistantchatbot_chatmemory_functioncalling.dao;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserData {
    private final List<String> storage = new ArrayList<>();

    public String register(String name) {
        storage.add(name);
        return "Name '" + name + "' has been registered successfully!!!";
    }

    public List<String> getRegisteredNames() {
        return new ArrayList<>(storage);
    }
}