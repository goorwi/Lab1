public class StartWithUppercase implements Sentenceable{
    public void change(String input){
        StringBuffer str = new StringBuffer(input);
        for (int i = 0; i < str.length(); i++)
        {
            if (i == 0) str.replace(i, i + 1, str.substring(i, i+1).toUpperCase());
            else if (str.substring(i-1,i).equals(" ")) str.replace(i,i+1,str.substring(i,i+1).toUpperCase());
            else str.replace(i,i+1,str.substring(i,i+1).toLowerCase());
        }
        System.out.println("Начинать с прописных: " + str.toString());
    }
}