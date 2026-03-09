package kam.kamsTweaks.features;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.tree.LiteralCommandNode;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;
import io.papermc.paper.plugin.lifecycle.event.registrar.ReloadableRegistrarEvent;
import kam.kamsTweaks.ConfigCommand;
import kam.kamsTweaks.Feature;
import kam.kamsTweaks.ItemManager;
import kam.kamsTweaks.KamsTweaks;
import net.kyori.adventure.text.Component;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.jetbrains.annotations.NotNull;

public class SlashSuicide extends Feature {

    @Override
    public void shutdown() {}

    @Override
    public void registerCommands(ReloadableRegistrarEvent<@NotNull Commands> commands) {
        LiteralArgumentBuilder<CommandSourceStack> command = Commands.literal("suicide")
                .executes(ctx -> {
                    CommandSender sender = ctx.getSource().getSender();
                    Entity executor = ctx.getSource().getExecutor();
                    if (executor instanceof Player player) {
                        player.setHealth(0.0);
                    }
                    sender.sendMessage("Only players can use /suicide.");
                    return Command.SINGLE_SUCCESS;
                });
        LiteralCommandNode<CommandSourceStack> buildCommand = command.build();
        commands.registrar().register(buildCommand);

    }

    @Override
    public void loadData() {}

    @Override
    public void saveData() {}
}
