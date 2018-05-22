package com.orasi.utils.dataHelpers;

import static com.orasi.utils.TestReporter.log;

import java.util.HashMap;

import com.orasi.utils.exception.KeyExistsException;
import com.orasi.utils.exception.NoKeyFoundException;

public class DataWarehouse {

    private HashMap<String, Object> dataMap;

    /*
     * Constructor for OutputDataWarehouse
     */
    public DataWarehouse() {
        dataMap = new HashMap<String, Object>();
    }

    /*
     * Method for adding a new key and data to the HashMap.
     *
     * @key Unique Identifier for the data
     *
     * @value The value of data to be stored
     */
    public void add(String key, Object value) {
        if (dataMap.containsKey(key)) {
            throw new KeyExistsException("Failed to add " + key + " because the key already exists.");
        }
        dataMap.put(key, value);
    }

    /**
     * Method for merging a new HashMap of data into DataWarehouse
     *
     * @param patch
     *            Existing HashMap to merge into DataWarehouse
     */
    public void patch(HashMap<String, Object> patch) {
        patch.forEach(dataMap::putIfAbsent);
        patch.forEach(dataMap::replace);
    }

    /*
     * Method for updating an existing key in the map.
     */
    public void update(String key, Object value) {
        if (!dataMap.containsKey(key)) {
            throw new NoKeyFoundException("Failed to update " + key + " because the key doesn't exist.");
        }
        dataMap.put(key, value);
    }

    /*
     * Method for retrieving data from the HashMap
     *
     * @key The unique identifier in which the value desired belongs to
     */
    public Object get(String key) {
        Object data = dataMap.get(key);
        if (data == null) {
            throw new NoKeyFoundException("Failed to find " + key + " in the output data warehouse.");
        }
        return data;
    }

    /*
     * Method for retrieving the HashMap
     */
    public HashMap<String, Object> getData() {
        return dataMap;
    }

    public void printData() {
        dataMap.forEach((key, value) -> log(key + " = " + value));
    }
}
