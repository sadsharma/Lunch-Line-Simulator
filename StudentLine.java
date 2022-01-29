/**
 * @author Sadikshya Sharma
 * SBU ID: 113305452
 * Recitation 3
 * This class is for the middle school lunch line
 */
import java.util.*;
public class StudentLine implements Cloneable{
    private Student[] students; //the array that represents a student line
    private int studentCount; // number of students currently on line
    final int CAPACITY = 20; // max number of students that can be on the line

    /**
     * StudentLine default constructor where students is initialized to the
     * capacity of the line and student count is initialized to 0
     */
    public StudentLine()
    {
        this.students = new Student[CAPACITY];
        this.studentCount = 0;
    }

    /**
     * allows the lunch line simulator to access the number of students in a
     * line
     * @return number of students
     */
    public int numStudents()
    {
        return this.studentCount;
    }

    /**
     * It allows for the number of students to be changed, I implemented this
     * to make duplicating the array easier.
     * @param studentCount the num of students changes to the studentCount value
     */
    public void setNumStudents(int studentCount)
    {
        this.studentCount = studentCount;
    }

    /**
     * allows access to a student from a certain index in the student line
     * @param index is the index of the student we are trying to get
     * @return the student at the given index
     * @throws ArrayIndexOutOfBoundsException when the index is not 0 to 19
     */
    public Student getStudent(int index) throws ArrayIndexOutOfBoundsException
    {
            return students[index];

    }

    /**
     * Allows me to set a student at a certain index to a different
     * given student
     * @param index the index of the student who is being replaced
     * @param student the student object who is replacing the student thats
     *                already at the index
     * @return the new student at the index
     */
    public Student setStudent(int index, Student student)
    {
        students[index] = student;
        return students[index];
    }

    /**
     * removes the student from the given index then shifts the array to the
     * left, the last student in the array then changes to null
     * @param index is the index of which the student is being removed
     * @return the student that was removed
     * @throws ArrayIndexOutOfBoundsException when the index given is not
     * between 0 and 19 this exception will be thrown
     * @throws EmptyLineException when there is no student to remove in a
     * certain index
     */
    public Student removeStudent(int index) throws
            ArrayIndexOutOfBoundsException, EmptyLineException
    {
        if(students[index] == null)
        {
            throw new EmptyLineException("The spot in line does not have a " +
                    "student.");
        }
        Student removedStudent = students[index];
        for(int i = index; i < students.length - 1; i++)
        {
            students[i] = students[i+1];
        }
        students[studentCount - 1] = null;
        studentCount -= 1;
        return removedStudent;
    }

    /**
     * adds a student to the given index when the student is trying to cut a
     * line but when the index given is higher than number of students in
     * line + 1 the student gets added to the end of the line.
     * @param index the index where the student should be added
     * @param student the student who will be added to the index spot
     * @return the added student
     * @throws ArrayIndexOutOfBoundsException when the index is not within 0
     * to 19
     * @throws DeanException when a student is being added to an already full
     * line
     * @throws InvalidArgumentException when the index is too high so there
     * is a hole created in the line
     */
    public Student addStudent(int index, Student student) throws
            ArrayIndexOutOfBoundsException,
            DeanException, InvalidArgumentException
    {

        if(studentCount >= CAPACITY)
        {
            throw new DeanException("No room left on line!");
        }
        else if (index < 0 || index > 20)
        {
            throw new ArrayIndexOutOfBoundsException("Not a valid line spot!");
        }
        else if(index > studentCount + 1)
        {
            throw new InvalidArgumentException("The index is too high, that " +
                    "would leave empty spots on the line!");
        }
        else
        {
            for(int i = students.length - 1; i > index; i--)
            {
                students[i] = students[i-1];
            }
            students[index] = student;
            studentCount ++;
            return students[index];
        }
    }

    /**
     * swaps students that are in index1 and index2
     * @param index1 the first student being swapped is in that index
     * @param index2 the second student being swapped is in that index
     * @throws ArrayIndexOutOfBoundsException is thrown when one of the
     * indexes are not 0 to 19
     * @throws EmptyLineException when one of the indexes being swapped has
     * no student in it
     */
    public void swapStudents(int index1, int index2) throws
            ArrayIndexOutOfBoundsException, EmptyLineException
    {
        Student tempStudent;
        if(students[index1] == null || students[index2] == null)
        {
            throw new EmptyLineException("Not able to switch " +
                    "places between the two students because one of the " +
                    "lineSpots did not contain a student.");
        }
        else if(index1 > 19 || index1 < 0 || index2 > 19 || index2 < 0)
        {
            throw new ArrayIndexOutOfBoundsException("Invalid line spots, you" +
                    " cannot have a line spot of a negative number or greater" +
                    " than 20!");
        }
        else
        {
            tempStudent = students[index1];
            students[index1] = students[index2];
            students[index2] = tempStudent;
            System.out.println(students[index1].getName() + " and " +
                    students[index2].getName() + " are swapped!");
        }
    }

    /**
     * Clones the entire student line object
     * @return a cloned Student Line
     * @throws CloneNotSupportedException when the cloneable interface is not
     * implemented
     */
    public StudentLine clone() throws CloneNotSupportedException
    {
        StudentLine newCopy = (StudentLine) super.clone();
        return newCopy;
    }

    /**
     * checks if a student is equal to object o
     * @param o is the object that student is being compared with
     * @return true or false based on whether its equal or not
     */
    public boolean equals(Object o)
    {
        int i = 0;
        if(o instanceof StudentLine)
        {
            while(((StudentLine) o).getStudent(i) != null || this.getStudent(i) != null)
            {
                StudentLine object = (StudentLine)o;
                if(!(this.getStudent(i).equals(object.getStudent(i))))
                {
                    return false;
                }
                i++;
            }
        }
        else if( ((StudentLine)o).numStudents() != this.numStudents())
        {
            return false;
        }
        return true;
    }

    /**
     * a toString method to print out the array
     * @return the array printed out
     */
    public String toString()
    {
        return Arrays.toString(students);
    }

}
