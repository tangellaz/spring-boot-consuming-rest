package restproject;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeSet;

/**
 * SortedData converts CustomTreeMap data to filtered and sorted ArrayList data
 * by creating key and value pairs
 */
public class SortedData {

    private ArrayList<EHR2014DTO> sortedData;

    public void setSortedData(CustomTreeMap mappedData) {
        this.sortedData = this.sortData(mappedData);
    }

    public ArrayList<EHR2014DTO> getSortedData() {
        return sortedData;
    }

    private ArrayList<EHR2014DTO> sortData(CustomTreeMap mappedData) {
        ArrayList<EHR2014DTO> pairedData = new ArrayList<>();
        for(Map.Entry<Float, TreeSet<String>> entry: mappedData.getCustomTreeMap().entrySet()) {
            entry.getValue().forEach(
                    value ->pairedData.add(new EHR2014DTO(entry.getKey(),value))
            );
        }
        return pairedData;
    }

    public String toString() {
        StringBuilder mapAsString = new StringBuilder("[\n");
        for(EHR2014DTO entry : sortedData) {
            mapAsString.append("\t" + entry.getRegion() + " = " + entry.getPctMU() + ",\n");
        }
        mapAsString.delete(mapAsString.length()-2, mapAsString.length()).append("\n]");
        return mapAsString.toString();
    }
}
