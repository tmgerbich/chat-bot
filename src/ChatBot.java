import java.util.Scanner;
import java.util.ArrayList;


public class ChatBot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        hello();
        String name = name(scanner);
        System.out.println("Nice to meet you " + name);
        int age = age(scanner);
        System.out.println("You are " + age + " years old.");
        counter(scanner);
        int guesses = question(scanner);
        if(guesses == 1) {System.out.println("You got it in " + guesses + " guess");}
        if(guesses >1) {System.out.println("You got it in " + guesses + " guesses");}

        scanner.close();
    }

    public static void hello() {
        System.out.println("Hi, I'm a ChatBot!");
    }

    public static String name(Scanner scanner) {
        System.out.println("What's your name?");
        String nameOne = scanner.nextLine();
        System.out.println("Sorry, can you repeat that?");
        String nameTwo = scanner.nextLine();
        return nameTwo;
    }

    public static int age(Scanner scanner) {
        boolean olderThan35 = false;
        boolean olderThan60 = false;
        boolean youngerThan20 = false;

        System.out.println("Let me try to guess your age... but first, a few questions...");
        System.out.println("Did you watch 'Friends' during its original run or in reruns?");
        while (true) {
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("original")) {
                olderThan35 = true;
                break;
            } else if (response.equalsIgnoreCase("reruns")) {
                olderThan35 = false;
                break;
            } else {
                System.out.println("Original or reruns? You've definitely seen at least an episode");
            }
        }

        System.out.println("Have you ever used a rotary phone?");
        while (true) {
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("yes")) {
                olderThan60 = true;
                break;
            } else if (response.equalsIgnoreCase("no")) {
                olderThan60 = false;
                break;
            } else {
                System.out.println("They're the ones where you spin the wheel to dial, did you ever use a rotary phone?");
            }
        }

        System.out.println("Do you identify as a rizzler?");
        while (true) {
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("yes")) {
                youngerThan20 = true;
                break;
            } else if (response.equalsIgnoreCase("no")) {
                youngerThan20 = false;
                break;
            } else {
                System.out.println("If you don't understand the question, the answer is probably no... are you a rizzler?");
            }
        }

        ArrayList<Integer> ages = new ArrayList<>();
        ArrayList<Integer> newAges = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            ages.add(i);
        }

        int guessedAge = 25;
        int actualAge = 25;
        if (olderThan60) {
            guessedAge = 65;
        } else if (olderThan35) {
            guessedAge = 40;
        } else if (youngerThan20) {
            guessedAge = 15;
        }

        while (true) {
            System.out.println("Based on your answers, I'm guessing you are " + guessedAge + " years old, is that right?");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("yes")) {
                actualAge = guessedAge;
                return actualAge;
            } else if (response.equalsIgnoreCase("no")) {
                System.out.println("Hmmm... okay, older or younger?");
                while (true) {
                    String response2 = scanner.nextLine();
                    if (response2.equalsIgnoreCase("older")) {
                        for (int i = ages.indexOf(guessedAge); i < ages.size(); i++)
                            newAges.add(ages.get(i));
                        ages = (ArrayList<Integer>) newAges.clone();
                        newAges.clear();
                        guessedAge = ages.get(ages.size()/2);
                        break;
                    } else if (response2.equalsIgnoreCase("younger")) {
                        for (int i = 0; i < ages.size()/2; i++)
                            newAges.add(ages.get(i));
                        ages = (ArrayList<Integer>) newAges.clone();
                        newAges.clear();
                        guessedAge = ages.get(ages.size()/2);
                        break;
                    }
                }
            }
        }
    }

    public static void counter(Scanner scanner) {
        System.out.println("I can count, how high should I go?");
        while (true) {
            String input = scanner.nextLine();
            try {
                int number = Integer.parseInt(input);
                ArrayList<Integer> numbers = new ArrayList<>();
                for (int i = 0; i < number; i++) {
                    numbers.add(i+1);
                }
                for (int i = 0; i < numbers.size(); i++) {
                    System.out.print(numbers.get(i) + " ");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("I can only count integers, try again");
            }
        }
    }

    public static int question(Scanner scanner) {
        System.out.println("Ready for a quiz?");
        System.out.println("What gets returned by this method?");
        System.out.println("public static void hello(){}");
        System.out.println("A- Nothing B- A string C- An Integer D- Another Method");
        int guesses = 1;
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("a")) {
                return guesses;
            } else {
                guesses++;
                System.out.println("Nope, try again!");
                System.out.println("What gets returned by this method?");
                System.out.println("public static void hello(){}");
                System.out.println("A- Nothing B- A string C- An Integer D- Another Method");
            }
        }
    }
}
