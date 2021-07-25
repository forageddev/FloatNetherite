package dev.foraged.netherritefloat;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public final class Netherritefloat extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        System.out.println("do dah this");
        Bukkit.getPluginManager().registerEvents(this, this);

        getServer().getScheduler().scheduleSyncRepeatingTask(this, () -> {
            Bukkit.getServer().getOnlinePlayers().forEach(this::check);
        }, 0L, 10L);
    }

    public void check(Player player) {
        if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType().equals(Material.LAVA)) {


            if (player.getInventory().getHelmet() == null || !player.getInventory().getHelmet().getType().equals(Material.NETHERITE_HELMET))
                return;
            if (player.getInventory().getChestplate() == null || !player.getInventory().getChestplate().getType().equals(Material.NETHERITE_CHESTPLATE))
                return;
            if (player.getInventory().getLeggings() == null || !player.getInventory().getLeggings().getType().equals(Material.NETHERITE_LEGGINGS))
                return;
            if (player.getInventory().getBoots() == null || !player.getInventory().getBoots().getType().equals(Material.NETHERITE_BOOTS))
                return;

            player.teleport(player.getLocation().add(0, 0.4, 0));
        }
    }
}
