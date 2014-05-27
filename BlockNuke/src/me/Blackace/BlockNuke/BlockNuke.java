package me.Blackace.BlockNuke;

import java.util.logging.Logger;

import me.Blackace.BlockNuke.Commands.CommandChunkDestroy;
import me.Blackace.BlockNuke.Commands.CommandDestroy;
import me.Blackace.BlockNuke.Commands.CommandEntityKill;
import me.Blackace.BlockNuke.Commands.CommandGetBlock;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class BlockNuke extends JavaPlugin

{
	
	Logger monsterUtilLogger = Bukkit.getLogger();
	
	//configs
	
	
	//Listeners
	
	
	//Commands
	CommandDestroy monstercommands;
	CommandEntityKill entitykill;
	//CommandChunkDestroy chunkdestroy;
	CommandGetBlock commandgetblock;
	
	
	@Override
	public void onEnable()
	{
		
		
		//Load Command classes
		entitykill = new CommandEntityKill(this);
		monstercommands = new CommandDestroy(this);
		//chunkdestroy = new CommandChunkDestroy(this);
		commandgetblock = new CommandGetBlock(this);
		
		//Load Listeners

		
		//Logger
		monsterUtilLogger.info("Entity Death Listener has loaded Successfully!");
		
		//Substantiate Command objects
		this.getCommand("destroy").setExecutor(monstercommands);
		this.getCommand("worldname").setExecutor(monstercommands);
		this.getCommand("entitykill").setExecutor(entitykill);
		//this.getCommand("chunkdestroy").setExecutor(chunkdestroy);
		this.getCommand("getblock").setExecutor(commandgetblock);
	}
	
	@Override
	public void onDisable()
	{
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
}
