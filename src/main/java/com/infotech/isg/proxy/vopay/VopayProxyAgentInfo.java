package com.infotech.isg.proxy.vopay;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * representing vopay agent_info object.
 *
 * @author Sevak Gharibian
 */
public class VopayProxyAgentInfo {

    private int id;
    private String name;

    @JsonProperty("AgentID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("AgentName")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("AgentInfo[id: %s, name: %s]", String.valueOf(id), name);
    }
}
