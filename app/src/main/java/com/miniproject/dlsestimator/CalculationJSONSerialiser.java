package com.miniproject.dlsestimator;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class CalculationJSONSerialiser {

    private Context mContext;
    private String mFileName;

    public CalculationJSONSerialiser(Context c, String f) {
        mContext = c;
        mFileName = f;
    }

    public Calculation loadCalculation() throws IOException, JSONException {
        Calculation calculation;
        BufferedReader reader = null;
        try {
            InputStream in = mContext.openFileInput(mFileName);
            reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder jsonString = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonString.append(line);
            }

            JSONObject jsonObject = new JSONObject(jsonString.toString());

            calculation = new Calculation(jsonObject);
        } catch (FileNotFoundException e) {
            // App starting fresh
            throw new FileNotFoundException();
        } finally {
            if (reader != null)
                reader.close();
        }
        return calculation;
    }

    public void saveCalculation(Calculation calculation) throws IOException, JSONException {
        Writer writer = null;
        try {
            OutputStream out = mContext.openFileOutput(mFileName, Context.MODE_PRIVATE);
            writer = new OutputStreamWriter(out);
            writer.write(calculation.toJSON().toString());
        } finally {
            if (writer != null)
                writer.close();
        }
    }
}
