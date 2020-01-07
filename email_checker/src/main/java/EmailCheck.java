import java.util.*;

public class EmailCheck{

   /* takes in a list of email addresses and returns an integer indicating the number of unique email addresses.
    Where "unique" email addresses means they will be delivered to the same account using Gmail account matching.
        Specifically: Gmail will ignore the placement of "." in the username. And it will ignore any portion of the username after a "+".*/
    public static int emailChecker(List<String> emails){
        Set<String> uniqueEmails =new HashSet<>();
        for(String email: emails){
            int index = email.indexOf("@");
            if(index!=-1){
                String former = email.substring(0, index).replace(".","");
                String latter = email.substring(index+1);
                if(former.contains("+")){
                    former=former.substring(0,former.indexOf("+"));
                }

                uniqueEmails.add(former+"@"+latter);
            }
        }
        System.out.println(uniqueEmails);
        return uniqueEmails.size();

    }


    public static void main(String[] args) {
        List<String> emails=new ArrayList<>(Arrays.asList("test.email@gmail.com", "test.email+spam@gmail.com","testemail@gmail.com"));
        System.out.println(emailChecker(emails));

    }


}