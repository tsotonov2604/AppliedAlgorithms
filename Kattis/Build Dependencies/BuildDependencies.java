import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    int numberOfFiles = Integer.parseInt(reader.readLine());
    HashMap<String, ArrayList<String>> map = new HashMap<>();

    for(int i = 0; i<numberOfFiles; i++){
      String s[] = reader.readLine().split(" ");

      String subFile = s[0].substring(0,s[0].length()-1);

      if(map.containsKey(subFile) == false){
        map.put(subFile, new ArrayList<>());
      }

      for(int k = 1; k<s.length; k++){
        if(map.containsKey(s[k]) == false){
          map.put(s[k],new ArrayList<>());
          map.get(s[k]).add(subFile);
        }

        else
          map.get(s[k]).add(subFile);
      }
    }

    String redo = reader.readLine();
    ArrayList<String> list = new ArrayList<>();
      HashSet<String> visited = new HashSet<>();
    dfs(map,redo,visited, list);

    for(int i = list.size()-1; i>=0; i--)
        writer.write(list.get(i)+"\n");
        writer.flush();

  }

  public static void dfs(HashMap<String, ArrayList<String>> map, String s , HashSet<String> visited ,ArrayList<String> list){
    visited.add(s); 

    for(String v: map.get(s)){
      if(visited.contains(v)==false){
        dfs(map,v,visited,list); 
      }
    }

    list.add(s); 
  }
}