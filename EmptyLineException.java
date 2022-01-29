/**
 * @author Sadikshya Sharma
 * SBU ID: 113305452
 * Recitation 3
 * Incase a student the user tries to remove isnt in the index
 * (the line spot being empty)
 */
public class EmptyLineException extends Exception
{
    public EmptyLineException(String message)
    {
        super(message);
    }
}
