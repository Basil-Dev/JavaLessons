package patterns;
/*Банкомат*/
/* Данный шаблон предназначен для организации в системе уровней ответственности (или обязанностей) и  позволяет определить должно ли сообщение обрабатываться на том уровне, где оно было получено, или же оно должно передаваться для обработки другому объекту.*/
public class Chain {
    public static void main(String[] args) {
        Logger smsLogger0 = new SMSLogger(Level.ERROR);
        Logger fileLogger0 = new FileLogger(Level.DEBUG);
        Logger emailLogger0 = new EmailLogger(Level.INFO);
        smsLogger0.setNext(fileLogger0);
        fileLogger0.setNext(emailLogger0);
        smsLogger0.writeMessage("All good!",
                Level.INFO);
        smsLogger0.writeMessage("Debug",
                Level.DEBUG);
        smsLogger0.writeMessage("ERROR",
                Level.ERROR);
    }
}
class Level {
    public static final int ERROR = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
}
abstract class Logger {
    public void writeMessage(String message,
                             int level) {
        if (level <= priority) {
            write(message);
        }
        if (next != null) {
            next.writeMessage(message,
                    level);
        }
    }
    abstract void write(String message);
    int priority;
    public Logger(int priority) {
        this.priority = priority;
    }
    Logger next;
    public void setNext(Logger next) {
        this.next = next;
    }
}
//Вагончик
class SMSLogger extends Logger {
    public SMSLogger(int priority) {
        super(priority);
    }
    public void write(String message) {
        System.out.println("SMS: " + message);
    }
}
class FileLogger extends Logger {
    public FileLogger(int priority) {
        super(priority);
    }
    public void write(String message) {
        System.out.println("File write: " + message);
    }
}
class EmailLogger extends Logger {
    public EmailLogger(int priority) {
        super(priority);
    }
    
    public void write(String message) {
        System.out.println("Email: " + message);
    }
}
