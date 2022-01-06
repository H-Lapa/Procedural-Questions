//Hugo Lapa
//6/01/2021

//Imports used
import java.util.*; // For Scanner and random liabries

class Main {
  public static void main(String[] args) 
  {
    //execute is main method
    execute();
    System.exit(0);
  }

  public static void execute ()
  {
    //delaring variables for the loop
    int response;
    int score = 0;
    int start = getInt("Enter x start (x>0): ");
    int end = getInt("Enter x end (x>=start): ");

    //loops through the necessary questions
    for (int i = start; i <= end; i++)
    {
      for (int x = 1; x <= 12; x++)
      {
        //question being asked
        response = getInt("What is " + i + " * " + x + "?");

        //checks if it is correct
        if (response == (i*x))
        {
          print("Correct");
          score += 1; //keeping track of the score
        }
        else
        {
          print("incorrect");
        }
      }
    }

    //variable starting with a small d are the double version of an integer
    double dmax = (double)((end-start+1)*12);
    int max = (int)dmax;
    double dScore = (double)(score);

    //doubles from before are needed to find an accurate percentage
    int percentage = (int)Math.round((dScore/max)*100);

    //method returns the righ grade back
    String grade = grader(percentage);

    //prints the final message with the score and grade
    print("You scored " + score + "/" + max + " (" + percentage + "%) " + grade + " grade.");
  }//END of execute

  public static String grader (int percentage)
  {
    //if statement returns the grade based on certain brackets
    if (percentage >= 70)
    {
      return "A";
    }
    else if ( percentage >= 60)
    {
      return "B";
    }
    else if( percentage >= 50)
    {
      return "C";
    }
    else if (percentage >= 40)
    {
      return "D";
    }
    else
    {
      return "F";
    }
  }//END of grader

  //displays text and receives int as response to return
  public static int getInt (String txt)
  {
    Scanner scanner = new Scanner(System.in);
    System.out.print(txt);
    int response = scanner.nextInt();
    return response;
  }//END of getInt

  //displays text and receives String as response to return
  public static String getString (String txt)
  {
    Scanner scanner = new Scanner(System.in);
    System.out.print(txt);
    String response = scanner.nextLine();
    return response;
  }//END of getString

  //prints to screen in less words
  public static void print (String txt)
  {
    System.out.println(txt);
    return;
  }//END of print

}
