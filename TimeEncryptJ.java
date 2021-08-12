import java.time.*;
import java.util.Scanner;
/**
 * This class encrypting text using non fixed offset to encrypt messages.
 * Using ASCII table to dechipher every character in the massage.
 * The encryption depeneds on the time of the action, using it as start time.
 * @author Jony Klein
 * @version 11.08.2021
 */
public class TimeEncryptJ
{
    Scanner scan = new Scanner(System.in);
    private long et = System.currentTimeMillis(); //encryption time.
    private int et1 = (int)(et % 255), te = 4, ev = et1+ 2; //+2 to avoid ceasar breaking.
    //et1 is the offset, evaluated from et. te is the time encryption value, ev is encryption value.
    private String _msg = "", encryptionTime = String.valueOf(et), encrypted = "";
    
    /**
     * Constructor, builds an object.
     * @param msg The massage to be encrypted.
     */
    public TimeEncryptJ(String msg)
    {
        _msg = msg;
    }

    /**
     * The encryption method, encoding every char, adding it to string,
     * and adding the encryption time encoded to the end.
     * @return string, the encrypted masssage.
     */
    public String encrypt()
    {
        
        for(int i = 0; i < _msg.length(); i++)
        {
            encrypted += (char)(_msg.charAt(i)+ ev);
            ev += 2;
        }
        
        for(int j = 0; j < encryptionTime.length(); j++)
        {
            encrypted += (char)(encryptionTime.charAt(j)+ te);
            te += 2;
        }
        
        return (encrypted);
    }
}
