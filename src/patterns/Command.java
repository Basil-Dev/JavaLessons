package patterns;
/*Этот паттерн обеспечивает обработку команды в виде объекта, что позволяет сохранять ее, передавать в качестве параметра методам, а также возвращать ее в виде результата, как и любой другой объект. Плюс: Команда позволяет отделить источник события от объекта, который знает, как нужно выполнять запрашиваемую операцию.*/
public class Command
    {
        public static void main(String[] args)
            {
                Comp comp = new Comp();
                User user = new User(new StartCommand(comp),
                                     new StopCommand(comp),
                                     new ResetCommand(comp));
                user.startComputer();
                user.stopComputer();
                user.resetComputer();
            }
    }
interface Command1
    {
        void execute();
    }
//Receiver
class Comp
    {
        void start()
            {
                System.out.println("start");
            }
        void stop()
            {
                System.out.println("stop");
            }
        void reset()
            {
                System.out.println("reset");
            }
    }
//Concrete command
class StartCommand implements Command1
    {
        Comp computer;
        public StartCommand(Comp computer)
            {
                this.computer = computer;
            }
        @Override
        public void execute()
            {
                computer.start();
            }
    }
class StopCommand implements Command1
    {
        Comp computer;
        public StopCommand(Comp computer)
            {
                this.computer = computer;
            }
        @Override
        public void execute()
            {
                computer.stop();
            }
    }
class ResetCommand implements Command1
    {
        Comp computer;
        public ResetCommand(Comp computer)
            {
                this.computer = computer;
            }
        @Override
        public void execute()
            {
                computer.reset();
            }
    }
//Invoker, вызывающий, инициатор
class User  {
        Command1 start;
        Command1 stop;
        Command1 reset;
        public User(Command1 start,
                    Command1 stop,
                    Command1 reset)
            {
                this.start = start;
                this.stop = stop;
                this.reset = reset;
            }
        void startComputer()
            {
                start.execute();
            }
        void stopComputer()
            {
                stop.execute();
            }
        void resetComputer()
            {
                reset.execute();
            }
    }