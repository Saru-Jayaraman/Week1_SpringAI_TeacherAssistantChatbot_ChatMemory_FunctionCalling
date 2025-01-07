package se.lexicon.week1_springai_teacherassistantchatbot_chatmemory_functioncalling.service;

public interface AssistantService {
    String chat(String input);

    String chatMemory(String chatId, String input);

    String chatMemoryWithFunctionCalling(String chatId, String input);

    void clearChat(String chatId);
}