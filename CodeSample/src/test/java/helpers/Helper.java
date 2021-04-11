package helpers;

import net.bytebuddy.utility.RandomString;

import java.util.Random;
import java.security.SecureRandom;
import java.util.GregorianCalendar;

public class Helper {
    public String getRandomName(int NameLength )
    {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = NameLength;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        String result = generatedString.substring(0, 1).toUpperCase() + generatedString.substring(1);

        return result;
    }

    public String getRandomPassword(int PassLength )
    {
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789*";
        SecureRandom random = new SecureRandom();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < PassLength; i++)
        {
            int randomIndex = random.nextInt(chars.length());
            result.append(chars.charAt(randomIndex));
        }
        return result.toString();
    }

    public String getRandomDOB(){
        GregorianCalendar gc = new GregorianCalendar();
        int year = 1900 + (int)Math.round(Math.random() * (2010 - 1900));
        gc.set(gc.YEAR, year);
        int dayOfYear =  1 + (int)Math.round(Math.random() * (gc.getActualMaximum(gc.DAY_OF_YEAR) - 1));
        gc.set(gc.DAY_OF_YEAR, dayOfYear);
        String result = (gc.get(gc.MONTH) + 1) + "/" + gc.get(gc.DAY_OF_MONTH)  + "/" + gc.get(gc.YEAR);
        return  result;
    }

    public String getRandomEmail(int Length) {
        final String chars = "abcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < Length; i++)
        {
            int randomIndex = random.nextInt(chars.length());
            result.append(chars.charAt(randomIndex));
        }
        String email = result.toString() + "@testmail.com";
        return email;
    }

    public String getRandomCountry()
    {
        String [] countries = new String[]
                {
                        "Bahamas","Bahrain","Bangladesh","Barbados","Belarus","Belgium","Honduras","Ireland",
                        "Israel","Italy","Latvia","Lebanon","Morocco","Poland","Russia","Sweden","Switzerland","Taiwan","Tunisia",
                        "Turkey","United Arab Emirates","United Kingdom","United States","Uruguay","Venezuela"
                };
        int random = (int)Math.round(Math.random() * (countries.length-1));
        return countries[random];
    }
}
