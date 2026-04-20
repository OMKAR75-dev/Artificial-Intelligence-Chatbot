import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import javax.swing.*;

public class ChatbotGUI extends JFrame implements ActionListener {

    JTextArea chatArea;
    JTextField userInput;
    JButton sendButton;

    HashMap<String, String> knowledgeBase;

    public ChatbotGUI() {
        setTitle("AI Chatbot");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Chat Area
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(chatArea);

        // Input Field
        userInput = new JTextField();
        userInput.setFont(new Font("Arial", Font.PLAIN, 14));

        // Button
        sendButton = new JButton("Send");
        sendButton.addActionListener(this);

        // Layout
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(userInput, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);

        add(bottomPanel, BorderLayout.SOUTH);

        // Initialize Knowledge Base
        knowledgeBase = new HashMap<>();
        knowledgeBase.put("hello", "Hi there!");
        knowledgeBase.put("hi", "Hello!");
        knowledgeBase.put("how are you", "I am fine, thank you!");
        knowledgeBase.put("your name", "I am a Java Chatbot.");
        knowledgeBase.put("what is java", "Java is a programming language.");
        knowledgeBase.put("bye", "Goodbye! Have a nice day.");

        chatArea.append("Bot: Hello! Ask me something 😊\n");

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String input = userInput.getText().toLowerCase().trim();

        if (input.isEmpty()) return;

        chatArea.append("You: " + input + "\n");

        String response = getResponse(input);

        chatArea.append("Bot: " + response + "\n");

        userInput.setText("");
    }

    private String getResponse(String input) {

        for (String key : knowledgeBase.keySet()) {
            if (input.contains(key)) {
                return knowledgeBase.get(key);
            }
        }

        return "Sorry, I don't understand.";
    }

    public static void main(String[] args) {
        new ChatbotGUI();
    }
}