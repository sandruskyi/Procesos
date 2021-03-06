package GameObjects;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Ranking {
    Map<Integer, String> ranking;


   public Ranking() {
       ranking=  new TreeMap<Integer, String>(Collections.reverseOrder());
       ranking.put(300, "Ruben");
       ranking.put(200, "Sandra");
       ranking.put(100, "Rodrigo");
       ranking.put(50, "David");
    }
    public void add(int punt,String name){
       if (name==null)
           name="You";
       ranking.put(punt,name);
    }

    public String[] mejoresJugadores(){
        String[] mejores = new String[5];
        int cupo = 0;
        for (Integer i : ranking.keySet()) {
            if (cupo < 5) {
                mejores[cupo] = ranking.get(i) + " : "+  i;
                cupo++;
            }
        }
        return mejores;
    }

    public void newScore(String name, int score){       //Metodo para introducir el nuevo score
        if (name==null)
            name="You";
       ranking.put(score, name);
    }

    public String[] getRanking(){
        String[] mejores = mejoresJugadores();
        return mejores;
    }
}
