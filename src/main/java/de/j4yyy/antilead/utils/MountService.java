package de.j4yyy.antilead.utils;

import de.j4yyy.antilead.AntiLead;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class MountService {

    private final ArrayList<Player> mountBlocked;
    private final AntiLead plugin;

    public MountService(AntiLead plugin) {
        this.mountBlocked = new ArrayList<>();
        this.plugin = plugin;
    }

    public void addMountBlock(Player player) {
        this.mountBlocked.add(player);
        new BukkitRunnable() {
            @Override
            public void run() {
                removeFromList(player);
            }
        }.runTaskLater(this.plugin, 20L*2);
    }

    private void removeFromList(Player player) {
        this.mountBlocked.remove(player);
    }

    public boolean isMountBlocked(Player player) {
        for(Player p : this.mountBlocked) {
            if(p.equals(player)) {
                return true;
            }
        }
        return false;
    }
}