/**
 * @author Sadikshya Sharma
 * SBU ID: 113305452
 * Recitation 3
 * Incase the user puts in an invalid argument
 * such as string instead of student
 */
public class InvalidArgumentException extends Exception
{
    public InvalidArgumentException(String message)
    {
        super(message);
    }
}
