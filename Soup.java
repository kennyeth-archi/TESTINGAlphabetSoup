// Name: Kenneth
// Date: 09/29/26
// Description: This class represents an alphabet soup and allows letters/words to be added, removed, and randomly selected

public class Soup {

    private String letters;
    private String company;

    public Soup() {
        letters = "";
        company = "none";
    }

    // Returns the company name
    public String getCompany(){
        return company;
    }

    // Returns letters
    public String getLetters(){
        return letters;
    }

    // The following is the code I wrote

    // Precondition: word is not null
    // Postcondition: Adds word to the end of letters
    public void add(String word) {
        // User input error proofing
        if (word != null) {
            letters += word;
        }
    }

    // Precondition: name is not null
    // Postcondition: Sets the company name
    public void setCompany (String name) {
        // User input error proofing
        if (name != null) {
            company = name;
        }
    }
    
    // Precodition: letters contains at least one character
    // Postcondition: Returns one randomly selected character from letters
    public char randomLetter() {
        // User input error proofing
        if (letters.length() == 0) {
            return '\0';
        }

        int index = (int)(Math.random() * letters.length());
        return letters.charAt(index);
    }

    // Precodition: letters and company are valid Strings
    // Postcodition: Returns the letters with the company name inserted directly into the center of the letters
    public String companyCentered() {
        int mid = letters.length() / 2;
        String before = letters.substring(0, mid);
        String after = letters.substring(mid);
        String companyCentered = before + company + after;

        return companyCentered;
    }

    // Precondition: letters may contain zero or more characters
    // Postcondition: Removes the first vowel from letters. If there are no vowels, letters remains unchanged
    public void removeFirstVowel() {
        for (int i = 0; i < letters.length(); i++) {
            char c = letters.charAt(i);

            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                String before = letters.substring(0, i);
                String after = letters.substring(i+1);
                letters = before + after;
                return;
            }
        }
    }

    // Precondition: num is greater than or equal to 0 and does not exceed the length of letters
    // Postcondition: Removes num consecutive letters from a random position in letters
    public void removeSome(int num) {
        // User input error proofing
        if (num < 0 || num > letters.length()) {
            return;
        }

        int startPos = (int)(Math.random() * (letters.length() - num + 1));
        String before = letters.substring(0, startPos);
        String after = letters.substring(startPos + num);
        letters = before + after;
    }

    // Precondition: word in not null
    // Postcondition: Removes the first occurence of word from letters. If word is not found in letters, letters remains unchanged 
    public void removeWord(String word){
        // User input error proofing
         if (word == null) {
            return;
        }

        int index = letters.indexOf(word);

        if (index != -1) {
            String before = letters.substring(0, index);
            String after = letters.substring(index + word.length());
            letters = before + after;
        }
    }

}
