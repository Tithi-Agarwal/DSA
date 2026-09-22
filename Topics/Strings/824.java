//824. Goat Latin

class Solution {
    public String toGoatLatin(String sentence) {
        String words[] = sentence.trim().split(" ");
        int cnt = 1;
        for(String word: words)
        {
            StringBuilder newWord = new StringBuilder(word);
            char ch = word.charAt(0);
            if (!(ch == 'a' || ch =='e' || ch =='i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'))
            {
                newWord.deleteCharAt(0);
                newWord.append(ch);
            }
            newWord.append("ma");
            int i = 1;
            while(i <= cnt)
            {
                newWord.append("a");
                i++;
            }

            words[cnt - 1] = newWord.toString();
            cnt++;           
        }
        return String.join(" ", words);
    }
}