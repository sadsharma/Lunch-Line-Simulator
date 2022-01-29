/**
 * @author Sadikshya Sharma
 * SBU ID: 113305452
 * Recitation 3
 * This class is for the middle school lunch line simulator, the main calls
 * the appropriate methods according to the options the user picks
 */
import java.util.*;
public class LunchLineSimulator implements Cloneable{
    private static StudentLine reality1 = new StudentLine();
    private static StudentLine reality2 = new StudentLine();
    /* @currentReality keeps track of what reality the user is currently on */
    private static int currentReality = 1;
    private static boolean gameOver = false;
    private static Scanner userInput = new Scanner(System.in);
    public static void main(String[] args) {
        while(!gameOver)
        {
            printMenu();
            String optionChosen = userInput.nextLine();
            if(optionChosen.equalsIgnoreCase("A"))
            {
                addStudentToLine();
            }
            else if(optionChosen.equalsIgnoreCase("C"))
            {
                cutAFriend();
            }
            else if(optionChosen.equalsIgnoreCase("T"))
            {
                studentsTradePlaces();
            }
            else if(optionChosen.equalsIgnoreCase("B"))
            {
                bullyRemoveStudent();
            }
            else if(optionChosen.equalsIgnoreCase("U"))
            {
                updateStudentBalance();
            }
            else if(optionChosen.equalsIgnoreCase("S"))
            {
                serveAStudent();
            }
            else if(optionChosen.equalsIgnoreCase("P"))
            {
                printCurrentRealityLunchLine();
            }
            else if(optionChosen.equalsIgnoreCase("O"))
            {
                switchToOtherReality();
            }
            else if(optionChosen.equalsIgnoreCase("E"))
            {
                checkIfRealitiesAreEqual();
            }
            else if(optionChosen.equalsIgnoreCase("D"))
            {
                try
                {
                    duplicateRealities();
                }catch (CloneNotSupportedException e)
                {
                    System.out.println("The line could not be duplicated!");
                }
            }
            else if(optionChosen.equalsIgnoreCase("Q"))
            {
                quitMiddleSchool();
            }
            else
            {
                System.out.println("Invalid option selected! Please try " +
                        "again:");
            }
        }
    }
    public static void printMenu()
    {
        System.out.println("                                                ");
        System.out.println("Menu:");
        System.out.println("A) Add a student to the line at the end");
        System.out.println("C) Have a new student cut a friend");
        System.out.println("T) Have two students trade places");
        System.out.println("B) Have the bully remove a student");
        System.out.println("U) Update a student's money amount");
        System.out.println("S) Serve a student");
        System.out.println("P) Print the current reality's lunch line");
        System.out.println("O) Switch to the other reality");
        System.out.println("E) Check if the realities are equal");
        System.out.println("D) Duplicate this reality into the other reality");
        System.out.println("Q) Quit middle school and move on to real life.");
        System.out.println("                                                ");
        System.out.println("Please select an option: ");

    }
    /**
     * adds a new student to the end of the line, it checks to see if the
     * student has actual money and if the student does then the student gets
     * added to the line of the current reality
     */
    public static void addStudentToLine()
    {
        System.out.println("Please enter the students name: ");
        String name = userInput.nextLine();
        System.out.println("Please enter the amount of money the " +
                "student has: ");
        Double money = userInput.nextDouble();
        String temp = userInput.nextLine();
        Student newStudent = new Student(name, money);
        if(currentReality == 1) {
            if(money <= 0)
            {
                System.out.println(name + " does not have enough money to buy" +
                        " lunch! Please send them back after they get at " +
                        "least a penny. The line has not been updated!");
            }
            else {
                try {
                    reality1.addStudent(reality1.numStudents(), newStudent);
                    System.out.println(newStudent.getName() + " has been added to the " +
                            "line!");
                } catch (DeanException e) {
                    System.out.println("You tried adding a student to a " +
                            "full line! Dean Mean now has the student!");
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("That is not a valid index! Try again, the" +
                            " index should be from 1 to 20!");
                }
                catch (InvalidArgumentException e)
                {
                    System.out.println("You can't put someone so behind on " +
                            "line! There would be empty spots for no reason, " +
                            "the line was not updated!");
                }
            }
        }
        else
        {
            if(money <= 0)
            {
                System.out.println(name + " does not have enough money to buy" +
                        " lunch! Please send them back after they get at " +
                        "least a penny. The line has not been updated!");
            }
            else {
                try {
                    reality2.addStudent(reality2.numStudents(), newStudent);
                    System.out.println(newStudent.getName() + " has been added to the " +
                            "line!");
                } catch (DeanException e) {
                    System.out.println("You tried adding a student to a " +
                            "full line! Dean Mean now has the student!");
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("That is not a valid index! Try again, the" +
                            " index should be from 1 to 20!");
                }
                catch (InvalidArgumentException e)
                {
                    System.out.println("You can't put someone so behind on " +
                            "line! There would be empty spots for no reason, " +
                            "the line was not updated!");
                }
            }
        }
    }
    /**
     * lets a student cut and go in front of another student after checking
     * if they have enough money to actually get on line
     */
    public static void cutAFriend()
    {
        System.out.println("Please enter the students name: ");
        String name = userInput.nextLine();
        System.out.println("Please enter the amount of money the " +
                "student has: ");
        Double money = userInput.nextDouble();
        System.out.println("And which index would you like the student to be " +
                "in?");
        int cuttingPosition = userInput.nextInt() - 1;
        String temp = userInput.nextLine();
        Student newStudent = new Student(name, money);
        if(currentReality == 1) {
            if(money <= 0)
            {
                System.out.println(name + " does not have enough money to " +
                        "buy lunch! Please send them back after they get at " +
                        "least a penny. The line has not been updated!");
            }
            else
            {
                try {
                    reality1.addStudent(cuttingPosition, newStudent );
                }
                catch (DeanException e)
                {
                    System.out.println("You tried adding a student to a " +
                            "full line! Dean Mean now has the student!");
                }
                catch (ArrayIndexOutOfBoundsException e)
                {
                    System.out.println("That is not a valid index! Try again, the" +
                            " index should be from 1 to 20!");
                }
                catch (InvalidArgumentException e)
                {
                    System.out.println("You can't put someone so behind on " +
                            "line! There would be empty spots for no reason, " +
                            "the line was not updated!");
                }
            }
        }
        else
        {
            if(money <= 0)
            {
                System.out.println(name + " does not have enough money to " +
                        "buy lunch! Please send them back after they get at " +
                        "least a penny. The line has not been updated!");
            }
            else
            {
                try {
                    reality2.addStudent(cuttingPosition,
                            newStudent );
                }
                catch (DeanException e)
                {
                    System.out.println("You tried adding a student to a " +
                            "full line! Dean Mean now has the student!");
                }
                catch (ArrayIndexOutOfBoundsException e)
                {
                    System.out.println("That is not a valid index! Try again, the" +
                            " index should be from 1 to 20!");
                }
                catch (InvalidArgumentException e)
                {
                    System.out.println("You can't put someone so behind on " +
                            "line! There would be empty spots for no reason, " +
                            "the line was not updated!");
                }
            }
        }
    }
    /** The two students in the given indexes get swapped */
    public static void studentsTradePlaces()
    {
        System.out.println("Enter the index of the first student you want to " +
                "swap: ");
        int index1 = userInput.nextInt() - 1;
        System.out.println("Enter the index of the second student you want to" +
                " swap: ");
        int index2 = userInput.nextInt() - 1;
        String temp = userInput.nextLine();
        if(currentReality == 1)
        {
            try {
                reality1.swapStudents(index1,index2);
                System.out.println(reality1.getStudent(index1).getName() +
                        " has been swapped with " +
                        reality1.getStudent(index2).getName());
            }
            catch (EmptyLineException e)
            {
                System.out.println("One of the indexes does not contain a " +
                        "student!");
            }
        }
        else
        {
                try {
                    reality2.swapStudents(index1,index2);
                    System.out.println(reality2.getStudent(index1).getName() + " " +
                            "has been swapped with " + reality2.getStudent(index2).
                            getName());
                }
                catch (EmptyLineException e)
                {
                    System.out.println("One of the indexes does not contain a "
                            + "student!");
                }
                catch (ArrayIndexOutOfBoundsException e)
                {
                    System.out.println("That is not a valid index! Try again, the" +
                            " index should be from 1 to 20!");
                }
        }
    }
    /** removes a student from a certain index */
    public static void bullyRemoveStudent()
    {
        System.out.println("What is the index of the student you would like " +
                "to bully?");
        int index = userInput.nextInt() - 1;
        String temp = userInput.nextLine();
        if(currentReality == 1)
        {
            try
            {
                System.out.println(reality1.removeStudent(index) + " was " +
                        "had their money taken from them by Punchin' Patrick" +
                        " so he left the line hungry :(");
            }catch (EmptyLineException e)
            {
                System.out.println("There is no student to bully in that " +
                        "spot!");
            }
            catch (ArrayIndexOutOfBoundsException e)
            {
                System.out.println("That is not a valid index! Try again, the" +
                        " index should be from 1 to 20!");
            }
        }
        else {
            try {
                System.out.println(reality2.removeStudent(index) + " was " +
                        "had their money taken from them by Punchin' Patrick" +
                        " so he left the line hungry :(");
            } catch (EmptyLineException e) {
                System.out.println("There is no student to bully in that " +
                        "spot");

            }
            catch (ArrayIndexOutOfBoundsException e)
            {
                System.out.println("That is not a valid index! Try again, the" +
                        " index should be from 1 to 20!");
            }
        }
    }
    /** updates the balance of the student at the given index */
    public static void updateStudentBalance()
    {
        System.out.println("What is the index of the student who's money you " +
                "want to update?");
        int index = userInput.nextInt() - 1;
        System.out.println("What would you like their new balance to be?");
        double newBalance = userInput.nextDouble();
        String temp = userInput.nextLine();
        if(newBalance <= 0)
        {
            System.out.println("You cannot update a students money with a " +
                    "negative number or a 0 so the balance was not updated");
        }
        else if(currentReality == 1)
        {
            try
            {
                reality1.getStudent(index).setMoney(newBalance);
                System.out.println(reality1.getStudent(index).getName() + " now " +
                        "has " + reality1.getStudent(index).getMoney() + " " +
                        "dollars!");
            }
            catch (ArrayIndexOutOfBoundsException e)
            {
                System.out.println("That is not a valid index! Please enter " +
                        "an index of 1 to 20 next time!");
            }
        }
        else
        {
            try
            {
                reality2.getStudent(index).setMoney(newBalance);
                System.out.println(reality2.getStudent(index).getName() + " " +
                        "now has " + reality2.getStudent(index).getMoney() + " " +
                        "dollars!");
            }
            catch (ArrayIndexOutOfBoundsException e)
            {
                System.out.println("That is not a valid index! Please enter " +
                        "an index of 1 to 20 next time!");
            }
        }
    }
    /** serves and removes the student of the first index */
    public static void serveAStudent()
    {
        if(currentReality == 1)
        {
            try
            {
                System.out.println(reality1.removeStudent(0) + " has been " +
                        "served the questionable gray lunch meat, they have " +
                        "unenthusiastically left the line");
            }catch (EmptyLineException e)
            {
                System.out.println("There is no student to serve in that spot" +
                        " :(!");
            }
        }
        else {
            try {
                System.out.println(reality2.removeStudent(0) + " has been " +
                        "served the questionable gray lunch meat, they have " +
                        "unenthusiastically left the line");
            } catch (EmptyLineException e) {
                System.out.println("There is no student to serve in that spot" +
                        " :(!");

            }
        }
    }
    /** prints the lunch line of the reality the user is currently in */
    public static void printCurrentRealityLunchLine()
    {
        if(currentReality == 1)
        {
            int i = 0;
            System.out.println("Current Line in reality one: ");
            while(i < reality1.CAPACITY && !(reality1.getStudent(i) == null))
            {
                System.out.println("name:" + reality1.getStudent(i).getName() +
                        " amount of money: " + reality1.getStudent(i).getMoney());
                i++;
            }
        }
        else
        {
            int i = 0;
            System.out.println("Current Line in reality two: ");
            while(i < reality2.CAPACITY && !(reality2.getStudent(i) == null))
            {
                System.out.println("name:" + reality2.getStudent(i).getName() +
                        " amount of money: " + reality2.getStudent(i).getMoney());
                i++;
            }
        }

    }
    /** switch to the other reality */
    public static void switchToOtherReality()
    {
        if(currentReality == 1)
        {
            System.out.println("You have now switched to reality two!");
            currentReality = 2;
        }
        else {
            System.out.println("You are now in reality one!");
            currentReality = 1;
        }
    }
    /** checks if the two realities are equal by looking at each element and
    every element */
    public static void checkIfRealitiesAreEqual()
    {
        if(reality1.equals(reality2))
        {
            System.out.println("The two realities are equal!");
        }
        else
        {
            System.out.println("The two realities are not equal!");
        }
    }
    /** duplicates one reality onto the other and one doesn't change when the
    other one does it sets the student of one reality, I did this by setting
     the students from the other realities to have the values of the current
     reality and then in case the other realities has more students I made the
     rest of the student objects null
     */
    public static void duplicateRealities() throws CloneNotSupportedException
    {
        if(currentReality == 1)
        {
            int i = 0;
            while(i < reality1.CAPACITY && !(reality1.getStudent(i) == null))
            {
                reality2.setStudent(i, reality1.getStudent(i).clone());
                i++;
            }
            for(int j = i; j < reality2.CAPACITY; j++)
            {
                reality2.setStudent(i, null);
            }
            reality2.setNumStudents(reality1.numStudents());
            System.out.println("Reality one has been duplicated into reality " +
                    "two!");
        }
        else
        {
            int i = 0;
            while(i < reality2.CAPACITY && !(reality2.getStudent(i) == null))
            {
                reality1.setStudent(i, reality2.getStudent(i).clone());
                i++;
            }
            for(int j = i; j < reality2.CAPACITY; j++)
            {
                reality1.setStudent(i, null);
            }
            reality1.setNumStudents(reality2.numStudents());
            System.out.println("Reality two has been duplicated into reality " +
                    "One!");
        }
    }
    /** method to quit the middle school simulator game */
    public static void quitMiddleSchool()
    {
        gameOver = true;
        System.out.println("You've officially quit middle school lunch line! " +
                "Have a good day!");
    }
}
