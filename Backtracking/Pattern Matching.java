import java.util.*;
public class Main
{
    public static void solution(String str, String pattern, HashMap<Character,String> map, String op)
    {
        if(pattern.length() == 0)
        {
            if(str.length() == 0)
            {
                HashSet<Character> ap=new HashSet<>();
                for(int i=0;i<op.length();i++)
                {
                    char ch = op.charAt(i);
                    if(ap.contains(ch) == false)
                    {
                        System.out.print(ch+"->"+map.get(ch)+",");
                        ap.add(ch);
                    }
                }
                System.out.println();
            }
            return;
        }
        char ch = pattern.charAt(0);
        String rop = pattern.substring(1);
        if(map.containsKey(ch))
        {
            String pM = map.get(ch);
            if(str.length() >= pM.length())
            {
                String left = str.substring(0,pM.length());
                String right = str.substring(pM.length());
                if(pM.equals(left))
                {
                    solution(right,rop,map,op);
                }
            }
        }
        else 
        {
            for(int i=0;i<str.length();i++)
            {
                String left = str.substring(0,i+1);
                String right = str.substring(i+1);
                map.put(ch,left);
                solution(right,rop,map,op);
                map.remove(ch);
            }
        }
    }
