package com.youssefameachaq.consumingrestfulws.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Quote (String type, Value value) { }