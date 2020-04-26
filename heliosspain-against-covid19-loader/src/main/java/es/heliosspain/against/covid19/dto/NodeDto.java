package es.heliosspain.against.covid19.dto;

import java.io.Serializable;

public class NodeDto implements Serializable {

    DataNodeDto data;
    GroupType group;

    public DataNodeDto getData() {
        return data;
    }

    public void setData(DataNodeDto data) {
        this.data = data;
    }

    public GroupType getGroup() {
        return group;
    }

    public void setGroup(GroupType group) {
        this.group = group;
    }
}
