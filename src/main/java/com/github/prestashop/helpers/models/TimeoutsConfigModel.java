package com.github.prestashop.helpers.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimeoutsConfigModel {
    private int timeoutImplicitSec;

    private int timeoutScriptSec;

    private int timeoutPageLoadSec;
}
