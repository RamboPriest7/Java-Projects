/* Christian Jarmon
CMPSCI 111L - Spring 2020
Project 5 */

public class LineOfText {
  // Object Variables
  private String[] words;
  private int lineNumber;
  private String space;

  // Constructors
  public LineOfText(String sentence, int lineNumber, String space) {
    words = sentence.split("\\s");
    this.lineNumber = lineNumber;
    this.space = space;
  }// Con 1 LOT ends

  public LineOfText(LineOfText other) {
    words = new String[other.words.length];
    for (int i = 0; i < words.length; i++) {
      words[i] = other.words[i] + "";
    }
    lineNumber = other.lineNumber;
    space = other.space + "";
  }// Con 2 LOT ends

  // Getter/Setter Methods
  public String getWord(int index) {
    if (index >= 0 && index < words.length) {
      return words[index];
    } else {
      return "";
    }
  }

  public void setWord(int index, String newWord) {
    if (index >= 0 && index < words.length) {
      words[index] = newWord;
    }
  }

  public int getLength() {
    return words.length;
  }

  public int getLineNumber() {
    return lineNumber;
  }

  public void setLineNumber(int lineNumber) {
    this.lineNumber = lineNumber;
  }

  public String getSpace() {
    return space;
  }

  public void setSpace(String space) {
    this.space = space;
  }

  // Object Methods
  public String toString() {
    String result = String.format("%02d:%s", lineNumber, space);
    for (int i = 0; i < words.length; i++) {
      result += words[i] + space;
    }
    result += "(end-of-line)";
    return result;
  }

  // go back and try to understand "%02d:%s"~~~~~~~~~~~~!!
  public String toSentence() {
    String result = "";
    for (int i = 0; i < words.length; i++) {
      result += words[i];
      if (i < words.length - 1) {
        result += " ";
      }
    }
    return result;
  }// toSentence ends
}// class LineOftext ends