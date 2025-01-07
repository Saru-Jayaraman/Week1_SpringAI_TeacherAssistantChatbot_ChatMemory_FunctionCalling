## AI DRIVEN TEACHER ASSISTANT CHATBOT APPLICATION with ChatMemory & FunctionCalling:
* Generative AI Powered Application is the integration of Spring AI Framework with Spring Boot Application.
* Integration of Artificial Intelligence and Machine Learning into Spring-based application.
* Spring AI project aims to simplify the development of applications that incorporate artificial intelligence functionality without unnecessary complexity.
* This technique was introduced to help the developers in connecting with LLM for decision-making, solving task etc.

## OBJECTIVE:
Task is to create AI TEACHER ASSISTANT CHATBOT App with ChatMemory & FunctionCalling features having Java Spring boot application as backend which connects with the AI technologies.

## FEATURES:
### **`Chat Memory:`** In-Memory
### **`LLM Parameters:`** LLM Parameters like Model, Temperature, MaxToken, Frequency Penalty are configured using OpenAiChatOptions class
### **`Function names:`** Function names are configured using OpenAiChatOptions class
### **`System instructions:`** System instructions are added as Text blocks in Java.
    - Template contain sentences like "if query involves actions or operations, then call the appropriate functions". Otherwise, don't call the functions.
### **`Prompt class in Spring AI framework:`** Provides method like call(prompt) & stream(prompt) to interact with Open AI.
    - Prompts with user message, system message and chat option helps to interact with OpenAI API model.

### STEPS implemented in Spring Boot Application:
1. Spring boot application is created with Gradle as build automation tool. Necessary dependencies are added.
2. Properties file:
    * Spring application connects with Open AI's predefined model gpt-4o.
    * Added the necessary configuration properties to connect with Open AI model (max-attempts and API key).
      API Key is added as environmental variable.
    * Configured the necessary LLM Fine Tune options using OpenAiChatOptions class to customize the model response.
3. Controller and Service classes are created. Taken necessary actions to implement the API endpoints inside these classes.
4. Adding System Information, Sending request to and Receiving response from Open AI chat model is configured inside the Spring boot application using the following techniques:
    - **`Prompt:`** Predefined Class present inside org.springframework.ai.chat framework. It is used to create customized prompts having User query, System instruction and LLM parameters(OpenAiChatOptions).
    - **`OpenAiChatModel:`** It has pre-built methods to connect with Open AI Model.
    - Interact with AI functionalities using APIs like AI Model API and Advisors API.
5. Following API endpoints are used in this application:
   1. API endpoint to interact with Open AI model having Customized prompt:
      - **`Input:`** QUERY is passed as **`String`** through GET method.
      - Response is delivered to the user only when the request sent to predefined model is processed completely.
      - User and Application has to wait until the response is generated fully.
   2. API endpoint to interact with Open AI model having Chat Memory(In-Memory) and Customized prompt:
      - **`Input:`** CHAT ID and QUERY are passed as **`String`** through GET method.
      - **`ChatId:`** Helps to filter all the Chats by ChatId in ChatMemory. 
      - **`Steps:`**
        1. Retrieve Previous Context from ChatMemory by ChatID.
        2. Query and System instruction are added inside Prompt(Template).
        3. Then combine Prompt with Previous Context.
        4. LLM configurations includes necessary Parameters. Then attach Prompt with LLM configurations.
        5. Call Open AI Model with customized Prompt.
        6. Store User input and AI response in ChatMemory.
        7. Return the result.
      - **`Examples:`**
        * Query1: http://localhost:8080/api/teacherAssistant/chat/memory?chatId=1&question=Hi!!My%20name%20is%20Elsa
          - Stores the query in ChatMemory by ChatId
        * Query2: http://localhost:8080/api/teacherAssistant/chat/memory?chatId=1&question=Hi!!What%20is%20my%20name
          - Open AI response: "Your name is Elsa!!"
   3. API endpoint to interact with Open AI model having Chat Memory(In-Memory), Customized prompt and if necessary, Open AI calls appropriate User defined Functions:
      - **`Input:`** CHAT ID and QUERY are passed as **`String`** through GET method.
      - **`ChatId:`** Helps to filter all the Chats by ChatId in ChatMemory.
      - **`Steps:`**
         1. Retrieve Previous Context from ChatMemory by ChatID.
         2. Template includes sentences related to Function Calling. "If query involves actions or operations, then call the appropriate functions. Otherwise, don't call the functions.".
         3. Query and System instruction are added inside Prompt(Template).
         4. Then combine Prompt with Previous Context.
         5. LLM configurations includes necessary Parameters and also Function names(.withFunctions(Set.of("operation1", "operation2"))). Then attach Prompt with LLM configurations.
         6. Call Open AI Model with customized Prompt.
         7. Store User input and AI response in ChatMemory.
         8. Return the result.
      - **`Examples:`**
        * Query1: http://localhost:8080/api/teacherAssistant/chat/memory?chatId=1&question=Hi!!My%20name%20is%20Elsa
          - Stores the query in ChatMemory by ChatId
        * Query2: http://localhost:8080/api/teacherAssistant/chat/memory?chatId=1&question=Please%20execute%20operation2%20with%20my%20name
          - Open AI response in developer's console: "The operation operation2 has been executed!" "Elsa"
   4. API endpoint to clear the chat by ChatID:
      - Just clears all the previous context related to ChatID inside InMemory buffer.