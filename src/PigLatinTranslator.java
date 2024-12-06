import java.lang.*;

/*public class PigLatinTranslator
{
  public static Book translate(Book input)
  {
    Book translatedBook = new Book();
    System.out.println("translare Book");
    // Add code here to populate translatedBook with a translation of the input book.
    // Curent do-nothing code will return an empty book.

    return translatedBook;
  }

  public static String translate(String input)
  {
    // System.out.println("Translate String: '" + input + "'");
    System.out.println("translare String");
    // Replace this code to translate a string input.
    // The input to this function could be any English string. 
    // A sentence, paragraph, or a single word. 
    // It should call translateWord at least once.
    String result = translateWord(input);

    return result;
  }

  private static String translateWord(String input)
  {
    // System.out.println("translateWord: '" + input + "'");

    // Replace this code to correctly translate a single word.
    // Start here first!
   // String result = input;
   String end ="";
   String delims ="\\s+";
   String[] words =input.split(delims);
   for(int i=0;i<words.length;i++){
    if(isVowel(words[i].toLowerCase().charAt(0))){
      end+=words[i]+"ay";
    } else {
      end+=words[i].substring(1)+words[i].substring(0,1) + "ay";
    }
    
   }
   return end;
    
   // return result;
  }

  // Add additonal private methods here.
  // For example, I had one like this:
  // private static String capitalizeFirstLetter(String input)
  /*private static int firstVowelIndex(String input1)
  {
    // String input1 = "Twelve";
    String vowels = "aeiouy";
    
    int index = -1;
    int vowel = -1; 
    while((vowel < 0) && (index < input1.length()-1))
    {
      index++;
      vowel = vowels.indexOf(input1.substring(index, index+1));
    }
    System.out.println("First vowels is at index: " + index);
    return index;

  }
   private static String capitalizeFirst(String input)
{
  if (input == null || input.length() == 0) {
    return input;
}
return input.substring(0, 1).toUpperCase() + input.substring(1);

}
 private static String lowercaseFirst(String input)
{
  int size =input.length();
  String first = input.substring(0,1);
  String firstinlower =first.toLowerCase();
  return firstinlower();

}
private static boolean isVowel(char c){
  if (c=='a')
  return true;
  if (c=='e')
  return true;
  if (c=='i')
  return true;
  if (c=='o')
  return true;
  if (c=='u')
  return true;
  return false;
}
/*private static boolean testCapitalWord(String input)
{

}*/

public class PigLatinTranslator {

  public static Book translate(Book input) {
    System.out.println("translate Book Method");
    Book translatedBook = new Book();
    // Add code here to populate translatedBook with a translation of the input book.
    // Curent do-nothing code will return an empty book.
      for (int count = 0; count < input.getLineCount(); count++) {
 
          String Sentence = input.getLine(count);
          translatedBook.appendLine(translate(Sentence));
 
      }
      return translatedBook;
 
  }

 // EMPTY STRING BELOW
 
  public static String translate(String S) {
 
      if (S.trim().isEmpty()) {
 
          return S;
 
      }
    /*   String end ="";
   String delims ="\\s+";
   String[] words =input.split(delims);
   for(int i=0;i<words.length;i++){
    if(isVowel(words[i].toLowerCase().charAt(0))){
      end+=words[i]+"ay";
    } else {
      end+=words[i].substring(1)+words[i].substring(0,1) + "ay";
    }
    
   }
   return end;
    */
 
      StringBuilder result = new StringBuilder();
 
      // String[] words = input.split("\\s+");
      String end ="";
      String delims ="\\s+";
      String[] words =S.split(delims);
 
      for (String word : words) 
      //for(int i=0;i<words.length;i++)
      {
 
          if (!word.isEmpty()) {
 
              result.append(translateWord(word)).append(" ");
 
          }
 
      }
 
      return result.toString().trim();
 
  }
 
  private static String translateWord(String input) {
 
      String originalWord = input;
 
      boolean isCapitalized = Character.isUpperCase(input.charAt(0));
 
      boolean isMixedCapitalization = !input.equals(input.toLowerCase()) && !input.equals(input.toUpperCase());
 
      String prefix = "";
 
      String suffix = "";
 
      int hyphenIndex = input.indexOf('-');
 
      if (hyphenIndex > 0) {
 
          String firstPart = translateWord(input.substring(0, hyphenIndex));
 
          String secondPart = translateWord(input.substring(hyphenIndex + 1));
 
          return firstPart + "-" + secondPart;
 
      }
 
      if (input.matches(".*\\p{Punct}$")) {
 
          suffix = input.substring(input.length() - 1);
 
          input = input.substring(0, input.length() - 1);
 
      }
 
      String coreWord = input.toLowerCase();
 
      if (startsWithVowel(coreWord)) {
 
          coreWord = coreWord + "ay";
 
      } else {
 
          int firstVowelIndex = firstVowelIndex(coreWord);
 
          if (firstVowelIndex > 0) {
 
              coreWord = coreWord.substring(firstVowelIndex) + coreWord.substring(0, firstVowelIndex) + "ay";
 
          }
 
      }

 
      if (isCapitalized) {
 
          coreWord = capitalizeFirst(coreWord);
 
      } else if (isMixedCapitalization) {
 
          coreWord = MixedCap(coreWord, originalWord);
 
      }
 
      return prefix + coreWord + suffix;
 
  }
 
  private static boolean startsWithVowel(String word) {
 
      return word.matches("^[aeiouAEIOU].*");
 
  }
 
  private static int firstVowelIndex(String input1)
 {
   
   String vowels = "aeiouy";
  
   int index = -1;
   int vowel = -1;
   while((vowel < 0) && (index < input1.length()-1))
   {
     index++;
     vowel = vowels.indexOf(input1.substring(index, index+1));
   }
   //System.out.println("First vowels is at index: " + index);
   return index;


 }

  private static String capitalizeFirst(String input)
{
  if (input == null || input.length() == 0) {
    return input;
}
return input.substring(0, 1).toUpperCase() + input.substring(1);

}
 
  private static String MixedCap(String T, String S) {
   // String result = new String();
   StringBuilder result = new StringBuilder();
    for (int i = 0; i < S.length(); i++) {
        if (i < T.length()) {
            result.append(Character.isUpperCase(S.charAt(i))
                    ? Character.toUpperCase(T.charAt(i))
                    : T.charAt(i));
        }
    }
    return result.toString();
 
  }
 
 }