package database_layer_highscore;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import service_layer_physics.Game;
import service_layer_players.DwarfNames;
import service_layer_players.Player;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MinerDatabase {
	
	public static void setTheHighscore() {	
		for(Player ply : Game.getPlayers()) {
			
			for (DataPlayer dp : Base.get()) {
				if(dp.getName().equalsIgnoreCase(ply.getDwarfName()))
					{
					dp.setScore(dp.getScore() + ply.getTheScore());
					ply.setTheScore(0);
					}
			}
		}

		JSONArray newJSONArray = new JSONArray();
		
		for (DataPlayer dp : Base.get()) {
			JSONObject o = new JSONObject();
			o.put("score", dp.getScore());
			o.put("dwarfName", dp.getName());
			newJSONArray.add(o);
		}
		
		try (FileWriter file = new FileWriter(".data.json", false)) {
			 file.write(newJSONArray.toJSONString());			 
			 file.flush();
			 file.close();
		} catch (IOException e) {
	     e.printStackTrace();
		}
		
	}
	
	
	
	public static void initHightscore() {
		
	    JSONParser parser = new JSONParser();
	    
		try {
			JSONArray oldJSONArray;
			oldJSONArray = (JSONArray) parser.parse(new FileReader(".data.json"));
			
			Base.clear();
			
			for (Object object : oldJSONArray) {
				JSONObject jo = (JSONObject) object;
				Base.add(jo.get("dwarfName").toString(), Integer.parseInt(jo.get("score").toString()));
			}
		} catch (FileNotFoundException e) {
			try {
				FileWriter file = new FileWriter(".data.json", false);

				JSONArray exceptionJSONArray = new JSONArray();
				
				for (String name : DwarfNames.getTheNameList()) {
					Base.add(name, 0);						
				}
				
				for (DataPlayer dp : Base.get()) {
					JSONObject jo = new JSONObject();					
					jo.put("dwarfName", dp.getName());
					jo.put("score", dp.getScore());

					exceptionJSONArray.add(jo);
				}
				
				//System.out.println(exceptionJSONArray.toJSONString());
				
				
				file.append(exceptionJSONArray.toJSONString());
				file.flush();
				file.close();

			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}		
	}

	public static String getTheHighScore() {
		
    	JSONParser parser = new JSONParser();
    	
    	StringBuilder high = new StringBuilder();
    	
        try {

            Object obj = parser.parse(new FileReader(".data.json"));
            
            JSONArray jsonArray = (JSONArray) obj;            
            
            for(int i = 0; i < jsonArray.size(); i++) {
            	
            	JSONObject actualObject = (JSONObject) jsonArray.get(i);
            	int hossz = 10 - actualObject.get("dwarfName").toString().length();
            	
            	StringBuilder line = new StringBuilder();
            	line.append(actualObject.get("dwarfName"));
            	for(int h = 0; h < hossz; h++)
            		{line.append(" ");}
            	line.append("- ");
            	line.append(actualObject.get("score"));
            	line.append("\n");
            	high.append(line.toString());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
		String highScore = high.toString();
        return highScore;
	}
}