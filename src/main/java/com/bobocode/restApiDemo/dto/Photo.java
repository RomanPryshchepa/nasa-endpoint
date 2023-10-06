package com.bobocode.restApiDemo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Photo (Long id, String sol, @JsonProperty("img_src")String imgSrc) {
}
