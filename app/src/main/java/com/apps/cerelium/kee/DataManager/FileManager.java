package com.apps.cerelium.kee.DataManager;

import android.content.Context;
import android.os.Environment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

/**
 * Created by Nikhil on 27-02-2016.
 */
public class FileManager {

    protected String key_value_seperator = ":";

    protected String new_line = "\n";

    protected String types_file_name = "types.json";
    protected String content_file_extension = ".json";

    public void writeSomething()
    {
        FileOutputStream outputStream;
        File sdcard = Environment.getExternalStorageDirectory();
        File file = new File(sdcard,"sample_file.json");



        JSONObject card_details_1 = new JSONObject();
        try {
            card_details_1.put("Username", "nikhilbaby2000@gmail.com");
            card_details_1.put("Password", "arackalbaby@1");

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        JSONObject card_details_2 = new JSONObject();
        try {
            card_details_2.put("Username", "nikhil@maximizer-e-service.com");
            card_details_2.put("Password", "arackal123");

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        JSONObject card_details_3 = new JSONObject();
        try {
            card_details_3.put("Username", "nikhilbaby2000");
            card_details_3.put("Password", "a6ackalbaby@1");
            card_details_3.put("A/C", "50100 11725 4434");
            card_details_3.put("IFSC", "HDFC 0003 790");
            card_details_3.put("Card No", "5242 5403 0156 4862");
            card_details_3.put("Validity", "08/20");
            card_details_3.put("CVV", "923");

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        JSONArray card_details_emails = new JSONArray();
        card_details_emails.put(card_details_1);
        card_details_emails.put(card_details_2);


        JSONArray card_details_banks = new JSONArray();
        card_details_banks.put(card_details_3);

        JSONObject card_sections = new JSONObject();
        try
        {
            card_sections.put("Emails",  card_details_emails);
            card_sections.put("Banks",  card_details_emails);
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String jsonStr = card_sections.toString();

        try {
            outputStream = new FileOutputStream(file);
            outputStream.write(jsonStr.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public String getFileString(Context context)
    {

        File sdcard = Environment.getExternalStorageDirectory();
        File file = new File(sdcard,"file.json");
        StringBuilder text = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {


                text.append(line);
                text.append('\n');
            }
            br.close();
        }
        catch (IOException e) {
            //You'll need to add proper error handling here
        }


        return  text.toString();
    }


    public void writeBackGroundsForJsonFile()
    {
        JSONObject main = new JSONObject();
        JSONObject sections = new JSONObject();

        //JSONObject data_main = new JSONObject();
        JSONObject data = new JSONObject();
        JSONObject section_data = new JSONObject();
        JSONObject data_item_object_1  = new JSONObject();
        JSONObject data_item_object_2  = new JSONObject();
        JSONObject data_item_object_3  = new JSONObject();
        JSONArray data_array_1 = new JSONArray();
        JSONArray data_array_2 = new JSONArray();

        //Section --
        JSONArray  section_details_array_1 = new JSONArray();
        JSONArray  section_details_array_2 = new JSONArray();
        JSONObject section_details = new JSONObject();
        JSONObject section_details_item_1 = new JSONObject();
        JSONObject section_details_item_2 = new JSONObject();

        JSONObject section_details_item_3 = new JSONObject();
        JSONObject section_details_item_4 = new JSONObject();
        //Section --

        try {
            //Email section - start
            section_details_item_1.put("section_item_name", "Gmail");
            section_details_item_1.put("item_created_at", "19-3-2016");
            section_details_item_1.put("item_updated_at", "19-3-2016");

            section_details_item_2.put("section_item_name", "Yahoo");
            section_details_item_2.put("item_created_at", "19-3-2016");
            section_details_item_2.put("item_updated_at", "19-3-2016");

            section_details_array_1.put(section_details_item_1);
            section_details_array_1.put(section_details_item_2);
            //Email section - End

            section_details.put("Email", section_details_array_1);

            //Bank section - start
            section_details_item_3.put("section_item_name", "SBT");
            section_details_item_3.put("item_created_at", "19-3-2016");
            section_details_item_3.put("item_updated_at", "19-3-2016");

            section_details_item_4.put("section_item_name", "HDFC");
            section_details_item_4.put("item_created_at", "19-3-2016");
            section_details_item_4.put("item_updated_at", "19-3-2016");

            section_details_array_2.put(section_details_item_3);
            section_details_array_2.put(section_details_item_4);
            //Bank section - End

            section_details.put("Bank", section_details_array_2);

            data_item_object_1.put("key", "username");
            data_item_object_1.put("value", "nikhilbaby2000");

            data_item_object_2.put("key", "password");
            data_item_object_2.put("value", "abcd123");

            data_item_object_3.put("key", "profile password");
            data_item_object_3.put("value", "abcd@1");

            data_array_1.put(data_item_object_1);
            data_array_1.put(data_item_object_2);
            data_array_1.put(data_item_object_3);

            section_data.put("SBT", data_array_1);
            data.put("Bank", section_data);

            main.put("sections", section_details);
            main.put("data", data);


            String jsonStr = main.toString();
            FileOutputStream outputStream;
            File sdcard = Environment.getExternalStorageDirectory();
            File file = new File(sdcard,"sample_file_1.json");

            try {
                outputStream = new FileOutputStream(file);
                outputStream.write(jsonStr.getBytes());
                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
        catch (Exception e)
        {

        }




    }


    public String loadJSONFromAsset() {
        String json = null;
        File sdcard = Environment.getExternalStorageDirectory();
        File file = new File(sdcard,"sample_file_2.json");

        try {
            InputStream is = new FileInputStream(file);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public String[][][] getSections()
    {
        String[][][] sections_main = new String[100][100][100];
        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            JSONObject sections_obj = obj.getJSONObject("sections");
            int sections_count = sections_obj.length();
            sections_main = new String[sections_count][100][100];
//∞ ✓

            Iterator<String> keys = sections_obj.keys();
            int i = 0;
            while (keys.hasNext()) {
                sections_main[i][0][0] =  keys.next();
                sections_main[i][1][0] =  getEndPointDate(sections_obj.getJSONArray(sections_main[i][0][0]), "item_created_at", false);  // sections_obj.getJSONArray(sections_main[i][0]).getJSONObject(0).getString("item_created_at");
                sections_main[i][2][0] =  getEndPointDate(sections_obj.getJSONArray(sections_main[i][0][0]), "item_updated_at", true);  // sections_obj.getJSONArray(sections_main[i][0]).getJSONObject(0).getString("item_updated_at");

                int section_elements_count = sections_obj.getJSONArray(sections_main[i][0][0]).length();
                sections_main[i][3][0] = String.valueOf(section_elements_count);

                for( int item_counter = 1; item_counter <= section_elements_count; item_counter++)
                {
                    sections_main[i][3][item_counter] = sections_obj.getJSONArray(sections_main[i][0][0]).getJSONObject(item_counter-1).getString("section_item_name") ;
                    System.out.println("item_counter_" + i + "_" + item_counter + " = " + sections_main[i][3][item_counter] );
                }

                i++;
            }
            return  sections_main;

            /*Toast.makeText(context, ""+sections_obj.keys().next().toString() , Toast.LENGTH_LONG).show();

            JSONArray email_sections_array = sections_obj.getJSONArray("Email");
            JSONObject section_item = email_sections_array.getJSONObject(0);
            String section_item_name = section_item.getString("section_item_name");*/

            //Toast.makeText(context, section_item_name , Toast.LENGTH_LONG).show();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return  sections_main;
    }

    public String getEndPointDate(JSONArray json_array, String date_index_name, boolean recent)
    {
        try{
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date recent_date = formatter.parse( json_array.getJSONObject(0).getString(date_index_name) );

            for (int i = 0; i < json_array.length(); i++ )
            {
                String str1 = json_array.getJSONObject(i).getString(date_index_name);
                Date date_item = formatter.parse(str1);
                System.out.println("recent_status: " + recent);

                if (recent == true)
                {
                    if (date_item.compareTo(recent_date) > 0)
                    {
                        System.out.println("recent_date["+ recent_date +"] is greater than my date_item["+ date_item +"]");
                        recent_date = date_item;
                    }
                }
                else
                {
                    if (date_item.compareTo(recent_date) < 0)
                    {
                        System.out.println("recent_date["+ recent_date +"] is smaller than my date_item["+ date_item +"]");
                        recent_date = date_item;
                    }
                }


            }

            return DateFormat.getDateInstance().format(recent_date);

        }catch (Exception e1){
            e1.printStackTrace();
        }

        return "";
    }

    public int getSectionsCount()
    {
        int sections_count = 0;
        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            JSONObject sections_obj = obj.getJSONObject("sections");
            sections_count = sections_obj.length();

            return sections_count;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return sections_count;
    }


}
