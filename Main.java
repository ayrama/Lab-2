import java.io.*;

public class Main {

    public static void main(String[] args) {
	    String path = "F:\\GitLocalFiles\\Labs\\Lab2\\regional-global-daily-latest.csv";
	    String line = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            reader.readLine();
            reader.readLine();
            int row = 200;
            int col = 5;
            int i = 0;
            String[][] chart = new String[row][col];
            while((line = reader.readLine()) != null){
                chart[i]= line.split(",");
                i++;
            }

            PrintWriter pr = new PrintWriter("ProducedChart.txt");
            int number = 1;
            pr.println(number + " " +
                    (chart[0][2].charAt(0) == '"'? chart[0][2].substring(1, chart[0][2].length() - 1) : chart[0][2]));
            for(int j = 1; j < 200; j++){
                boolean bool = true;
                for(int k = j-1; k == 0; k--){
                    if(chart[j][2] == chart[j][2]) {
                        bool = false;
                        break;
                    }
                }
                String s = chart[j][2];
                if(bool)
                    pr.println(++number + " " +
                            (s.charAt(0) == '"'? s.substring(1, s.length() - 1) : s));
            }
            pr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ep) {
            ep.printStackTrace();
        } catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("No such file exists.");
        }
    }
}
