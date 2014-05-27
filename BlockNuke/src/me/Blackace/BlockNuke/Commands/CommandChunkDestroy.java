package me.Blackace.BlockNuke.Commands;

import me.Blackace.BlockNuke.BlockNuke;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandChunkDestroy implements CommandExecutor{

	BlockNuke plugin;

	public CommandChunkDestroy(BlockNuke instance)
	{
		plugin = instance;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{

		if(label.equalsIgnoreCase("chunkdestroy") && sender.isOp())
		{

			if(Bukkit.getWorld(args[0]) != null)
			{
				//get x and z and parse
				int x = 0;
				int z = 0;
				try{
				x = Integer.parseInt(args[1]);
				z = Integer.parseInt(args[2]);
				}
				catch(NumberFormatException e){
					sender.sendMessage("Invalid X or Z given. /chunkdestroy <World> <X> <Z> <BlockID:Meta>");
					return false;
				}
				
				//use x and z to get chunk location from Bukkit
				Chunk chunk = Bukkit.getServer().getWorld(args[0]).getChunkAt(x, z);
				
				//pull array of BlockStates from the chunk
				BlockState[] tileEnts = chunk.getTileEntities();

				//get length of array for the "for" loop and create block counter variable
				int theLength = tileEnts.length;
				int blocksRemoved = 0;

				sender.sendMessage("" + theLength);
				
				//checks blocks in the chunk for blocks matching command args[3] and removes them
				for(int i = (theLength - 1) ; i >= 0 ; i--)
				{
					int id = tileEnts[i].getBlock().getType().getId();
					int meta = tileEnts[i].getBlock().getData();
					String cursor;

					if(meta == 0)
					{
						cursor =  String.valueOf(id);
					}
					else {
						cursor = id + ":" + meta;
					}
					sender.sendMessage(cursor);
					
					if(cursor.equalsIgnoreCase(args[3]))
					{
						tileEnts[i].getBlock().setType(Material.AIR);
						blocksRemoved++;
					}
				}
				sender.sendMessage(ChatColor.AQUA + "" + blocksRemoved + "" + ChatColor.GREEN + " blocks of type " + ChatColor.GOLD + args[3] + ChatColor.GREEN + " have been removed from chunk at X: " + args[1] + " Z: " + args[2]);
				return true;

			}
			else
			{
				sender.sendMessage(ChatColor.RED + "That world does not exist.");
				return false;
			}

		}

		return false;

	}



}
