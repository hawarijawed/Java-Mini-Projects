package factory_design_pattern;

public class Warrior extends Character{
		String profession;
		public Warrior(String type, String name,int health, int life) {
			super(name, health, life);
			this.profession = type;
		}
		
		//Methods that describes this character
		@Override
		public void Showattack() {
			System.out.println(name+"'s attack: Skilled arm, Double kick, Butterfly kick, expert Hand to Hand combat ");
		}
		@Override
		public void Showdefence() {
			System.out.println(name+"'s defence: Double block, angle lock, footback, Sand trick etc.");
		}
		
		@Override
		public void Showweapons() {
			System.out.println(name+"'s weapons: Sword, Pistol, Guns, Knife, Bare Hands");
		}
		@Override
		public void ShowgetStrength() {
			System.out.println("Healt of character "+name+": "+health);
		}
		
		@Override
		public void Showappearance() {
			System.out.println(name+" has weared protective armor, and gloves foot is covered by metal shoes for protection"
					+ ". {0} has weared a heavy cloak around his body and tighten his shoot with lether belt"+name);
		}
		
}
