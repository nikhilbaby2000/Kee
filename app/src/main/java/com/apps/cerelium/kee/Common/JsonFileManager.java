package com.apps.cerelium.kee.Common;

import android.os.Environment;
import android.util.JsonWriter;

import com.apps.cerelium.kee.DataManager.Holder;
import com.apps.cerelium.kee.DataManager.HolderTypes;
import com.apps.cerelium.kee.DataManager.Item;
import com.apps.cerelium.kee.DataManager.User;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

/**
 * Created by Nikhil on 25-02-2016.
 */
public class JsonFileManager {

    public void createFile()
    {
        try {
            FileOutputStream outputStream;
            File sdcard = Environment.getExternalStorageDirectory();
            File file = new File(sdcard,"sample_file.json");

            outputStream = new FileOutputStream(file);

            User user = new User();
            user.setUserName("Nikhil");

            Item i1,i2,i3;
            i1 = new Item();
            i1.setKey("Account Number"); i1.setValue("123456");
            i2 = new Item();
            i2.setKey("Bank Name"); i2.setValue("HDFC");
            i3 = new Item();
            i3.setKey("Account Balance"); i3.setValue("5000");

            Holder holder = new Holder();
            Item[] items = new Item[]{i1, i2, i3};
            holder.setItemObject(items);

            Holder[] holders = new Holder[]{holder};

            HolderTypes holderTypes = new HolderTypes();
            holderTypes.setHolderTypeName("Banking");
            holderTypes.setAllHolderObjects(holders);

            user.setHolderTypesList((List<HolderTypes>) holderTypes);

            writeJsonStream(outputStream, user);
            outputStream.close();

        }
        catch (Exception e)
        {

        }
    }

    public void writeJsonStream(OutputStream out, User messages) throws IOException {
        JsonWriter writer = new JsonWriter(new OutputStreamWriter(out, "UTF-8"));
        writer.setIndent("  ");
        writer.name("user").value(messages.getUserName());
        writeMessagesArray(writer, messages);
        writer.close();
    }

    public void writeMessagesArray(JsonWriter writer, User messages) throws IOException {
        writer.beginArray();
        for (HolderTypes message : messages.getHolderTypesList() ) {
            writer.name("type").value(message.getHolderTypeName());
            writeMessage(writer, message);
        }
        writer.endArray();
    }

    public void writeMessage(JsonWriter writer, HolderTypes messages) throws IOException {
        writer.beginObject();
        for (Holder message : messages.getAllHolderObjects() ) {
            writeItems(writer, message);
        }
        writer.endObject();

    }

    public void writeItems(JsonWriter writer, Holder messages) throws IOException {
        writer.beginObject();
        for (Item message : messages.getItemObject() ) {
            writer.name("key").value(message.getKey() );
            writer.name("value").value(message.getValue() );
        }
        writer.endObject();
    }

   /*********************************************   ***********************************************/





}
