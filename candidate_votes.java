//Hugo Lapa
//6/01/2021

//Imports used
import java.util.*; // For Scanner and math liabries

class Main {
  public static void main(String[] args) {
    execute();
    System.exit(0);
  }

  public static void execute()
  {
    candidate[] candidateArr = new candidate[10];

    //candidate creation
    String name;
    for (int i = 0; i < 10; i++)
    {
      name = getString("Candidate Name: ");
      candidateArr[i] = createCandidate(name);
    }

    //message designating candidates a number
    print("Voting:");
    for (int i = 0; i < 10; i++)
    {
      System.out.print( (i+1) + "=" + getName(candidateArr[i]) + "  ");
    }
    print("");

    //candidate voting
    int response;
    for (int i = 0; i < 10; i++)
    {
      response = getInt(getName(candidateArr[i]) + " who do you vote for: ");
      increaseVote(candidateArr[response-1]);
    }

    //sort the array, smallest to largest
    insertionSort(candidateArr);

    String message = "Winner(s): ";
    //compare if the first two contenders have the value votes
    if (getVotes(candidateArr[9]) == getVotes(candidateArr[8]) )
    {
      //message with both the candidates as they are the top 2
      message += getName(candidateArr[9]) + ", " + getName(candidateArr[8]);
    }
    else
    {
      //message with name of 1 top candidate
      message += getName(candidateArr[9]);
    }

    //prints the final message
    print(message);

  }//END of execute

  //Does insertion sort on the pet array
  public static candidate[] insertionSort (candidate[] array)
  {
    int n = array.length;
    //loops through array
    for (int j = 1; j < n; j++) {
      int x = getVotes(array[j]);
      candidate z = array[j];
      int i = j-1;
      while ( (i > -1) && ( getVotes(array[i]) > x ) ) {
        array[i+1] = array[i];
        i--;
      }
      array[i+1] = z;
    }
    return array;
  }//END of insertionSort


  //displays text and receives int as response to return
  public static int getInt (String txt)
  {
    Scanner scanner = new Scanner(System.in);
    int response = 0;
    boolean end = false;

    while (!end)
    {
      System.out.print(txt);
      response = scanner.nextInt();

      if (response >= 1 && response <= 10)
      {
        end = true;
      }
      else
      {
        System.out.println("Your response was not understood, Please try again!");
        System.out.println("");
        response = getInt(txt);
        end = true;
      }

    }
    
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

  public static candidate createCandidate (String name)
  {
    //Returns an object of the record
    candidate record = new candidate();
    record.name = name;
    record.votes = 0;
    return record;
  }//END of create

  public static String getName (candidate record)
  {
    return record.name;
  }//END of getname

  public static int getVotes (candidate record)
  {
    return record.votes;
  }//END of getVotes

  public static void increaseVote (candidate record)
  {
    record.votes += 1;
    return;
  }//End of increaseVote
}

/* ********************************************
Create a new type (a ADT) called candidates that records a candidates data
A Candidate, has a string name and quantity of votes received values
Used to store candidate details, so the data is used in conjuction with accessor methods, which directly access the attributes
Accessor methods:
getName, getVotes, increaseVote, createCandidate
*********************************************** */
class candidate
{
  String name;
  int votes;
}
