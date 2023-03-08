package e2.structures;

import java.util.List;

public interface Grid {

    public List<Cell> getMines();
    public List<Cell> getFlags();
    public List<Cell> getCounters();

}
