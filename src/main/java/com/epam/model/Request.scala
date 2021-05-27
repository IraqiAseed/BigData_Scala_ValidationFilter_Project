package com.epam.model

import com.fasterxml.jackson.annotation.JsonProperty

case class Request(@JsonProperty("min_age") minAge: String,
                   @JsonProperty("max_age") maxAge: String,
                   gender: String,
                   @JsonProperty("prefix_name") prefixName: String,
                   @JsonProperty("Marital Status") maritalStatus: String,
                   @JsonProperty("Number of Children") numberOfChildren: String)
