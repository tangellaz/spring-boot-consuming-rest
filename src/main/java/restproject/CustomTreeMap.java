package restproject;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * CustomTreeMap converts an array of objects (EHR2014DTO[]) to a TreeMap.
 * The TreeMap uses pctMU of type float as key and TreeSet to store region/state
 * of type String values. Trees were used here for their sorting property
 */
public class CustomTreeMap {
    private TreeMap<Float, TreeSet<String>> customTreeMap;

    public TreeMap<Float, TreeSet<String>> getCustomTreeMap() {
        return this.customTreeMap;
    }

    public void setCustomTreeMap(EHR2014DTO[] dataArray) {
        this.customTreeMap = this.mapData(dataArray);
    }
    private TreeMap<Float, TreeSet<String>> mapData(EHR2014DTO[] dataArray) {
        TreeMap<Float, TreeSet<String>> sortedData = new TreeMap<>(Collections.reverseOrder());
        for(EHR2014DTO entry : dataArray) {
            sortedData.computeIfAbsent(entry.getPctMU(), k -> new TreeSet<>()).add(entry.getRegion());
        };
        return sortedData;
    }

    @Override
    public String toString() {
        StringBuilder mapAsString = new StringBuilder("{\n");
        for(Map.Entry<Float, TreeSet<String>> entry: customTreeMap.entrySet()) {
            mapAsString.append("\t" + entry.getKey() + ": " + entry.getValue() + ",\n");
        }
        mapAsString.delete(mapAsString.length()-2, mapAsString.length()).append("\n}");
        return mapAsString.toString();
    }
}
