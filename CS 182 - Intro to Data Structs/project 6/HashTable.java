import javax.xml.crypto.Data;

/*create a hastable the size of UserInput.getInt(); -> actually its a string, you can just use Interger.parseInt();
the run loop calculating hash locations of each of the names -> createHArray();
create an array of the hash locations -> int [] hashLocations = new int[arraysize];
if a new hash location equals one already filled -> hash crash for (size of hashLocations) {if current dataite.hashVal = hashLocations[i] --->> hashCrash}
run loop to find an empty location, that should be the location of the conflicting location index -> take the value of the i that terminated the above loop and start from there to find new location



*/
////////////////////////////////////////////////////////////////
class DataItem
   {                                // (could have more data)
   private String iData;               // data item (key)
//--------------------------------------------------------------
   public DataItem(String ii)          // constructor
      { iData = ii; }
//--------------------------------------------------------------
   public String getKey()
      { return iData; }
//--------------------------------------------------------------
   }  // end class DataItem
////////////////////////////////////////////////////////////////

/* 
The paint routine should loop through the entire array of names and see if each name is in its proper hash slot. 
If not, it should increment a count and do a linear probe and locate the slot it is in. 
Each 'crash' victim should be reported on the screen, with the slot it should be in and the slot it was found in.
*/

////////////////////////////////////////////////////////////////
class HashTable
   {
      private int crashCount = 0;
     
   private DataItem[] hashArray;    // array holds hash table
   private int arraySize;
   private String [] crashes = new String[500];
   private DataItem nonItem;        // for deleted items
   private String[] names = { "fred" , "barney", "tom", "jerry", "larry", "moe","curly",
   "betty" , "wilma", "bart", "homer", "marge", "maggie", "lisa",
   "pebbles" , "bambam", "smithers", "burns", "milhouse", "george", "astro",
   "dino" , "mickey", "minnie", "pluto", "goofy", "donald", "huey",
   "louie" , "dewey", "snowwhite", "happy", "doc", "grumpy", "sneezy",
   "dopey" , "sleepy", "bambi", "belle", "gaston", "tarzan", "jane",
   "simba" , "scar", "mufasa", "ariel", "flounder", "bugs", "daffy",
   "elmer" , "foghorn", "chickenhawk", "roger", "jessica", "hank", "bobby",
   "peggy" , "spot", "pongo", "perdy", "buzz", "potatohead", "woody",
   "chuckie" , "tommy", "phil", "lil", "angelica", "dill", "spike",
   "pepe" , "speedy", "yosemite", "sam", "tweety", "sylvester", "granny",
   "spiderman" , "batman", "superman", "supergirl", "robin", "jimmy","olsen",
   "thing" , "flash", "silversurfer", "xmen", "pokemon", "joker", "wonderwoman"
   };
  public void doEverything() {
     for (int i = 0; i < crashes.length;i++) {
        crashes[i] = "";
     }
   createHArray();
   displayTable();
  System.out.print("       ");
 for (int i = 0; i < getSize(); i++)  {//this is still causing problems
  System.out.print(hashFunc3(getString(i)) + "->");
 } System.out.println("\n");
 
  }
   // -------------------------------------------------------------
   public void createHArray()       // this creates the DataItem array named hashArray by using a loop to convert each string into type "DataItem"
      {
         
     for (int i = 0; i < names.length; i++) {
     
      DataItem temp = new DataItem(names[i]); 
        insert(temp);
     }
     
      }
// -------------------------------------------------------------
   public HashTable(int size)       // constructor
      {
      arraySize = size;
      hashArray = new DataItem[arraySize];
      nonItem = new DataItem("null");   // deleted item key is -1
      }
// -------------------------------------------------------------
   public void displayTable()
      {
      System.out.print("Table: ");
      for(int j=0; j<arraySize; j++)
         {
         if(hashArray[j] != null)
            System.out.print(hashArray[j].getKey() + " ");
         else
            System.out.print("** ");
         }
      System.out.println("");
      }
// -------------------------------------------------------------
public int hashFunc3(String key)
{
int hashVal = 0;
for(int j=0; j<key.length(); j++)    // left to right
   {
   int letter = key.charAt(j) - 96;  // get char code
   hashVal = (hashVal * 27 + letter) % arraySize; // mod
   }
return hashVal;                      // no mod
}  // end hashFunc3()
// -------------------------------------------------------------
   public void insert(DataItem item) // insert a DataItem
   // (assumes table not full)
      {
      String key = item.getKey();      // extract key
      int hashVal = hashFunc3(key);  // hash the key
                                    // until empty cell or -1,
      while(hashArray[hashVal] != null &&
                      hashArray[hashVal].getKey().equals("null"))
         {
         ++hashVal;                 // go to next cell
         hashVal %= arraySize;      // wraparound if necessary
         }
         if (hashArray[hashVal] == null) {
      hashArray[hashVal] = item;}
      else {
         for (int i = hashVal; i < hashArray.length; i++) {
            if (hashArray[i] == null) {hashArray[i] = item; System.out.println(reportCrash(item, hashVal, i)); break;}
         }
      }   
      }  // end insert()
// -------------------------------------------------------------
   public DataItem delete(String key)  // delete a DataItem
      {
      int hashVal = hashFunc3(key);  // hash the key

      while(hashArray[hashVal] != null)  // until empty cell,
         {                               // found the key?
         if(hashArray[hashVal].getKey() == key)
            {
            DataItem temp = hashArray[hashVal]; // save item
            hashArray[hashVal] = nonItem;       // delete item
            return temp;                        // return item
            }
         ++hashVal;                 // go to next cell
         hashVal %= arraySize;      // wraparound if necessary
         }
      return null;                  // can't find item
      }  // end delete()
// -------------------------------------------------------------
   public DataItem find(String key)    // find item with key
      {
      int hashVal = hashFunc3(key);  // hash the key

      while(hashArray[hashVal] != null)  // until empty cell,
         {                               // found the key?
         if(hashArray[hashVal].getKey() == key)
            return hashArray[hashVal];   // yes, return item
         ++hashVal;                 // go to next cell
         hashVal %= arraySize;      // wraparound if necessary
         }
      return null;                  // can't find item
      }
// -------------------------------------------------------------
// get set functions
public String getString(int index) {

crashCount++;  
 return (hashArray[index] != null) ? hashArray[index].getKey() : " nothing ";
}
public int getSize() {
   return arraySize;
}
public DataItem[] getArray() {
   return hashArray;
}
public String reportCrash(DataItem d, int crashlocation, int probedIndex) {
   for (int i = 0; i < crashes.length; i++) {
      if (crashes[i].equals("")) {crashes[i] = "Hash Crash " + d.getKey() + " should be at "  + crashlocation + " found at " + probedIndex;  
      //System.out.println("Test print for crashes: " + crashes[i]);
      break;}//if ends
     
      
   }
return "Hash Crash " + d.getKey() + " should be at "  + crashlocation + " found at " + probedIndex;
}//report crash ends
public int getCrashCount() {
   return crashCount;
}
public String[] getCrashes() {
   return crashes;
}
public int getCrashLength() {
   return crashes.length;
}
/*
public void checkCollision();
public void linearProbe();
String crashInfo = ""; 
*/

public static void main(String [] args) {//make array of hash locations, if same -> crash
   String[] names = { "fred" , "barney", "tom", "jerry", "larry", "moe","curly",
   "betty" , "wilma", "bart", "homer", "marge", "maggie", "lisa",
   "pebbles" , "bambam", "smithers", "burns", "milhouse", "george", "astro",
   "dino" , "mickey", "minnie", "pluto", "goofy", "donald", "huey",
   "louie" , "dewey", "snowwhite", "happy", "doc", "grumpy", "sneezy",
   "dopey" , "sleepy", "bambi", "belle", "gaston", "tarzan", "jane",
   "simba" , "scar", "mufasa", "ariel", "flounder", "bugs", "daffy",
   "elmer" , "foghorn", "chickenhawk", "roger", "jessica", "hank", "bobby",
   "peggy" , "spot", "pongo", "perdy", "buzz", "potatohead", "woody",
   "chuckie" , "tommy", "phil", "lil", "angelica", "dill", "spike",
   "pepe" , "speedy", "yosemite", "sam", "tweety", "sylvester", "granny",
   "spiderman" , "batman", "superman", "supergirl", "robin", "jimmy","olsen",
   "thing" , "flash", "silversurfer", "xmen", "pokemon", "joker", "wonderwoman"
   }; 
   HashTable test = new HashTable(211);
   int [] nums = new int [211];
   String [] crashes = new String [211];
   int crashcount =0;
    test.createHArray();
    System.out.println(crashes.length + crashes[3]);
    for (int i = 0; i < crashes.length; i++) {
       System.out.println(crashes[i]);
    }
    test.displayTable();
   System.out.print("       ");
  for (int i = 0; i < test.getSize(); i++)  {//this is still causing problems
   System.out.print(test.hashFunc3(test.getString(i)) + "->");
  } System.out.println("\n");
   //instead of finding duplicates here, add this to createHarray and if one of the names gets mapped to the same location move to the next open one
   /*
   {//use this to find the duplicates
       System.out.print(test.hashFunc3(test.getString(i)) + "->");
       nums[i] = test.hashFunc3(test.getString(i));
       for (int j = 0; j < i; j++) {
          if (nums[j] == nums[i]) {crashes[i] = "there is a crash here at " + nums[j] + " should be at " + test.linearProbe(i); crashcount++;}
       }
    }//end of for loop 1
   for (int i = 0; i < crashes.length; i++) {
      if (crashes[i] != null) {System.out.println(crashes[i]);}
   } */
}//main ends
   }  // end class HashTable
////////////////////////////////////////////////////////////////

/*
//Place this in HashTable!  So we can hash Strings NOT int's
////////////////////////////////////////////////////////////////  
public static int hashFunc3(String key)
   {
   int hashVal = 0;
   for(int j=0; j<key.length(); j++)    // left to right
      {
      int letter = key.charAt(j) - 96;  // get char code
      hashVal = (hashVal * 27 + letter) % arraySize; // mod
      }
   return hashVal;                      // no mod
   }  // end hashFunc3()
////////////////////////////////////////////////////////////////
*/