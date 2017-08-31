package patterns;
/*Шаблон Посредник (еще называют Медиатор) предназначен для упрощения взаимодействия объектов системы путем создания специального объекта, который управляет распределением сообщений между остальными объектами.*/
import java.util.ArrayList;
import java.util.List;

/*Chat*/
public class Mediator {
    public static void main(String[] args) {
        TextChat textChat = new TextChat();
        User1 admin = new Admin(textChat);
        User1 user1 = new SimpleUser(textChat);
        User1 user2 = new SimpleUser(textChat);

        textChat.setAdmin(admin);
        textChat.addUser(user1);
        textChat.addUser(user2);

        user1.sendMessage("Hi, I`m user #1");
        admin.sendMessage("Admin is HERE!");
    }
}

abstract class User1 {
    Chat chat;
    public User1(Chat chat) {
        this.chat = chat;
    }
    public void sendMessage(String message) {
        chat.sendMessage(message, this);
    }

    abstract void getMessage(String message);
}

class Admin extends User1 {
    public Admin(Chat chat) {
        super(chat);
    }

//    public Admin(Chat chat) {
//        this.chat = chat;
//    }


    @Override public void getMessage(String message) {
        System.out.println("Admin getting message...: " + message);
    }
}

class SimpleUser extends User1 {
    public SimpleUser(Chat chat) {
        super(chat);
    }

//    public SimpleUser(Chat chat) {
//        this.chat = chat;
//    }


    @Override public void getMessage(String message) {
        System.out.println("User getting message...: " + message);
    }
}

interface Chat {
    void sendMessage(String message, User1 user);
}

class TextChat implements Chat {
    User1 admin;
    List<User1> users = new ArrayList<>();

    public void setAdmin(User1 admin) {
        this.admin = admin;
    }

    public void addUser(User1 u) {
        users.add(u);
    }

    @Override public void sendMessage(String message, User1 user) {
        for (User1 u : users) {
            u.getMessage(message);
        }
        admin.getMessage(message);
    }
}
