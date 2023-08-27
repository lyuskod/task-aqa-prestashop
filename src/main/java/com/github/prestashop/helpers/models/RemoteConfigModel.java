package com.github.prestashop.helpers.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RemoteConfigModel {
    private boolean enabled;

    private String url;
}
