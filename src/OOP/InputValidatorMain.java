package OOP;
import java.util.List;

interface Validator {
    boolean validate(String input);
}

class EmailValidator implements Validator {
    public boolean validate(String input) {
        // Return true if input contains "@"
        return input.contains("@");
    }
}

class PasswordValidator implements Validator {
    public boolean validate(String input) {
        // Return true if input.length() >= 8
        return input.length()>=8;
    }
}

class RegistrationService {
    private List<Validator> validators;

    public RegistrationService(List<Validator> validators) {
        this.validators = validators;
    }

    public void register(String input) {
        // Run all validators on input. If all pass, print "input" - PASSED
        // If any fail, print "input" - FAILED
        for(Validator validator: validators){
            if(!validator.validate(input)){
                System.out.println("\""+input+"\" - FAILED");
                return;
            }
        }
        System.out.println("\""+input+"\" - PASSED");
    }
}


public class InputValidatorMain {
    public static void main(String[] args) {
        List<Validator> emailValidators = List.of(new EmailValidator());
        RegistrationService emailReg = new RegistrationService(emailValidators);
        emailReg.register("user@example.com"); // Should pass
        emailReg.register("invalid-email");     // Should fail

        List<Validator> passwordValidators = List.of(new PasswordValidator());
        RegistrationService passReg = new RegistrationService(passwordValidators);
        passReg.register("strongpassword"); // Should pass
        passReg.register("short");           // Should fail
    }
}
