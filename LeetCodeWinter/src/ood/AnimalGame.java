package ood;

import java.util.Scanner;

class Animal extends YesNo {
    public String name;
    public Question parent;
    public Animal(String name) {
        super("Is it " + name);
        this.name = name;
    }

    @Override
    public YesNo yn(boolean b) {
        if (b) {
            System.out.println("I win!");
            return AnimalGame.AGAIN;
        }
        System.out.println("I lose.");
        System.out.println("What was your animal? I was thinking of...");
        Animal na = new Animal(scan.nextLine().trim());
        System.out.println("What is a question that distinguish " + na.name + " from " + name + " ?");
        Question nq = new Question(scan.nextLine());
        System.out.println("How would you answer that question for " + na.name + " ? ");
        boolean y = saidYes();
        if (y) {
            nq.yes = na;
            nq.no = this;
        } else {
            nq.yes = this;
            nq.no = na;
        }
        if (parent.yes == this) {
            parent.yes = nq;
        } else {
            parent.no = nq;
        }
        this.parent = nq;
        na.parent = nq;
        System.out.println("I think I have got it.");
        return AnimalGame.AGAIN;
    }
}

class Question extends YesNo {

    public YesNo yes;
    public YesNo no;

    public Question(String question) {
        super(question);
    }

    @Override
    public YesNo yn(boolean b) {
        return b ? yes : no;
    }
}

class PlayAgain extends YesNo {

    public PlayAgain() {
        super("Would you like to play again?");
    }

    @Override
    public YesNo yn(boolean b) {
        return b ? AnimalGame.ROOT : null;
    }
}

abstract class YesNo {
    public String question;
    public static Scanner scan = new Scanner(System.in);

    public YesNo(String question) {
        this.question = question;
    }

    public YesNo ask() {
        System.out.println(question + " (Y or N) ");
        boolean b = saidYes();
        return yn(b);
    }

    public abstract YesNo yn(boolean b);

    public static boolean saidYes() {
        String line = scan.nextLine().trim();
        while (!line.startsWith("Y") && !line.startsWith("N")) {
            System.out.println("Please enter Y or N.");
            line = scan.nextLine().trim();
        }
        return line.startsWith("Y");
    }

}

public class AnimalGame {

    static Animal MOUSE = new Animal("a mouse");
    static Animal ELEPHANT = new Animal("an elephant");
    static Question ROOT = new Question("Is it bigger than a breadbox?");
    static PlayAgain AGAIN = new PlayAgain();
    static {
        ROOT.yes = ELEPHANT;
        ROOT.no = MOUSE;
        MOUSE.parent = ROOT;
        ELEPHANT.parent = ROOT;
    }

    private void playGame(){
        YesNo res = ROOT.ask();
        while (res != null) {
            res = res.ask();
        }
        System.out.println("Thanks for playing");
    }

    public static void main(String[] args) {
        AnimalGame animal = new AnimalGame();
        animal.playGame();
    }
}