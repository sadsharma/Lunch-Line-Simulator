import java.lang.Cloneable;
/**
 * @author Sadikshya Sharma
 * SBU ID: 113305452
 * Recitation 3
 * Student class for the middle school lunch line simulator
 */
public class Student implements Cloneable
{
    private String name;
    private Double money;

    /**
     * This is a default constructor in case student is called with no
     * variables
     */
    public Student()
    {
        this.name = "no name";
        this.money = 0.0;
    }
    /**
     * This is a constructor used to create a Student object
     * @param name refers to the Student name
     * @param money is the amount of money the Student has
     */
    public Student(String name, Double money)
    {
        this.name = name;
        this.money = money;
    }
    /**
     * This method sets the name of a student, changes the name of a student
     * if needed
     * @param name is the new name the student will go by
     */
    public void setName(String name){ this.name = name;}

    /**
     * Updates the amount of money a student has
     * @param money
     */
    public void setMoney(double money){this.money = money;}

    /**
     * lets any other class access the private variable name
     * @return name of the student
     */
    public String getName()
    {
        return name;
    }

    /**
     * returns how much money a student has
     * @return money
     */
    public Double getMoney()
    {
        return money;
    }

    /**
     * checks to see if the current student is equal to the object given in
     * the parameter
     * @param obj
     * @return a true or false value after comparing the two objects
     */
    public boolean equals(Object obj)
    {
        if(obj instanceof Student)
        {
            Student object = (Student)obj;
            return object.getName().equals(this.getName()) && object.getMoney()
                    == this.getMoney();
        }
        return false;
    }

    /**
     * clones the student object
     * @return returns the cloned object
     * @throws CloneNotSupportedException when the cloneable interface has
     * not been implemented
     */
    public Student clone() throws CloneNotSupportedException {
        {
            return (Student) super.clone();
        }
    }

    /**
     * @return Prints out the array with names and money
     */
    public String toString()
    {
        return "name: " + this.getName() + " money: " + this.getMoney();
    }
}
