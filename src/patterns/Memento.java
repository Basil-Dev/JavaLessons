package patterns;
/*поведенческий шаблон проектирования, позволяющий зафиксировать и сохранить внутреннее состояние объекта так, чтобы позднее восстановить его в это состояние.*/
public class Memento {
    public static void main(String[] args) {
        Game game = new Game();
        game.set("Level 1", 30_000);
        System.out.println(game);

        File file = new File();
        file.setSave(game.save());

        game.set("Level 2", 80_000);
        System.out.println(game);

        System.out.println("Load saved game...");
        game.load(file.getSave());
        System.out.println(game);
    }
}

class Game {
    private String level;
    private int ms;

    public void set(String level, int ms) {
        this.level = level;
        this.ms = ms;
    }

    public void load(Save save) {
        level = save.getLevel();
        ms = save.getMs();
    }

    public Save save() {
        return new Save(level, ms);
    }

    @Override public String toString() {
        return "Game{" +
               "level='" + level + '\'' +
               ", ms=" + ms +
               '}';
    }
}

//Memento
class Save {
    private final String level;
    private final int ms;

    public Save(String level, int ms) {
        this.level = level;
        this.ms = ms;
    }

    public String getLevel() {
        return level;
    }

    public int getMs() {
        return ms;
    }
}

//Caretaker
class File {
    Save save;

    public Save getSave() {
        return save;
    }

    public void setSave(Save save) {
        this.save = save;
    }
}