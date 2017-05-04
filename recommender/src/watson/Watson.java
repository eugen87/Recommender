package watson;


import java.io.FileNotFoundException;
import twitter.GetTweets;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ibm.watson.developer_cloud.personality_insights.v2.PersonalityInsights;
import com.ibm.watson.developer_cloud.personality_insights.v2.model.Profile;

public class Watson {
 
	public void getWatson() throws FileNotFoundException{
		
		JsonParser parser = new JsonParser();
		 
		PersonalityInsights service = new PersonalityInsights();
		service.setUsernameAndPassword("1174b3f3-3585-496a-bd30-42f8e5479939", "aiAKt4pwmPaV");
		service.setEndPoint("https://gateway.watsonplatform.net/personality-insights/api");
//		 GetTweets gt = new GetTweets();
//		 String text = gt.getAllTweets("xxxxxxxxxxxx");
//		 
//		 Profile profile = service.getProfile(text).execute();
//	        JsonObject json = parser.parse(profile.toString()).getAsJsonObject();
//	        
//	        System.out.println(json);
		 
	}
}
