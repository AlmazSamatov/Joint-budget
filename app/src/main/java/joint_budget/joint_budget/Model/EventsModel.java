package joint_budget.joint_budget.Model;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import joint_budget.joint_budget.API.EventsAPI;
import joint_budget.joint_budget.API.FIrebaseAPI.FirebaseEventsAPI;
import joint_budget.joint_budget.DataTypes.Event;

public class EventsModel {

    private List<Event> events;
    private final String eventsFileName = "Events";
    private Context context;
    private EventsAPI eventsAPI;

    public EventsModel(Context context) throws IOException {
        this.context = context;
        events = new ArrayList<>();
        eventsAPI = new FirebaseEventsAPI();
        getEventsFromFile();
    }

    public void addEvent(Event event) throws IOException {
        events.add(event);
        saveEventsToFile();
    }

    private void saveEventsToFile() throws IOException {
        deleteEventsFromFile();
        FileOutputStream out = context.openFileOutput(eventsFileName, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String issuesInJson = gson.toJson(events);
        out.write(issuesInJson.getBytes());
        out.close();
    }

    private void deleteEventsFromFile(){
        File file = new File(context.getFilesDir(), eventsFileName);
        if(file.exists())
            file.delete();
    }

    private void getEventsFromFile() throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        File file = new File(context.getFilesDir(), eventsFileName);
        
        if(file.exists()){
            BufferedReader br = new BufferedReader(new FileReader(file));

            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null)
            {
                contentBuilder.append(sCurrentLine);
            }

            String eventsInJson = contentBuilder.toString();
            Type listType = new TypeToken<List<Event>>(){}.getType();
            Gson gson = new Gson();
            events = gson.fromJson(eventsInJson, listType);
        }
    }

    public List<Event> getEvents(){
        return events;
    }
}
