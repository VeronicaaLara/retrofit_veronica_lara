
package com.ejercicio_retrofit.Grupo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grupo {

    private List<Result> grupos = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<Result> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Result> grupos) {
        this.grupos = grupos;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


    @Override
    public String toString() {
        return "Grupo{" +
                "grupos=" + grupos +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
