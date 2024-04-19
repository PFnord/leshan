/*******************************************************************************
 * Copyright (c) 2013-2015 Sierra Wireless and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * and Eclipse Distribution License v1.0 which accompany this distribution.
 *
 * The Eclipse Public License is available at
 *    http://www.eclipse.org/legal/epl-v20.html
 * and the Eclipse Distribution License is available at
 *    http://www.eclipse.org/org/documents/edl-v10.html.
 *
 * Contributors:
 *******************************************************************************/
package org.eclipse.leshan.core;

import java.util.HashMap;
import java.util.Map;

public class CustomTaskContainer {
    public static Map<String, Map<String, Boolean>> taskInfo = null;
    public boolean requestUpdateAnswer = true;

    private static CustomTaskContainer instance = null;

    private void Container() {
    }

    public static CustomTaskContainer getInstance() {
        if (instance == null) {
            instance = new CustomTaskContainer();
        }
        return instance;
    }

    public static Map<String, Map<String, Boolean>> createInstance(String imei) {
        Boolean provision = false;
        if (taskInfo == null) {
            provision = true;
            taskInfo = new HashMap<>();
        } else if (taskInfo.get(imei) == null) {
            provision = true;
        }
        if (provision) {
            Map<String, Boolean> insideInfo = new HashMap<>();
            insideInfo.put("requestUpdateAnswer", true);
            insideInfo.put("secondUpdateAnswer", false);
            insideInfo.put("waitForSend", false);
            insideInfo.put("sendReceived", false);
            insideInfo.put("maintenanceMode", false);
            taskInfo.put(imei, insideInfo);
        }
        return taskInfo;
    }
}
