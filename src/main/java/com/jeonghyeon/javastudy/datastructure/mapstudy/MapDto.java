package com.jeonghyeon.javastudy.datastructure.mapstudy;

import lombok.Data;

import java.util.Map;

@Data
public class MapDto {
    Map<String,Integer> linkedMap;
    Map<String,Integer> linkedHashMap;

    public MapDto(Map<String, Integer> linkedMap, Map<String, Integer> linkedHashMap) {
        this.linkedMap = linkedMap;
        this.linkedHashMap = linkedHashMap;
    }
}
