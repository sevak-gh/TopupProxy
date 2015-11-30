package com.infotech.isg.domain;

import java.util.Map;
import java.util.HashMap;
import java.util.regex.Pattern;

/**
 * generic service actions
 *
 * @author Sevak Gharibian
 */
public class ServiceActions {
    private static Map<String, Integer> actions = new HashMap<String, Integer>();

    public static final int TOP_UP = 1;
    public static final int BULK = 2;
    public static final int PAY_BILL = 3;
    public static final int WOW = 4;                // MTN only
    public static final int POST_WIMAX = 5;         // MTN only
    public static final int PRE_WIMAX = 6;          // MTN only
    public static final int GPRS = 7;
    public static final int GPRS_COMBO = 8;         // MTN only

    static {
        actions.put("top-up", TOP_UP);
        actions.put("bulk", BULK);
        actions.put("pay-bill", PAY_BILL);
        actions.put("wow", WOW);
        actions.put("post-wimax", POST_WIMAX);
        actions.put("pre-wimax", PRE_WIMAX);
        actions.put("gprs", GPRS);
        actions.put("gprs-00", GPRS_COMBO);
    }

    public static boolean isActionExist(String action) {
        // gprs combo
        if (action.startsWith("gprs-")) {
            Pattern pattern = Pattern.compile("gprs-[0-9][0-9]");
            if (!pattern.matcher(action).matches()) {
                return false;
            } else {
                return true;
            }
        }

        return actions.containsKey(action);
    }

    public static int getActionCode(String action) {
        // gprs combo
        if (action.startsWith("gprs-")) {
            return GPRS_COMBO;
        }

        Integer actionCode = actions.get(action);
        return ((actionCode != null) ? actionCode.intValue() : 0);
    }

    // for grps combo only
    public static int getGprsProfileId(String action) {
        // gprs-00
        return Integer.parseInt(action.substring(5));
    }
}
