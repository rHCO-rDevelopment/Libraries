package rip.lazze.libraries.utilities.commands.parameter;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.Set;
import rip.lazze.libraries.utilities.commands.param.ParameterType;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import rip.lazze.libraries.utilities.commands.param.ParameterType;

public class FloatParameterType implements ParameterType<Float> {
    public FloatParameterType() {
    }

    public Float transform(CommandSender sender, String value) {
        if (value.toLowerCase().contains("e")) {
            sender.sendMessage(ChatColor.RED + value + " is not a valid number.");
            return null;
        } else {
            try {
                float parsed = Float.parseFloat(value);
                if (!Float.isNaN(parsed) && Float.isFinite(parsed)) {
                    return parsed;
                } else {
                    sender.sendMessage(ChatColor.RED + value + " is not a valid number.");
                    return null;
                }
            } catch (NumberFormatException var4) {
                sender.sendMessage(ChatColor.RED + value + " is not a valid number.");
                return null;
            }
        }
    }

    public List<String> tabComplete(Player sender, Set<String> flags, String prefix) {
        return ImmutableList.of();
    }
}
