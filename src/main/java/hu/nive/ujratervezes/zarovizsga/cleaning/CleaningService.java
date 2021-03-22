package hu.nive.ujratervezes.zarovizsga.cleaning;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CleaningService {
    private final String SEPARATOR = ", ";
    private List<Cleanable> cleanables = new ArrayList<>();

    public void add(Cleanable cleanable) {
        cleanables.add(cleanable);
    }

    public int cleanAll() {

        int result = 0;
        for(Cleanable c : cleanables) {
            result += c.clean();
        }
        cleanables.clear();
        return result;
    }
    public int cleanOnlyOffices() {
        List<Cleanable> toRemove = new ArrayList<>();
        int result = 0;
        for(Cleanable c : cleanables) {
            if(c instanceof Office) {
                result += c.clean();
                toRemove.add(c);
            }
        }
        cleanables.removeAll(toRemove);
        return result;
    }
    public List<Cleanable> findByAddressPart(String address) {
        return cleanables.stream().filter(c -> c.getAddress().contains(address)).collect(Collectors.toList());
    }

    public List<Cleanable> getCleanables() {
        return new ArrayList<>(cleanables);
    }
    public String getAddresses() {
        StringBuilder sb = new StringBuilder();
        for(Cleanable c : cleanables) {
            sb.append(c.getAddress()).append(SEPARATOR);
        }
        String row = sb.toString();

        return sb.deleteCharAt(row.lastIndexOf(",")).toString().trim();
    }
}
