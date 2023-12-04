import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlgoQ12 {
    public static void main(String[] args) {
        String message = "Hello <<name>>, We have your full name as <<full name>> in our system. "
                + "Your contact number is 91-xxxxxxxxxx. Please, let us know in case of any clarification "
                + "Thank you BridgeLabz 01/01/2016.";

        String firstName = "John";  
        String fullName = "John Doe";  
        String contactNumber = "91-1234567890";  

        String customizedMessage = customizeMessage(message, firstName, fullName, contactNumber);

        System.out.println(customizedMessage);
    }

    private static String customizeMessage(String message, String firstName, String fullName, String contactNumber) {
        message = message.replaceAll("<<name>>", firstName);
        message = message.replaceAll("<<full name>>", fullName);

        message = message.replaceAll("91-\\d{10}", contactNumber);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String currentDate = dateFormat.format(new Date());
        message = message.replaceAll("\\d{2}/\\d{2}/\\d{4}", currentDate);

        return message;
    }
}
