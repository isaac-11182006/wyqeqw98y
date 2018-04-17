package com.ivant.games.avalon.manager;

/**
 * Created by anthony on 11/16/2017.
 */

public class SettingsManager {

    private static boolean minionBlindMerlin = false;

    private static boolean roleBlindMinion = false;

    public static boolean isMinionBlindMerlin() {
        return minionBlindMerlin;
    }

    public static void setMinionBlindMerlin(boolean minionBlindMerlin) {
        SettingsManager.minionBlindMerlin = minionBlindMerlin;
    }

    public static boolean isRoleBlindMinion() {
        return roleBlindMinion;
    }

    public static void setRoleBlindMinion(boolean roleBlindMinion) {
        SettingsManager.roleBlindMinion = roleBlindMinion;
    }
}
