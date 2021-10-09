public class Main
{
    public static int solution(String words[], int farr[], int score[], int idx)
    {
        if(idx == words.length)
        {
            return 0;
        }
        int sno = 0+solution(words,farr,score,idx+1);
        int sword = 0;
        String word = words[idx];
        boolean flag = true;
        for(int i=0;i<word.length();i++)
        {
            char ch = word.charAt(i);
            if(farr[ch-'a'] == 0)
            {
                flag=false;
            }
            farr[ch-'a']--;
            sword += score[ch-'a'];
        }
        int syes = 0;
        if(flag )
        {
            syes = sword + solution(words,farr,score,idx+1);
            
        }
        for(int i=0;i<word.length();i++)
        {
            char ch = word.charAt(i);
            farr[ch-'a']++;
        }
        return Math.max(sno,syes);
    }

}
